package br.com.cursojava.apptarefas.home;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HomeBean {
	
	private String mensagem = "Bem vindo ao JSF";

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
