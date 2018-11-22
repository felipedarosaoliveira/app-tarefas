package br.com.cursojava.apptarefas.utils;

import java.util.Arrays;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

public abstract class AbstractBean {

	private BeanState state = BeanState.LIST;
//	private MenuModel breadcrumb = new BreadCrumbMenu(Arrays.asList(new BreadCrumbItem("1","Home", "./index.xhtml"))); 
	private MenuModel breadcrumb = new DefaultMenuModel();
	private List<BreadCrumbItem> listaNavegacao = Arrays.asList(new BreadCrumbItem("1", "Home", "/index.xhtml"));

	public AbstractBean() {
		listaNavegacao.forEach((item) -> {
			DefaultMenuItem itemMenu = new DefaultMenuItem();
			itemMenu.setValue(item.getLabel());
			itemMenu.setUrl(item.getUrl());
			breadcrumb.addElement(itemMenu);
		});
	}

	public String getBaseUrl() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		return "/" + ctx.getExternalContext().getApplicationContextPath();
	}

	public MenuModel getBreadcrumb() {
		return breadcrumb;
	}

	public BeanState getState() {
		return state;
	}

	public void setState(BeanState state) {
		this.state = state;
	}

	public void addSessionAttribute(String key, Object value) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute(key, value);

	}
	
	

}
