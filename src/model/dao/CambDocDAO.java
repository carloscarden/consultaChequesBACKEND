package model.dao;

import java.util.ArrayList;

public interface CambDocDAO extends DAO {
	public Object load(Object obj)throws Exception ;
	public Object read(Object obj);
	public Object read(int id);
	public ArrayList readAllFinal(String documento) throws Exception;
	public ArrayList readAllIntermedio(String documento) throws Exception;
 	public ArrayList readAll()throws Exception;
	public void saveOrUpdate(Object obj)throws Exception;
}
