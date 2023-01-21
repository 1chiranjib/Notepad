package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.NoteData;

public class NoteOperation implements DBOperation <NoteData> {
	
	Connection conn = null;
	
	private static final String FIND_NOTE = "select note from note_data  where id=?";
	private static final String INSERT_NOTE = "insert into note_data (uname,title,note) values (?,?,?)";
	private static final String FETCH_ALL_DATA = "select uname,title,note from note_data";
	
	public static NoteOperation getInstance() {
		return new NoteOperation();
	}
	
	public void createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notepad","root","1998");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public Object findData(Object obj) {
		String note = "";
		createConnection();
		try(PreparedStatement stmt=conn.prepareStatement(FIND_NOTE)) { 
			stmt.setInt(1, (Integer)obj);
			ResultSet rs=stmt.executeQuery();  
			while(rs.next()){  
				note = rs.getString("note");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return note;
	}


	@Override
	public Object saveData(Object obj) {
		NoteData noteData = (NoteData)obj;
		createConnection();
		try(PreparedStatement stmt=conn.prepareStatement(INSERT_NOTE)) { 
			stmt.setString(1, noteData.getUserName());
			stmt.setString(2, noteData.getTitle());
			stmt.setString(3, noteData.getNote());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	@Override
	public List<NoteData> getAllData(){
		List<NoteData> allData = new ArrayList<>();
		createConnection();
		try(PreparedStatement stmt=conn.prepareStatement(FETCH_ALL_DATA)) { 
			ResultSet rs=stmt.executeQuery();  
			while(rs.next()){ 
				NoteData data = new NoteData();
				data.setUserName(rs.getString("uname"));
				data.setTitle(rs.getString("title"));
				data.setNote(rs.getString("note"));
				allData.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allData;
	}

}
