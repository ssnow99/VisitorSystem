package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VisitorHistoryDAO;
import com.mysql.jdbc.StringUtils;

@WebServlet("/")
public class WelcomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private VisitorHistoryDAO vdao;
	
    public WelcomeController() throws ClassNotFoundException {
        super();
        vdao = new VisitorHistoryDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ipAddress = StringUtils.isNullOrEmpty(request.getHeader("X-FORWARDED-FOR")) ? request.getRemoteAddr() : request.getHeader("X-FORWARDED-FOR");
		vdao.add(request.getSession(), ipAddress);

		RequestDispatcher view = request.getRequestDispatcher("/welcome.jsp");
		view.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
