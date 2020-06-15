/*
 * Created on Oct 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model.dao.hibernate;
import java.util.ArrayList;
import java.util.Date;

import model.Estab;
import model.HibernateUtil;
import model.dao.EstabDAO;

import org.hibernate.Query;
import org.hibernate.Session;


public class EstabHibernateDAOImpl implements EstabDAO {

	public EstabHibernateDAOImpl() {
		super();
	}

	public ArrayList readAll() {
		return null;
	}
	public Object read(int escuid, Date vigencia) {
		Estab estab;
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery =
				" from model.Estab estab where estab.escuid = "
			   + escuid + " and '" + vigencia + "' between estab.vigd and estab.vigh"; 
		    Query query = session.createQuery((String) strQuery);
			estab = (Estab) query.uniqueResult();
			tx.commit();
			HibernateUtil.closeSession();
			return estab; 
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: Estab " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public Object read(Object obj) {
		return null;
	}


	public Object load(Object obj) {
		return null;
	}

	public void write(Object o) {

	}

	public void saveOrUpdate(Object o) {

	}

}
