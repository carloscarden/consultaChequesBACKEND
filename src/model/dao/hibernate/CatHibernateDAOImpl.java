/*
 * Created on Oct 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model.dao.hibernate;
import java.util.ArrayList;

import model.Cat;
import model.HibernateUtil;
import model.dao.CatDAO;

import org.hibernate.Query;
import org.hibernate.Session;

public class CatHibernateDAOImpl implements CatDAO {

	public CatHibernateDAOImpl() {
		super();
	}

	public ArrayList readAll() {
		return null;
	}
	public Object load(Object categ, Object esdeno) {
		Cat cat;
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery =
				" from model.Cat cat where cat.cat = '"
			   + categ.toString().toUpperCase() + "' and cat.es_deno =  '"
			   + esdeno.toString() + "'"; 
		    Query query = session.createQuery((String) strQuery);
			cat = (Cat) query.uniqueResult();
			tx.commit();
			HibernateUtil.closeSession();
			return cat; 
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: Cat " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}


	public Object read(Object obj) {
		return null;
	}

	public void write(Object o) {

	}

	public void saveOrUpdate(Object o) {

	}

}
