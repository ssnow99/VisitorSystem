package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import com.common.DateUtil;
import com.common.DbConn;
import com.ip2location.IP2Location;
import com.ip2location.IPResult;
import com.model.VisitorHistory;

public class VisitorHistoryDAO {
	
	private static final Logger log = Logger.getLogger("VisitorHistoryDAO");
	
	private Connection conn;
	
	public VisitorHistoryDAO() throws ClassNotFoundException {
		conn = DbConn.getConn();
	}
	
	public void add(HttpSession session, String ipAddress) {
		IPResult ipResult = getIp2Location(session, ipAddress);
		VisitorHistory visitorHistory = new VisitorHistory();
		if (ipResult != null) {
			visitorHistory.setIpAddress(ipAddress);
			visitorHistory.setCountryCode(ipResult.getCountryShort());
			visitorHistory.setCountryName(ipResult.getCountryLong());
			visitorHistory.setRegionName(ipResult.getRegion());
			visitorHistory.setCityName(ipResult.getCity());
			visitorHistory.setLastVisitedDate(new Date());
		} else {
			visitorHistory.setIpAddress(ipAddress);
			visitorHistory.setCountryCode("-");
			visitorHistory.setCountryName("-");
			visitorHistory.setRegionName("-");
			visitorHistory.setCityName("-");
			visitorHistory.setLastVisitedDate(new Date());
		}
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO visitor_history (ip_address, country_code, country_name, region_name, city_name, last_visited_date) VALUES (?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, visitorHistory.getIpAddress());
			preparedStatement.setString(2, visitorHistory.getCountryCode());
			preparedStatement.setString(3, visitorHistory.getCountryName());
			preparedStatement.setString(4, visitorHistory.getRegionName());
			preparedStatement.setString(5, visitorHistory.getCityName());
			preparedStatement.setString(6, DateUtil.parseDateToString(visitorHistory.getLastVisitedDate(), DateUtil.DATE_TIME_FORMAT));
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		
	}

	private IPResult getIp2Location(HttpSession session, String ipAddress) {
		IP2Location loc = new IP2Location();
		try {
			String binFile = session.getServletContext().getRealPath("/") + "resources/IP2LOCATION-LITE-DB3.BIN";
			
			loc.Open(binFile, true);
			
			IPResult ipResult = loc.IPQuery(ipAddress);
			if (ipResult.getStatus().equals("OK")) {
				return ipResult;
			}
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			loc.Close();
		}
		return null;
	}
	
	public List<VisitorHistory> listAll() {
		List<VisitorHistory> list = new ArrayList<VisitorHistory>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM visitor_history ORDER BY last_visited_date DESC");
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				VisitorHistory visitorHistory = new VisitorHistory();
				visitorHistory.setId(rs.getLong("id"));
				visitorHistory.setIpAddress(rs.getString("ip_address"));
				visitorHistory.setCountryCode(rs.getString("country_code"));
				visitorHistory.setCountryName(rs.getString("country_name"));
				visitorHistory.setRegionName(rs.getString("region_name"));
				visitorHistory.setCityName(rs.getString("city_name"));
				visitorHistory.setLastVisitedDateStr(rs.getString("last_visited_date"));
				list.add(visitorHistory);
			}
			return list;
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		return null;
	}
	
}
