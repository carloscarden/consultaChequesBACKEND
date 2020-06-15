/*
 * Created on Oct 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model.dao.hibernate;
import java.util.ArrayList;

import model.HibernateUtil;
import model.VEInfoCheq;
import model.dao.VEInfoCheqDAO;

import org.hibernate.Query;
import org.hibernate.Session;

public class VEInfoCheqHibernateDAOImpl implements VEInfoCheqDAO {

	public VEInfoCheqHibernateDAOImpl() {
		super();
	}

	public ArrayList readAll(String documento,String secuencia, String anio) {
		String strQuery;
		String strDocu;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			if ((documento.substring(0,1).toUpperCase().equals("F"))||(documento.substring(0,1).toUpperCase().equals("M") ))
				strDocu = " where (einfocheq.docu = '"+documento.toUpperCase()+
                                 "' or einfocheq.docu = '0"+
			                     documento.substring(1,8)+"')";
			else
				strDocu = " where (einfocheq.docu = '"+documento.toUpperCase()+"')";
			if (!secuencia.equals("")) {	
			strQuery =
				"from model.VEInfoCheq as einfocheq "
					+ strDocu
					+ " and einfocheq.secu = "
					+ Integer.parseInt(secuencia)
					+ " and einfocheq.perOpago/100 = "
					+ Integer.parseInt(anio)
					+ " order by einfocheq.perOpago, einfocheq.secu";
			}
			else {
				strQuery =
					"from model.VEInfoCheq as einfocheq "
						+ strDocu
						+ " and einfocheq.perOpago/100 = "
						+ Integer.parseInt(anio)
						+ " order by einfocheq.perOpago, einfocheq.secu";
			}
			ArrayList query =
				(ArrayList) session.createQuery((String) strQuery).list();
			tx.commit();
			HibernateUtil.closeSession();
			return query;
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: Veinfocheq" + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}
	
	public Object read(String documento, int secu, int opid, String fecha, 
			String nroCheq, String cat,String cargo, String item,String apart,String numero) {
		VEInfoCheq einfocheq;
		String strQuery;
		try {
			Session session = HibernateUtil.currentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			strQuery =
			"from model.VEInfoCheq as einfocheq where einfocheq.docu = '"
				+ documento.toUpperCase()
				+ "' and einfocheq.secu = "
				+ secu
				+ " and einfocheq.opid = "
				+ opid
				+ " and einfocheq.perOpago = "
				+ Integer.parseInt(fecha)
			    + " and einfocheq.nroCheq = "
				+ Integer.parseInt(nroCheq)
				+ " and einfocheq.cargo = "
				+ cargo
				+ " and einfocheq.item = "
				+ item
				+ " and einfocheq.apart = "
				+ apart
				+ " and einfocheq.numero = "
				+ numero
				+ " and einfocheq.cat = '"
				+ cat + "'";


			Query query = session.createQuery((String) strQuery);
			einfocheq = (VEInfoCheq) query.uniqueResult();
			tx.commit();
			HibernateUtil.closeSession();
			return einfocheq;
		} catch (Exception e) {
			System.out.println("EXCEPTION!!!: VEInfoCheq " + e.getMessage());
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
