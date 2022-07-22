package com.model;

import java.util.Date;

public class VisitorHistory {

	private Long id;
	private String ipAddress;
	private String countryCode;
	private String countryName;
	private String regionName;
	private String cityName;
	private Date lastVisitedDate;
	private String lastVisitedDateStr;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Date getLastVisitedDate() {
		return lastVisitedDate;
	}
	public void setLastVisitedDate(Date lastVisitedDate) {
		this.lastVisitedDate = lastVisitedDate;
	}
	public String getLastVisitedDateStr() {
		return lastVisitedDateStr;
	}
	public void setLastVisitedDateStr(String lastVisitedDateStr) {
		this.lastVisitedDateStr = lastVisitedDateStr;
	}
	
}
