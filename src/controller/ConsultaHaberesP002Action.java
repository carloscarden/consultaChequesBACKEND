package controller;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import reglaNegocio.ReglaNegocio;
import forms.ConsultaHaberesP002Form;

public class ConsultaHaberesP002Action extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException {
        HttpSession session = request.getSession();
		ConsultaHaberesP002Form hForm = (ConsultaHaberesP002Form) form;

		String submit = (String) hForm.getButtonSelected();
		if (submit.equals("Cancelar")) {
				return mapping.findForward("consultaHaberesP001");
		}
		
		try {
			//interaccion con el modelo
			ReglaNegocio rn = new ReglaNegocio();
			
			Vector conjPersonas = rn.obtenerPersonas(hForm.getApyn(), request, response);
			if (conjPersonas.size() > 100) {
				ActionErrors ae = new ActionErrors();
				ae.add("errores", new ActionMessage("error.tope"));
				saveErrors(request, ae);
				return mapping.findForward("consultaHaberesP002");
			}
			rn.cargarEstabPorDocumento(conjPersonas,request);
		}catch (Exception e) {
			ActionErrors ae = new ActionErrors();
			ae.add("errores", new ActionMessage("error.conexion"));
			saveErrors(request, ae);
			return mapping.findForward("consultaHaberesP002");
		}

		if (submit.equals("Aceptar")) {
			return mapping.findForward("consultaHaberesP003");
		}
	
		return null;
	}
}