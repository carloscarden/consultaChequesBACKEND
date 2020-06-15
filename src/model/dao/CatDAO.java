package model.dao;

import java.util.ArrayList;

public interface CatDAO extends DAO {
	public Object load(Object obj, Object obj1)throws Exception ;
	public Object read(Object obj);
 	public ArrayList readAll()throws Exception;
	public void saveOrUpdate(Object obj)throws Exception;
}
