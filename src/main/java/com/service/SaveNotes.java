package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.RequestProcessor;

@WebServlet("/savenote")
public class SaveNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SaveNotes() {
        super();
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String afterCommit = RequestProcessor.getInstance().processRequest(request);
		
		try {
			PrintWriter writer = response.getWriter();
			response.setContentType("text/html");
			writer.println("<h2 style='text-align:center;'>"+afterCommit+"</h2>");
			writer.println("<h2 style='text-align:center;'><a href='allnotes.jsp'>Click here to see all notes</h2>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
