package model.dao;

import java.util.ArrayList;

public interface VInfoCheqDAO extends DAO {
	public Object load(Object obj)throws Exception ;
	public Object read(Object obj);
	public Object read(String documento, int secu, String fecha, int fecAfec, int opid, int nrocheq);
 	public ArrayList readAll(String documento,String secuencia, String periodo)throws Exception;
	public void saveOrUpdate(Object obj)throws Exception;
}
