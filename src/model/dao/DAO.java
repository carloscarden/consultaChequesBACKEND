package model.dao;

public interface DAO {

  public Object read(Object obj)throws Exception;
  public void write(Object obj)throws Exception;
}
