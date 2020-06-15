/*
 * Created on Oct 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model.dao.hibernate;
import java.util.ArrayList;
import java.util.Iterator;

import model.HibernateUtil;
import model.Pers;
import model.dao.PersDAO;

import org.hibernate.Query;
import org.hibernate.Session;


public class PersHibernateDAOImpl implements PersDAO {

	public PersHibernateDAOImpl() {
		super();
	}

	public ArrayList readAll() {
		ArrayList dis;
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery =
				" from model.Pers ";
								
			ArrayList query = (ArrayList)session.createQuery((String) strQuery).list();
			tx.commit();
			HibernateUtil.closeSession();
			return query;
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: Persona" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}


	public Object read(Object documento, int fecha) {
		Pers pers;
		String strQuery;
		try {
			Integer per = new Integer(fecha);
			int periodo = per.intValue();
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery =
				" from model.Pers pers where pers.docu = '"
			   + documento + "'" 
			  + " and " + periodo + " between year(pers.vigd) and year(pers.vigh)";
			Query query = session.createQuery((String) strQuery);
			pers = (Pers) query.uniqueResult();
			tx.commit();
			HibernateUtil.closeSession();
			return pers;
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: Persona" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public Object read(Object documento) {
		Pers pers;
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery =
				" from model.Pers pers where pers.docu = '"
			   + (String) documento + "'" 
			  + " and pers.vigh = '01/12/9999'";
			Query query = session.createQuery((String) strQuery);
			pers = (Pers) query.uniqueResult();
			tx.commit();
			HibernateUtil.closeSession();
			return pers;
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: Persona" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public Object load(Object obj) {
		return null;
	}	
		
	public ArrayList readAll(String apyn) {
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery =
				"select pers.nombre, pers.docu from model.Pers pers where pers.nombre like '"
				+ apyn.toUpperCase() 
				+ "%' group by pers.docu, pers.nombre order by pers.docu";
				
			ArrayList query = (ArrayList)session.createQuery((String) strQuery).list();
			ArrayList result = new ArrayList();	
			Iterator it = query.iterator();	
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				Pers pers = new Pers();
				pers.setNombre(obj[0].toString());
				pers.setDocu(obj[1].toString());
				result.add(pers);
			}

			tx.commit();
			HibernateUtil.closeSession();
			return result;
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: Persona" + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}
		
	public void write(Object o) {
		
	}
	
	public void saveOrUpdate(Object o) {
	
	}
}
