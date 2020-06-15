/*
 * Created on Oct 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model.dao.hibernate;
import java.util.ArrayList;

import model.HibernateUtil;
import model.Org;
import model.dao.OrgDAO;

import org.hibernate.Query;
import org.hibernate.Session;

public class OrgHibernateDAOImpl implements OrgDAO {

	public OrgHibernateDAOImpl() {
		super();
	}

	public ArrayList readAll() {
		return null;
	}
	public Object read(Object tipoOrg) {
		Org org;
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery =
				" from model.Org org where org.org = '"
			   + tipoOrg.toString().toUpperCase() + "'"; 
		    Query query = session.createQuery((String) strQuery);
			org = (Org) query.uniqueResult();
			tx.commit();
			HibernateUtil.closeSession();
			return org; 
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: Org " + e.getMessage());
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
