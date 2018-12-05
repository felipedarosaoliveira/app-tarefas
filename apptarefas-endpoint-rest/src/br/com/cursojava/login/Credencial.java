package br.com.cursojava.login;

public class Credencial {
	
	private String email;
	private String senha;
	public Credencial() {
		super();
	}
	public Credencial(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
