package model.dao;

import java.util.ArrayList;
import java.util.Date;

public interface EstabDAO extends DAO {
	public Object load(Object obj)throws Exception ;
	public Object read(Object obj);
	public Object read(int escuid, Date vigencia);
 	public ArrayList readAll()throws Exception;
	public void saveOrUpdate(Object obj)throws Exception;
}
