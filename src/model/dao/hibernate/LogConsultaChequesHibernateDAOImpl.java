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
import model.LogConsultaCheques;
import model.dao.LogConsultaChequesDAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class LogConsultaChequesHibernateDAOImpl implements LogConsultaChequesDAO {

	public LogConsultaChequesHibernateDAOImpl() {
		super();
	}

	public ArrayList readAll() {
		
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery = " from model.LogConsultaCheques ";
								
			ArrayList query = (ArrayList)session.createQuery((String) strQuery).list();
			tx.commit();
			HibernateUtil.closeSession();
			return query;
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: LogConsultaCheques " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}


	public Object read(int id) {
		LogConsultaCheques pers;
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery = " from model.LogConsultaCheques pers where pers.id = " + id;
			Query query = session.createQuery((String) strQuery);
			pers = (LogConsultaCheques) query.uniqueResult();
			tx.commit();
			HibernateUtil.closeSession();
			return pers;
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: LogConsultaCheques " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public Object load(Object obj) {
		return null;
	}	
		
	public ArrayList readAll(String usuario) {
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery ="select pers.docuConsulta, pers.ejercicioConsulta from model.LogConsultaCheques pers where pers.usuario like '"
				+ usuario.toUpperCase() 
				+ "%' group by pers.docuConsulta, pers.ejercicioConsulta order by pers.docuConsulta";
				
			ArrayList query = (ArrayList)session.createQuery((String) strQuery).list();
			ArrayList result = new ArrayList();	
			Iterator it = query.iterator();	
			while (it.hasNext()) {
				Object[] obj = (Object[]) it.next();
				LogConsultaCheques pers = new LogConsultaCheques();
				pers.setDocuConsulta(obj[0].toString());
				pers.setEjercicioConsulta(Integer.valueOf(obj[1].toString()));
				result.add(pers);
			}

			tx.commit();
			HibernateUtil.closeSession();
			return result;
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: LogConsulta " + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}
		
	public void write(Object o) {
		
	}
	public Object read(Object o) {
		return null;
	}
	
	public void saveOrUpdate(Object o) throws Exception {
		LogConsultaCheques obs = (LogConsultaCheques) o;
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.currentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(obs);
			tx.commit();
		} catch (HibernateException e1) {
			try {
				if (tx != null) {
					tx.rollback();
					throw new Exception("Error en la transaction "
							+ e1.getMessage());
				}
			} catch (HibernateException e2) {
				throw new Exception("Error en la transaction" + e2.getMessage());
			}
		} finally {
			try {
				HibernateUtil.closeSession();
			} catch (HibernateException e) {
				throw new Exception("Error en la session" + e.getMessage());
			}
		}

	}
}
