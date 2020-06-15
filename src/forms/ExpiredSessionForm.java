package forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.ImageButtonBean;

public class ExpiredSessionForm extends ActionForm {
  public ImageButtonBean aceptarButton;
  public void reset(ActionMapping mapping, HttpServletRequest request) {
  	aceptarButton = new ImageButtonBean();
  }
  
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {
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
