package com.business;

import javax.servlet.http.HttpServletRequest;

import com.dao.NoteOperation;
import com.models.NoteData;
import org.apache.commons.lang3.StringUtils;

public class RequestProcessor {
	
	private RequestProcessor() {
		
	}
	
	public static RequestProcessor getInstance() {
		return new RequestProcessor();
	}
	
	public String processRequest(HttpServletRequest request) {
		
		NoteData noteData = new NoteData();
		noteData.setUserName(request.getParameter("uname"));
		noteData.setTitle(request.getParameter("title"));
		noteData.setNote(request.getParameter("note"));
		
		if(StringUtils.isNotEmpty(noteData.getUserName())
				&&StringUtils.isNotEmpty(noteData.getTitle())
				&&StringUtils.isNotEmpty(noteData.getNote())) {
			int response = (Integer)NoteOperation.getInstance().saveData(noteData);
			return response == 1?"Note saved successfully!!":"Unable to save yournote. Please try again.";
		}
		else
			return "Empty inputs are not allowed! Please try again.";
	}
}
