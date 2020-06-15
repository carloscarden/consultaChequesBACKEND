package model.dao;

import java.util.ArrayList;

public interface VEInfoCheqDAO extends DAO {
	public Object load(Object obj)throws Exception ;
	public Object read(Object obj);
	public Object read(String documento, int secu, int opid, String fecha, String nroCheq, String cat,String cargo, String item,String apart,String numero);
 	public ArrayList readAll(String documento, String secuencia, String anio)throws Exception;
	public void saveOrUpdate(Object obj)throws Exception;
}
