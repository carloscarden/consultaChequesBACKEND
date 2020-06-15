/*
 * Created on Oct 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model.dao.hibernate;
import java.util.ArrayList;
import java.util.Iterator;

import model.Ecargo;
import model.HibernateUtil;
import model.dao.EcargoDAO;

import org.hibernate.Session;


public class EcargoHibernateDAOImpl implements EcargoDAO {

	public EcargoHibernateDAOImpl() {
		super();
	}

	public ArrayList readAll(String documento) {
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery =
				" from model.Ecargo ecargo where ecargo.docu = '"
					+ documento
					+ "'";

			ArrayList query =
				(ArrayList) session.createQuery((String) strQuery).list();
			tx.commit();
			HibernateUtil.closeSession();
			return query;
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: Ecargo" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList readApyn(String apyn) {
			String strQuery;
			try {
				Session session = HibernateUtil.currentSession();
				org.hibernate.Transaction tx = session.beginTransaction();
				strQuery =
					"select ecargo.apynom, ecargo.docu from model.Ecargo ecargo where ecargo.apynom like '"
						+ apyn.toUpperCase() 
						+ "%' group by ecargo.apynom, ecargo.docu order by ecargo.docu";

				ArrayList query =
					(ArrayList) session.createQuery((String) strQuery).list();
				ArrayList result = new ArrayList();	
				Iterator it = query.iterator();	
				while (it.hasNext()) {
					Object[] obj = (Object[]) it.next();
					Ecargo ecargo = new Ecargo();
					ecargo.setApynom(obj[0].toString());
					ecargo.setDocu(obj[1].toString());
					result.add(ecargo);
				}
				tx.commit();
				HibernateUtil.closeSession();
				return result;
			} catch (Exception e) {
				System.out.println("EXCEPTION!!!: Ecargo" + e.getMessage());
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
