package model.dao;

import java.util.ArrayList;

public interface PersDAO extends DAO {
	public Object load(Object obj)throws Exception ;
	public Object read(Object obj);
 	public Object read(Object obj, int fecha);
	public ArrayList readAll()throws Exception;
	public ArrayList readAll(String apyn)throws Exception;
	public void saveOrUpdate(Object obj)throws Exception;
}
