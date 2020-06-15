package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LogConsultaCheques;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import reglaNegocio.ReglaNegocio;
import factory.dao.DAOFactory;
import factory.impl.ImplementationDAOFactory;
import forms.ConsultaHaberesP001Form;

public class ConsultaHaberesP001Action extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException {
		HttpSession session = request.getSession();
		ConsultaHaberesP001Form hForm = (ConsultaHaberesP001Form) form;
		String submit = hForm.getButtonSelected();

		//interaccion con el modelo

		if (submit.equals("Aceptar")) {


			// ******************************************************************************************
			// ERROR DEL DOCUMENTO
			// ************************************************************************
			
			//error.DocumentoEnCero=Para el documento menor que 10.000.000 ingrese el sexo delante del n�mero.
			if (hForm.getDocumento().substring(0,1).equals("0") &&(Integer.parseInt(hForm.getSelectFdesde()) > 1999)){
				ActionErrors ae = new ActionErrors();
				ae.add(
					"errores",
					new ActionMessage("error.DocumentoEnCero"));
				saveErrors(request, ae);
				return mapping.findForward("consultaHaberesP001");

				
			}
			// ******************************************************************



			// ************************************************************************
			// CREAR LOG DE LA CONSULTA
			// ************************************************************************
			try{
			//LogConsulta cheques a partir de 17/08/2016
			LogConsultaCheques lcc = new LogConsultaCheques();
			lcc.setDocuConsulta(hForm.getDocumento());
			
			if ((hForm.getSecuencia() !=null)&&(!"".equals(hForm.getSecuencia()))) 
				lcc.setSecuConsulta(Integer.valueOf(hForm.getSecuencia()));
			else
				lcc.setSecuConsulta(0);
			lcc.setEjercicioConsulta(Integer.valueOf(hForm.getSelectFdesde()));
			lcc.setUsuario((String)session.getAttribute("dniusuario"));
			lcc.setFechaConsulta(new Date());
			DAOFactory dao = new ImplementationDAOFactory();
			dao.getLogConsultaChequesDAO().saveOrUpdate(lcc);
			
			}catch (Exception e){
				e.printStackTrace();
				return mapping.findForward("consultaHaberesP001");
				
			}
			// ************************************************************************
			// ************************************************************************
			
			//LogConsulta cheques a partir de 17/08/2016
			
			try {
				DAOFactory dao = new ImplementationDAOFactory();
				ReglaNegocio rn = new ReglaNegocio();
				ArrayList vcdoc = new ArrayList();
				if (Integer.parseInt(hForm.getSelectFdesde()) > 1999) {
					vcdoc =
						rn.obtenerCambDoc(
							hForm.getDocumento(),
							hForm.getSelectFdesde(),
							request,
							response, hForm.isCheckCD());

					//**** ********************************************
					// HUBO CAMBIOS EN EL DOCUMENTO
					// ************************************************
					if (vcdoc.size() == 0) {
						session.setAttribute("secuselected",hForm.getSecuencia());
    					session.setAttribute("anioselected",hForm.getSelectFdesde());
						session.setAttribute("cambiodoc",hForm.isCheckCD());
						
						// IR AL LISTADO DE LOS CAMBIOS DE DOCUMENTO
						return mapping.findForward("consultaHaberesP006");
					}
				}
				rn.obtenerCheques(vcdoc, hForm.getDocumento(), hForm.getSecuencia(), hForm.getSelectFdesde(), request, response);
				Vector conjCheques = (Vector) session.getAttribute("cheques");

				// error.NoExisteDocumento=El documento ingresado no posee cheques
				if (conjCheques.size() == 0) {
					ActionErrors ae = new ActionErrors();
					ae.add(
						"errores",
						new ActionMessage("error.NoExisteDocumento"));
					saveErrors(request, ae);
					return mapping.findForward("consultaHaberesP001");
				}
				session.setAttribute("cheques", conjCheques);
				session.setAttribute("documento", hForm.getDocumento());
				return mapping.findForward("consultaHaberesP004");
			} catch (Exception e) {
				ActionErrors ae = new ActionErrors();
				ae.add("errores", new ActionMessage("error.conexion"));
				saveErrors(request, ae);

				return mapping.findForward("consultaHaberesP001");
			}

		}

		if (submit.equals("Buscar")) {
			return mapping.findForward("consultaHaberesP002");
		}

		return null;

	}

}