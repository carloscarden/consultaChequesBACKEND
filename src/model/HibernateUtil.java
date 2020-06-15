/*
 * Created on 26/07/2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static  ThreadLocal session;
	
	static {
		try {
			// Create the SessionFactory
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = new ThreadLocal();
		} catch (HibernateException ex) {
			ex.getCause();
		   ex.getMessage();

			throw new RuntimeException(
				"Configuration problem: " + ex.getMessage(),
				ex);
		} catch (ExceptionInInitializerError e2) {
			e2.getCause();
		   e2.getMessage();
		}
	}
	

	public static Session currentSession() throws HibernateException {
		Session s = (Session) session.get();
		// Open a new Session, if this Thread has none yet
		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}
	public static void closeSession() throws HibernateException {
		Session s = (Session) session.get();
		session.set(null);
		if (s != null)
			s.close();
	}
}