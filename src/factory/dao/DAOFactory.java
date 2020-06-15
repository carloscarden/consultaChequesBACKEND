/*
 * Created on 06/10/2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package factory.dao;

import model.dao.CambDocDAO;
import model.dao.CatDAO;
import model.dao.DepDAO;
import model.dao.EcargoDAO;
import model.dao.EstabDAO;
import model.dao.LogConsultaChequesDAO;
import model.dao.OrgDAO;
import model.dao.PersDAO;
import model.dao.RevDAO;
import model.dao.VDetalleDAO;
import model.dao.VEDetalleDAO;
import model.dao.VEInfoCheqDAO;
import model.dao.VInfoCheqDAO;

public interface DAOFactory {
	public PersDAO getPersDAO();
	public CatDAO getCatDAO();
	public RevDAO getRevDAO();
	public DepDAO getDepDAO();
	public OrgDAO getOrgDAO();
	public EstabDAO getEstabDAO();
	public EcargoDAO getEcargoDAO();
	public VDetalleDAO getVDetalleDAO();
	public VEDetalleDAO getVEDetalleDAO();
	public VInfoCheqDAO getVInfoCheqDAO();
	public VEInfoCheqDAO getVEInfoCheqDAO();
	public CambDocDAO getCambDocDAO();
	public LogConsultaChequesDAO getLogConsultaChequesDAO();
}
