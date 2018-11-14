package br.com.cursojava.apptarefas.usuario;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="usuarioConverter")
public class UsuarioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent uiComponent, String value) {
		UsuarioRepositorio repositorio = new UsuarioRepositorio();
		Usuario usuario = null;
		try {
		usuario = repositorio.buscarPorId(Integer.parseInt(value));
		}catch(NumberFormatException ex) {}
		return usuario;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent uiComponent, Object object) {
		if(object.getClass() == Usuario.class) {
			Usuario usuario = (Usuario)object;
			return usuario.getId() != null ? usuario.getId().toString() : "";
		}
		return "";
	}

}
