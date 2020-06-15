package model.dao;

import java.util.ArrayList;

public interface EcargoDAO extends DAO {
	public Object load(Object obj)throws Exception ;
	public Object read(Object obj);
 	public ArrayList readAll(String str)throws Exception;
	public ArrayList readApyn(String str)throws Exception;
	public void saveOrUpdate(Object obj)throws Exception;
}
