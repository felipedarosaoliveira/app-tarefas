package br.com.cursojava.apptarefas.home;

import javax.faces.bean.ManagedBean;

import br.com.cursojava.apptarefas.utils.AbstractBean;

@ManagedBean
public class HomeBean extends AbstractBean{

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
