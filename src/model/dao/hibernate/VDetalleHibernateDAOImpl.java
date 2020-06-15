/*
 * Created on Oct 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model.dao.hibernate;
import java.util.ArrayList;

import model.HibernateUtil;
import model.dao.VDetalleDAO;

import org.hibernate.Session;


public class VDetalleHibernateDAOImpl implements VDetalleDAO {

	public VDetalleHibernateDAOImpl() {
		super();
	}

	public ArrayList readAll(int liqid) {
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery =
				"from model.VDetalle as vdetalle where vdetalle.liqid = "
					+ liqid;

			ArrayList query =
				(ArrayList) session.createQuery(strQuery).list();
			tx.commit();
			HibernateUtil.closeSession();
			return query;
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: VDetalle " + e.getMessage());
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
