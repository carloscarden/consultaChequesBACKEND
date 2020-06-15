package forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.ImageButtonBean;

public class ConsultaHaberesP002Form extends ActionForm {
	String apyn = null;
	private ImageButtonBean aceptarButton;
	private ImageButtonBean cancelarButton;

	public String getButtonSelected() {
		if (getAceptarButton().isSelected()) 
			return "Aceptar";
		if (getCancelarButton().isSelected()) 
			return "Cancelar";
		return " ";
	}


	public void reset(ActionMapping mapping, HttpServletRequest request) {
		aceptarButton = new ImageButtonBean();
     	cancelarButton = new ImageButtonBean();
	}
	/**
	 * @param mapping ActionMapping, y request HttpServletRequest valida los campos del Form.
	 */
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {
		ActionErrors ae = new ActionErrors();
		try {

			if (getButtonSelected().equals("Aceptar")) {
				setApyn(getApyn().toUpperCase());
				if (getApyn().equals("")) {
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
	public String getApyn() {
		return apyn;
	}

	/**
	 * @param string
	 */
	public void setApyn(String string) {
		apyn = string;
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
	public ImageButtonBean getCancelarButton() {
		return cancelarButton;
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
	public void setCancelarButton(ImageButtonBean bean) {
		cancelarButton = bean;
	}

}
