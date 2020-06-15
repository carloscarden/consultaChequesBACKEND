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
import reports.ReportCheque;
import forms.ConsultaHaberesP004Form;

public class ConsultaHaberesP004Action extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException, Exception {
		ConsultaHaberesP004Form hForm = (ConsultaHaberesP004Form) form;
		HttpSession session = request.getSession();
		String submit = (String) hForm.getButtonSelected();
		//interaccion con el modelo
		
		try{
		if (submit.equals("Aceptar")) {
			String[] check = hForm.getCheckBox();
			
			if (check == null){
				ActionErrors ae = new ActionErrors();
				// error.marca=Debe seleccionar al menos un cheque.
				ae.add("errores",new ActionMessage("error.marca"));
				saveErrors(request, ae);
				return mapping.findForward("consultaHaberesP004");
			}

			Vector vec = (Vector) session.getAttribute("cheques");
			ReglaNegocio rn = new ReglaNegocio();
			rn.obtenerDetalleChequeParaImp(vec,check);
			// poner codigo para abrir pdf
			
			ReportCheque.sendReportToBrowser(rn.getVParaImprimir(), response);
			
			return mapping.findForward("consultaHaberesP004");
		}
		if (submit.equals("Cancelar")) {
			return mapping.findForward("consultaHaberesP001");
		}
		}catch(Exception e){
			System.out.println("Error en la impresion de PDF ");
		}
		return null;
	}
}