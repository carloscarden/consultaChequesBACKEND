/*
 * Created on 06/10/2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package factory.impl;
import model.dao.CambDocDAO;
import model.dao.CatDAO;
import model.dao.DepDAO;
import model.dao.EcargoDAO;
import model.dao.EstabDAO;
import model.dao.LogConsultaChequesDAO;
import model.dao.OrgDAO;
import model.dao.PersDAO;
import model.dao.RevDAO;
import model.dao.VDetalleDAO;
import model.dao.VEDetalleDAO;
import model.dao.VEInfoCheqDAO;
import model.dao.VInfoCheqDAO;
import model.dao.hibernate.CambDocHibernateDAOImpl;
import model.dao.hibernate.CatHibernateDAOImpl;
import model.dao.hibernate.DepHibernateDAOImpl;
import model.dao.hibernate.EcargoHibernateDAOImpl;
import model.dao.hibernate.EstabHibernateDAOImpl;
import model.dao.hibernate.LogConsultaChequesHibernateDAOImpl;
import model.dao.hibernate.OrgHibernateDAOImpl;
import model.dao.hibernate.PersHibernateDAOImpl;
import model.dao.hibernate.RevHibernateDAOImpl;
import model.dao.hibernate.VDetalleHibernateDAOImpl;
import model.dao.hibernate.VEDetalleHibernateDAOImpl;
import model.dao.hibernate.VEInfoCheqHibernateDAOImpl;
import model.dao.hibernate.VInfoCheqHibernateDAOImpl;
import factory.dao.DAOFactory;

public class ImplementationDAOFactory implements DAOFactory {
	public PersDAO getPersDAO() {
		return new PersHibernateDAOImpl();
	}
	public CatDAO getCatDAO() {
		return new CatHibernateDAOImpl();
	}
	
	public RevDAO getRevDAO() {
			return new RevHibernateDAOImpl();
	}
		
	public DepDAO getDepDAO() {
		return new DepHibernateDAOImpl();
	}
	
	public OrgDAO getOrgDAO() {
			return new OrgHibernateDAOImpl();
	}
	
	public EstabDAO getEstabDAO() {
			return new EstabHibernateDAOImpl();
	}
	
	public EcargoDAO getEcargoDAO() {
		return new EcargoHibernateDAOImpl();
    }
    
	public VDetalleDAO getVDetalleDAO() {
		return new VDetalleHibernateDAOImpl();
	}		
    
	public VEDetalleDAO getVEDetalleDAO() {
    	return new VEDetalleHibernateDAOImpl();
	}		
    
	public VInfoCheqDAO getVInfoCheqDAO() {
		return new VInfoCheqHibernateDAOImpl();
	}
			
	public VEInfoCheqDAO getVEInfoCheqDAO() {
		return new VEInfoCheqHibernateDAOImpl();
	}		

	public CambDocDAO getCambDocDAO() {
		return new CambDocHibernateDAOImpl();
	}
	//@Override
	public LogConsultaChequesDAO getLogConsultaChequesDAO() {
		// TODO Auto-generated method stub
		return new LogConsultaChequesHibernateDAOImpl();
	}		
	    
}
