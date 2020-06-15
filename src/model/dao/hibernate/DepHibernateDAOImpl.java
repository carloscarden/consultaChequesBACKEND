/*
 * Created on Oct 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model.dao.hibernate;
import java.util.ArrayList;

import model.Dep;
import model.HibernateUtil;
import model.dao.DepDAO;

import org.hibernate.Query;
import org.hibernate.Session;

public class DepHibernateDAOImpl implements DepDAO {

	public DepHibernateDAOImpl() {
		super();
	}

	public ArrayList readAll() {
		return null;
	}
	public Object read(int dependencia) {
		Dep dep;
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery =
				" from model.Dep dep where dep.dep = "
			   + dependencia; 
		    Query query = session.createQuery((String) strQuery);
			dep = (Dep) query.uniqueResult();
			tx.commit();
			HibernateUtil.closeSession();
			return dep; 
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: Dep " + e.getMessage());
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
