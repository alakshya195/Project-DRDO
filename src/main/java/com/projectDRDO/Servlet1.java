package com.projectDRDO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.DoubleAdder;

import com.dao.copy.dbConnection;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */

public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		RequestDispatcher rd = request.getRequestDispatcher("default.jsp");
		
		
		ArrayList<aircraftData> val = new ArrayList<>();
		
		long startTime = System.currentTimeMillis();
		
		val = dbConnection.getConnection();
		System.out.println("val size =" + val.size());

		long endTime = System.currentTimeMillis();
		float actualTime = (endTime - startTime)/1000F;

		System.out.println("Total time taken to read all records: " + (actualTime) + "seconds");

		request.setAttribute("data", val);
		request.setAttribute("times", actualTime);
		request.setAttribute("sizes", val.size());

		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

