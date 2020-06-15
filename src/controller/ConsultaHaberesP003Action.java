package controller;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DatPer;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import forms.ConsultaHaberesP003Form;

public class ConsultaHaberesP003Action extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException {
		ConsultaHaberesP003Form hForm = (ConsultaHaberesP003Form) form;
		HttpSession session = request.getSession();
		String submit = (String) hForm.getButtonSelected();
		int radio = hForm.getRadio();
	    //interaccion con el modelo
		if (submit.equals("Aceptar")){
			Vector vec = (Vector) session.getAttribute("resulpersonas");
			DatPer dp = (DatPer) vec.elementAt(radio);
			session.setAttribute("documento", dp.getDocumento());
			return mapping.findForward("consultaHaberesP001");
		}
		if (submit.equals("Cancelar")){
			return mapping.findForward("consultaHaberesP001"); 
		}
	    return null;
	}
}