package model.dao;

import java.util.ArrayList;

public interface VDetalleDAO extends DAO {
	public Object load(Object obj)throws Exception ;
	public Object read(Object obj);
 	public ArrayList readAll(int liqid)throws Exception;
	public void saveOrUpdate(Object obj)throws Exception;
}
