package forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ImageButtonBean;

public class ConsultaHaberesP004Form extends ActionForm {
	String[] checkBox;
	ArrayList cheques;
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
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		return null;
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

	/**
	 * @return
	 */
	public ArrayList getCheques() {
		return cheques;
	}

	/**
	 * @param list
	 */
	public void setCheques(ArrayList list) {
		cheques = list;
	}



	public String[] getCheckBox() {
		return checkBox;
	}



	public void setCheckBox(String[] checkBox) {
		this.checkBox = checkBox;
	}


}
