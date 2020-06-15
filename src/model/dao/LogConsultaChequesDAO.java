package model.dao;

import java.util.ArrayList;

public interface LogConsultaChequesDAO extends DAO {
	
	public Object load(Object obj)throws Exception ;
	public ArrayList readAll()throws Exception;
	public Object read(int id);
 	public ArrayList readAll(String usuario)throws Exception;
	public void saveOrUpdate(Object obj)throws Exception;
	 
}
