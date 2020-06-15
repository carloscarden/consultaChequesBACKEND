/*
 * Created on 22/09/2009
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package controller;

import java.io.IOException;

import javax.servlet.Filter;

import javax.servlet.FilterChain;

import javax.servlet.FilterConfig;

import javax.servlet.ServletException;

import javax.servlet.ServletRequest;

import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class FiltroSeguridad implements Filter {

	private FilterConfig filterConfig;

	public void destroy() {

		this.filterConfig = null;

	}

	public void doFilter(ServletRequest request, ServletResponse response,

	FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String jspName = req.getRequestURL().toString();

		if ((!isJspPermitida(jspName)) && (!esUsuarioRegistrado(req))) {

			HttpServletResponse rep = (HttpServletResponse) response;

			rep.sendRedirect(req.getContextPath() + "/jsps/expiredSession.jsp");

		} else {

			chain.doFilter(request, response);

		}

	}

	private boolean esUsuarioRegistrado(HttpServletRequest request) {

		HttpSession session = request.getSession();

		if ((session == null)
				|| (session.getAttribute("dniusuario") == null)) {

			return false;

		}

		return true;

	}

	private boolean isJspPermitida(String jspName) {

		if (jspName.endsWith("/ConsultaChequesV2/")
				|| jspName.endsWith("index.jsp")
				|| jspName.endsWith("expiredSession.jsp")) {

			return true;

		}

		return false;

	}

	public void init(FilterConfig filter) throws ServletException {

		this.filterConfig = filter;

	}

}
