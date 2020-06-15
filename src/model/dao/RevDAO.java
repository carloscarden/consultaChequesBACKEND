package model.dao;

import java.util.ArrayList;

public interface RevDAO extends DAO {
	public Object load(Object obj)throws Exception ;
	public Object read(Object obj);
 	public ArrayList readAll()throws Exception;
	public void saveOrUpdate(Object obj)throws Exception;
}
