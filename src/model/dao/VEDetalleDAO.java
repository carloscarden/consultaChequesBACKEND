package model.dao;

import java.util.ArrayList;

public interface VEDetalleDAO extends DAO {
	public Object load(Object obj)throws Exception ;
	public Object read(Object obj);
 	public ArrayList readAll(int liqid, int periodo)throws Exception;
	public void saveOrUpdate(Object obj)throws Exception;
}
