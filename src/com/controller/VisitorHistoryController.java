package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VisitorHistoryDAO;

@WebServlet("/history")
public class VisitorHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private VisitorHistoryDAO dao;
    
	public VisitorHistoryController() throws ClassNotFoundException {
        super();
        dao = new VisitorHistoryDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("visitorList", dao.listAll());
		RequestDispatcher view = request.getRequestDispatcher("/history.jsp");
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
