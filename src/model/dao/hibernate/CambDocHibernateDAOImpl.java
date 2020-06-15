/*
 * Created on Oct 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model.dao.hibernate;
import java.util.ArrayList;

import model.CambDoc;
import model.HibernateUtil;
import model.dao.CambDocDAO;

import org.hibernate.Query;
import org.hibernate.Session;

public class CambDocHibernateDAOImpl implements CambDocDAO {

	public CambDocHibernateDAOImpl() {
		super();
	}

	public ArrayList readAll() {
		return null;
	}
	public Object read(Object obj) {
		return null;
	}
	
	public Object read(int id) {
		String strQuery;
		CambDoc cdoc = new CambDoc();
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery =
				" from model.CambDoc cdoc where cdoc.idcambdoc = "
				   + id; 

			Query query = session.createQuery((String) strQuery);
			cdoc = (CambDoc) query.uniqueResult();

			tx.commit();
			HibernateUtil.closeSession();
			return cdoc;
		} catch (Exception e) {
			System.out.println("EXCEPTION!!! : CambDoc " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	
	public ArrayList readAllFinal(String documento) {
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery =
				" from model.CambDoc cdoc where cdoc.docunew = '"
				   + documento.toUpperCase() + "'"
				   + " and cdoc.vigh = '01/12/9999'"; 

			ArrayList query =
				(ArrayList) session.createQuery(strQuery).list();
			tx.commit();
			HibernateUtil.closeSession();
			return query;
		} catch (Exception e) {
			System.out.println("EXCEPTION!!! : CambDoc " + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList readAllIntermedio(String documento) {
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery =
					" from model.CambDoc cdoc where cdoc.docunew = '"
					   + documento.toUpperCase() + "'"
					   + " and cdoc.vigh <> '01/12/9999'";

			ArrayList query =
				(ArrayList) session.createQuery(strQuery).list();
			tx.commit();
			HibernateUtil.closeSession();
			return query;
		} catch (Exception e) {
			System.out.println("EXCEPTION!!! : CambDoc " + e.getMessage());
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
