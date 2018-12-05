package br.com.cursojava.usuario;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("usuarios")
public class ControllerUsuario {
//	private UsuarioRepositorio repos = new UsuarioRepositorio();
//
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Usuario> getContatos() {
//		return repos.buscarTodos();
//	}
//
//	@GET
//	@Path("/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response buscarPorId(@PathParam("id") Integer id) {
//		Usuario user = repos.buscarPorId(id);
//		if (user != null) {
//			return Response.status(Status.FOUND).build();
//		} else {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//	}
//
//	@PUT
//	@Path("/{id}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response atualizar(@PathParam("id") Integer id, Usuario user) {
//		Usuario atual = repos.buscarPorId(id);
//		if (atual != null) {
//			user.setId(id);
//			repos.salvar(user);
//			return Response.status(Status.ACCEPTED).build();
//		} else {
//			return Response.status(Status.NOT_ACCEPTABLE).build();
//		}
//	}
//
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response inserir(Usuario user) {
//		if (user != null && user.getId() == null) {
//			boolean result = repos.salvar(user);
//			if (result) {
//				return Response.status(Status.CREATED).entity(user).build();
//			}
//		}
//		return Response.status(Status.NOT_ACCEPTABLE).build();
//	}
//
//	@DELETE
//	@Path("/{id}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response remover(@PathParam("id") Integer id) {
//		if (repos.remover(id)) {
//			return Response.status(Status.ACCEPTED).build();
//		} else {
//			return Response.status(Status.NOT_ACCEPTABLE).build();
//		}
//	}
}
