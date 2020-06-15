package model.dao;

import java.util.ArrayList;

public interface DepDAO extends DAO {
	public Object load(Object obj)throws Exception ;
	public Object read(Object obj);
	public Object read(int dependencia);
 	public ArrayList readAll()throws Exception;
	public void saveOrUpdate(Object obj)throws Exception;
}
