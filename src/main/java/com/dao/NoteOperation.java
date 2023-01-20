package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.models.NoteData;

public class NoteOperation implements DBOperation {
	
	Connection conn = null;
	
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
		try(PreparedStatement stmt=conn.prepareStatement("select note from note_data  where id=?")) { 
			stmt.setInt(1, (Integer)obj);
			ResultSet rs=stmt.executeQuery();  
			while(rs.next()){  
				note = rs.getString("notes");
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
		try(PreparedStatement stmt=conn.prepareStatement("insert into note_data (uname,title,note) values (?,?,?)")) { 
			stmt.setString(1, noteData.getUserName());
			stmt.setString(2, noteData.getTitle());
			stmt.setString(3, noteData.getNote());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}

}
