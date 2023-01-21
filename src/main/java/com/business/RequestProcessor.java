package com.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dao.NoteOperation;
import com.models.NoteData;
import org.apache.commons.lang3.StringUtils;

public class RequestProcessor {
	
	private RequestProcessor() {}
	
	public static RequestProcessor getInstance() {
		return new RequestProcessor();
	}
	
	public String processRequest(HttpServletRequest request) {
		
		NoteData noteData = new NoteData();
		noteData.setUserName(request.getParameter("uname"));
		noteData.setTitle(request.getParameter("title"));
		noteData.setNote(request.getParameter("note"));
		if(StringUtils.equalsAny(request.getRequestURI(),"/Notepad/savenote")) {
			return addNewNote(noteData);
		}
		return "";
	}
	
	public List<NoteData> getAllNotes() {
		return NoteOperation.getInstance().getAllData();
	}
	
	private String addNewNote(NoteData noteData) {
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
