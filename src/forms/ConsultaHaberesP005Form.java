package forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ImageButtonBean;

public class ConsultaHaberesP005Form extends ActionForm {
	ArrayList detcheques;
	ArrayList detcodigos;
	private ImageButtonBean aceptarButton;

	public String getButtonSelected() {
		if (getAceptarButton().isSelected()) 
			return "Aceptar";
		return " ";
	}

	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		aceptarButton = new ImageButtonBean();
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
	 * @param bean
	 */
	public void setAceptarButton(ImageButtonBean bean) {
		aceptarButton = bean;
	}

	/**
	 * @return
	 */
	public ArrayList getDetCheques() {
		return detcheques;
	}

	/**
	 * @param list
	 */
	public void setDetCheques(ArrayList list) {
		detcheques = list;
	}

	/**
	 * @return
	 */
	public ArrayList getDetcheques() {
		return detcheques;
	}

	/**
	 * @return
	 */
	public ArrayList getDetcodigos() {
		return detcodigos;
	}

	/**
	 * @param list
	 */
	public void setDetcheques(ArrayList list) {
		detcheques = list;
	}

	/**
	 * @param list
	 */
	public void setDetcodigos(ArrayList list) {
		detcodigos = list;
	}
}
