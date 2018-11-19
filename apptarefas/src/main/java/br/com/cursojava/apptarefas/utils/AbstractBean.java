package br.com.cursojava.apptarefas.utils;

import java.util.Arrays;

import org.primefaces.model.menu.MenuModel;

public abstract class AbstractBean {

	private BeanState state = BeanState.LIST;
	private MenuModel breadcrumb = new BreadCrumbMenu(Arrays.asList(new BreadCrumbItem("1","Home", "./index.xhtml"))); 

	public MenuModel getBreadcrumb() {
		return breadcrumb;
	}

	public BeanState getState() {
		return state;
	}

	public void setState(BeanState state) {
		this.state = state;
	}
	
	
	
	
	
}
