package br.com.cursojava.apptarefas.utils;

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

public class AppFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getServletPath();
		//se é um recurso publico então deixa passar
		//senão verifica se está logado
		System.out.println("path ==> " + path);
		if (!isPublico(path)) {
			boolean ok = validarAutorizacao(req);
			if (ok) {
				chain.doFilter(request, response);
			} else {
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.sendRedirect(req.getContextPath() + "/login.xhtml");
			}
		} else {
			chain.doFilter(request, response);
		}
		if (req.getRequestURI().matches(".*(css|jpg|png|gif|js)")) {
			
			
		}
	}

	private boolean isPublico(String path) {
		if(path != null && (path.startsWith("/javax.faces.resource/" ) || 
		   path.equals("/login.xhtml") ||
		   path.equals("/login.jsf"))){
			return true;
		}
		return false;
	}

	private boolean validarAutorizacao(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("usuarioLogado") != null) {
			return true;
		}
		return false;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
