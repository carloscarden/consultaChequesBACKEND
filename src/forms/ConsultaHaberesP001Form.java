package forms;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.ImageButtonBean;

import reglaNegocio.ReglaNegocio;


public class ConsultaHaberesP001Form extends ActionForm {
	String documento = null;
	boolean checkCD =false;
	String secuencia = null;
	String selectFdesde = null;
	ArrayList conjFdesde = new ArrayList();
	private ImageButtonBean aceptarButton;

	private ImageButtonBean buscarButton;

	public String getButtonSelected() {
		if (getAceptarButton().isSelected()) 
			return "Aceptar";
		if (getBuscarButton().isSelected()) 
			return "Buscar";
		return " ";
	}


	public boolean isCheckCD() {
		return checkCD;
	}


	public void setCheckCD(boolean checkCD) {
		this.checkCD = checkCD;
	}


	public void reset(ActionMapping mapping, HttpServletRequest request) {
		aceptarButton = new ImageButtonBean();
		buscarButton = new ImageButtonBean();
		ReglaNegocio rn = new ReglaNegocio();
		setConjFdesde(rn.cargoFecha());
		String docu = (String) request.getSession().getAttribute("documento");
		String secu = (String) request.getSession().getAttribute("secuencia");
	    setDocumento(docu);
	    setSecuencia(secu);
	}
	/**
	 * @param mapping ActionMapping, y request HttpServletRequest valida los campos del Form.
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors ae = new ActionErrors();
		
		try {
			request.getSession().setAttribute("documento", documento);
			request.getSession().setAttribute("secuencia", secuencia);
			if (getButtonSelected().equals("Aceptar")) {
				setDocumento(getDocumento().toUpperCase());
				if (getDocumento().equals("")) {
					ae.add("errores", new ActionMessage("error.blanco"));
					return ae;
				}
							}
		} catch (Exception e) {
			ae.add("errores", new ActionMessage("error.conexion"));
			return ae;
		}
		return null;
	}

	/**
	 * @return
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param string
	 */
	public void setDocumento(String string) {
		documento = string;
	}

	/**
	 * @return
	 */
	public ArrayList getConjFdesde() {
		return conjFdesde;
	}

	/**
	 * @return
	 */
	public String getSelectFdesde() {
		return selectFdesde;
	}

	/**
	 * @param list
	 */
	public void setConjFdesde(ArrayList list) {
		conjFdesde = list;
	}

	/**
	 * @param string
	 */
	public void setSelectFdesde(String string) {
		selectFdesde = string;
	}

	/**
	 * @return
	 */
	public ImageButtonBean getAceptarButton() {
		return aceptarButton;
	}

	/**
	 * @return
	 */
	public ImageButtonBean getBuscarButton() {
		return buscarButton;
	}

	/**
	 * @param bean
	 */
	public void setAceptarButton(ImageButtonBean bean) {
		aceptarButton = bean;
	}

	/**
	 * @param bean
	 */
	public void setBuscarButton(ImageButtonBean bean) {
		buscarButton = bean;
	}


	public String getSecuencia() {
		return secuencia;
	}


	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}

}
