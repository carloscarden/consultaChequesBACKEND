package controller;

import model.HibernateUtil;

import org.apache.struts.action.ActionServlet;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author ebuceta
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ConsultaChequesActionServlet extends ActionServlet {

	public ConsultaChequesActionServlet() {
		super();
		try {
			Session session = HibernateUtil.currentSession();
			HibernateUtil.closeSession();
		} catch (HibernateException e) {
			System.out.println("Error Accediendo al datasource");
			e.printStackTrace();
			System.exit(-1);
		}

	}

}
