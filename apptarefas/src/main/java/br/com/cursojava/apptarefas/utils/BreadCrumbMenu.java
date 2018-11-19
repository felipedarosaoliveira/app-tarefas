package br.com.cursojava.apptarefas.utils;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuModel;

public class BreadCrumbMenu implements MenuModel{
	private List<MenuElement> elements = new ArrayList<>();
	
	public BreadCrumbMenu() {
	}
	
	public BreadCrumbMenu(List<MenuElement> items) {
		this.elements = items;
	}

	@Override
	public List<MenuElement> getElements() {
		return elements;
	}

	@Override
	public void addElement(MenuElement element) {
		this.elements.add(element);
		
	}

	@Override
	public void generateUniqueIds() {
		// TODO Auto-generated method stub
	}
	
	public void disableElement(String label) {
		this.elements.forEach(e->{
			if(label != null && e instanceof BreadCrumbItem) {
				BreadCrumbItem it = (BreadCrumbItem) e;
				if(label.equals(it.getLabel()))
				it.setRendered(false);
			}
		});
	}
	
	public void enableElement(String label) {
		this.elements.forEach(e->{
			if(label != null && e instanceof BreadCrumbItem) {
				BreadCrumbItem it = (BreadCrumbItem) e;
				if(label.equals(it.getLabel()))
				it.setRendered(true);
			}
		});
	}

}
