package br.com.cursojava.apptarefas.utils;

public class BreadCrumbItem {
	
	private String label;
	private String url;
	
	public BreadCrumbItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BreadCrumbItem(String label, String url) {
	super();
	this.label = label;
	this.url = url;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
