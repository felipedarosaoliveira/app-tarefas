package br.com.cursojava.apptarefas.utils;

import javax.servlet.http.HttpSession;

import br.com.cursojava.utils.AppSession;

public class AppSessionImpl implements AppSession {
	
	private HttpSession session;

	public AppSessionImpl(HttpSession session) {
		if(session == null) {
			throw new IllegalArgumentException("Session is null");
		}
		this.session = session;
	}

	@Override
	public void addAttribute(String key, Object value) {
		session.setAttribute(key, value);
		
	}

	@Override
	public <T> T getAttribute(String key) {
		return (T) session.getAttribute(key);
	}
	
	

}
