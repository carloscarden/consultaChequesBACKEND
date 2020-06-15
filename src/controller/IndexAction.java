package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import forms.IndexForm;

public class IndexAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException {
		IndexForm hForm = (IndexForm) form;
				
		String submit = hForm.getButtonSelected();
  	    return mapping.findForward("consultaHaberesP001");
/*		if (submit.equals("Aceptar")){
		  return mapping.findForward("consultaHaberesP001"); 
		}
		return mapping.findForward("index");
	*/
	}
}