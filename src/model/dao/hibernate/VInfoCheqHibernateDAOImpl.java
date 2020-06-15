/*
 * Created on Oct 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model.dao.hibernate;
import java.util.ArrayList;

import model.HibernateUtil;
import model.VInfoCheq;
import model.dao.VInfoCheqDAO;

import org.hibernate.Query;
import org.hibernate.Session;

public class VInfoCheqHibernateDAOImpl implements VInfoCheqDAO {

	public VInfoCheqHibernateDAOImpl() {
		super();
	}

	public ArrayList readAll(String documento, String secuencia, String periodo) {
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			if (!secuencia.equals("")) {
				strQuery =
					"from model.VInfoCheq as infocheq where infocheq.docu = '"
						+ documento.toUpperCase()
						+ "' and infocheq.secu = "
						+ Integer.parseInt(secuencia)
						+ " and infocheq.perOpago = "
						+ Integer.parseInt(periodo)
						+ " and infocheq.muestra = 'S'";
			}
			else {
			strQuery =
				"from model.VInfoCheq as infocheq where infocheq.docu = '"
					+ documento.toUpperCase()
					+ "'"
					+ " and infocheq.perOpago = "
					+ Integer.parseInt(periodo)
					+ " and infocheq.muestra = 'S'";

			} 
			ArrayList query =
				(ArrayList) session.createQuery((String) strQuery).list();
			tx.commit();
			HibernateUtil.closeSession();
			return query;
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: Vinfocheq" + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}
	public Object read(String documento, int secu, String fecha, int fecAfec, int opid, int nrocheq) {
	VInfoCheq infocheq;
	String strQuery;
	try {
		Session session = HibernateUtil.currentSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		strQuery =
		"from model.VInfoCheq as infocheq where infocheq.docu = '"
			+ documento.toUpperCase()
			+ "' and infocheq.secu = "
			+ secu
			+ " and infocheq.perOpago = "
			+ Integer.parseInt(fecha)
			+ " and infocheq.fecAfec = "
			+ fecAfec 
			+ " and infocheq.opid = "
			+ opid
			+ " and infocheq.nroCheq = "
			+ nrocheq

			+ " order by infocheq.perOpago, infocheq.secu, infocheq.fecAfec" ;

		Query query = session.createQuery((String) strQuery);
		infocheq = (VInfoCheq) query.uniqueResult();
		tx.commit();
		HibernateUtil.closeSession();
		return infocheq;
	} catch (Exception e) {
		System.out.println("EXCEPTION!!!: VInfoCheq " + e.getMessage());
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
