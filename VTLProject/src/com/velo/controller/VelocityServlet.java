package com.velo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.velo.bean.User;

/**
 * Servlet implementation class VelocityServlet
 */

public class VelocityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(getClass());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VelocityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            // simulate a database query
            List<User> users = new ArrayList<User>();
            for (int i = 0; i < 5; i++) {
                User user = new User("name "+i, "Address "+i);
                users.add(user);
            }
            // set values
            request.setAttribute("users", users);
 
            // get UI
            RequestDispatcher requestDispatcher =  request.getRequestDispatcher("index.vm");
            requestDispatcher.forward(request, response);
        } catch(Exception ex){
            logger.error(ex);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
