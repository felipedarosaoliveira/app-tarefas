package br.com.cursojava.apptarefas.home;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HomeBean {

	private String mensagem = "Bem vindo ao JSF";
	private String nome = "";


	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
