package com.dao;

import java.util.List;

public interface DBOperation <T> {

	public Object findData(Object obj);
	public Object saveData(Object obj);
	public List<T> getAllData();

}
