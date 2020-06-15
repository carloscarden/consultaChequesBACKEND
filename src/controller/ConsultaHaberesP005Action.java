package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import forms.ConsultaHaberesP005Form;

public class ConsultaHaberesP005Action extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException {
		ConsultaHaberesP005Form hForm = (ConsultaHaberesP005Form) form;
		HttpSession session = request.getSession();
		String submit = (String) hForm.getButtonSelected();
	    //interaccion con el modelo
		if (submit.equals("Aceptar")){
			return mapping.findForward("consultaHaberesP004");
		}
	    return null;
	}
}