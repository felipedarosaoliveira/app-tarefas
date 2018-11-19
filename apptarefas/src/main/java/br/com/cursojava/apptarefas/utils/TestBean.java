package br.com.cursojava.apptarefas.utils;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
public class TestBean {
	
	private List<BreadCrumbItem> listaNavegacao = Arrays.asList(new BreadCrumbItem("1","Home", "./index.xhtml"),new BreadCrumbItem("2","Testes", "#"));
	private MenuModel breadCrumb = new DefaultMenuModel();
	
	
	
	public TestBean() {
		super();
		listaNavegacao.forEach((item)->{
			DefaultMenuItem itemMenu = new DefaultMenuItem();
			itemMenu.setValue(item.getLabel());
			itemMenu.setUrl(item.getUrl());
			breadCrumb.addElement(itemMenu);
		});
	}

	public List<BreadCrumbItem> getListaNavegacao() {
		return listaNavegacao;
	}

	public void setListaNavegacao(List<BreadCrumbItem> listaNavegacao) {
		this.listaNavegacao = listaNavegacao;
	}

	public MenuModel getBreadCrumb() {
		return breadCrumb;
	}

	public void setBreadCrumb(MenuModel breadCrumb) {
		this.breadCrumb = breadCrumb;
	}

}
