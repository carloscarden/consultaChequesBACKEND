package forms;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ImageButtonBean;

public class IndexForm extends ActionForm {
	
	private ImageButtonBean aceptarButton;

	public String getButtonSelected() {
		if (getAceptarButton().isSelected()) 
			return "Aceptar";
		return " ";
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
 		aceptarButton = new ImageButtonBean();
        HttpSession session = request.getSession();
		session.removeAttribute("documento");
		session.removeAttribute("secuencia");
	}
	/**
	 * @param mapping ActionMapping, y request HttpServletRequest valida los campos del Form.
	 */
	public ActionErrors validate(){
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

}
