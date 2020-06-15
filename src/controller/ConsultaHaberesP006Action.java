package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DatPer;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import reglaNegocio.ReglaNegocio;
import factory.dao.DAOFactory;
import factory.impl.ImplementationDAOFactory;
import forms.ConsultaHaberesP006Form;

public class ConsultaHaberesP006Action extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		ConsultaHaberesP006Form hForm = (ConsultaHaberesP006Form) form;
		HttpSession session = request.getSession();
		String submit = (String) hForm.getButtonSelected();
		int radio = hForm.getRadio();
		// interaccion con el modelo
		if (submit.equals("Aceptar")) {
			try {
				DAOFactory dao = new ImplementationDAOFactory();
				ReglaNegocio rn = new ReglaNegocio();
				Vector vec = (Vector) session.getAttribute("resulpersonas");
				DatPer dp = (DatPer) vec.elementAt(radio);
				ArrayList vcdoc = rn.obtenerCambDoc(dp.getDocumento(),
						(String) session.getAttribute("anioselected"), request,
						response,((Boolean)session.getAttribute("cambiodoc")).booleanValue());

				rn.obtenerCheques(vcdoc, dp.getDocumento(),
						(String) session.getAttribute("secuselected"),
						(String) session.getAttribute("anioselected"), request,
						response);
				Vector conjCheques = (Vector) session.getAttribute("cheques");

				if (conjCheques.size() == 0) {
					ActionErrors ae = new ActionErrors();
					ae.add("errores", new ActionMessage(
							"error.NoExisteDocumento"));
					saveErrors(request, ae);
					return mapping.findForward("consultaHaberesP001");
				}
				session.setAttribute("cheques", conjCheques);
				return mapping.findForward("consultaHaberesP004");
			} catch (Exception e) {
				ActionErrors ae = new ActionErrors();
				ae.add("errores", new ActionMessage("error.conexion"));
				saveErrors(request, ae);

				return mapping.findForward("consultaHaberesP001");
			}
		}
		if (submit.equals("Cancelar")) {
			return mapping.findForward("consultaHaberesP001");
		}
		return null;
	}
}