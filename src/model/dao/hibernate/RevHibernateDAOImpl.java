/*
 * Created on Oct 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model.dao.hibernate;
import java.util.ArrayList;

import model.HibernateUtil;
import model.Rev;
import model.dao.RevDAO;

import org.hibernate.Query;
import org.hibernate.Session;

public class RevHibernateDAOImpl implements RevDAO {

	public RevHibernateDAOImpl() {
		super();
	}

	public ArrayList readAll() {
		return null;
	}
	public Object read(Object crev) {
		Rev rev;
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery =
				" from model.Rev rev where rev.rev = '"
			   + crev.toString().toUpperCase() + "'"; 
		    Query query = session.createQuery( strQuery);
			rev = (Rev) query.uniqueResult();
			tx.commit();
			HibernateUtil.closeSession();
			return rev; 
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: Rev " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}


	public Object load(Object obj) {
		return null;
	}

	public void write(Object o) {

	}

	public void saveOrUpdate(Object o) {

	}

}
