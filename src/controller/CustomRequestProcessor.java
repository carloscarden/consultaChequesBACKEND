/*
 * Created on 09/11/2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.RequestProcessor;

import crypto.Cryptcipher;



import exception.AccesoAutorizadoException;
import exception.FaltaParametroEncriptadoException;
import exception.SessionActivaException;

public class CustomRequestProcessor extends RequestProcessor {

	public CustomRequestProcessor() {

		super();

	}

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		try {

			validarAccesoAutorizado(request, response);

			validarEncriptacionDelPortal(request, response);

			validarSessionActiva(request, response);

			super.process(request, response);

		} catch (AccesoAutorizadoException e) {

			procesarSystemError(request, response, "error.acceso.noautorizado");

		} catch (FaltaParametroEncriptadoException e) {

			procesarSystemError(request, response, "error.acceso.noautorizado");

		} catch (SessionActivaException e) {

			procesarSystemError(request, response, "error.session.inactiva");

		}

	}

	private void validarAccesoAutorizado(HttpServletRequest request,

	HttpServletResponse response) throws IOException,

	AccesoAutorizadoException {

		// Si intentan entrar desde afuera los envia a la pagina de login

		String refererPage = request.getHeader("Referer");

		if (refererPage == null) {

			throw new AccesoAutorizadoException();

		}

	}

	private void validarEncriptacionDelPortal(HttpServletRequest request,

	HttpServletResponse response) throws IOException,

	FaltaParametroEncriptadoException {

		HttpSession session = request.getSession(false);

		// Verifica que este el parametro Encriptado

		String path = processPath(request, response);

		if (path.equals("/index")) {

			if (session != null) {

				session.invalidate();

			}

			String par = desEncriptar(request.getParameter("usuario"));

			if (par == null) {

				throw new FaltaParametroEncriptadoException();

			} else {

				session = request.getSession(true);

				session.setAttribute("dniusuario", par);

			}

		}

	}

	private void validarSessionActiva(HttpServletRequest request,

	HttpServletResponse response) throws IOException,

	SessionActivaException {

		HttpSession session = request.getSession(false);

		// Verifica que este logueado

		String path = processPath(request, response);

		if (!(path.equals("/index") || path.equals("/expiredSession"))) {

			if ((session == null) || (session.getAttribute("dniusuario") == null)) {

				throw new SessionActivaException();

			}

		}

	}

	protected boolean processPreprocess(HttpServletRequest request,

	HttpServletResponse response) {

		return true;

	}

	private String desEncriptar(String cifrado) {

		String result = "";

		try {

			result = Cryptcipher.descifrarDES(cifrado);

			return result.trim();

		} catch (Exception e) {

			return null;

		}

	}

	private void procesarSystemError(HttpServletRequest request,

	HttpServletResponse response, String errorKey)

	throws ServletException, IOException {

		ActionMessages msgs = new ActionMessages();

		msgs.add("systemError", new ActionMessage(errorKey));

		ActionMapping mapping = processMapping(request, response, "/index");

		ActionForward forward = mapping.findForward("expiredSession");

		// la linea de abajo almacena el error en el request de la manera

		// en que implicitamente lo hace struts

		request.setAttribute(Globals.MESSAGE_KEY, msgs);

		request.getRequestDispatcher(forward.getPath()).forward(request,

		response);

	}

}
