package br.com.cursojava.projeto;

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

@Path("projetos")
public class ControllerProjeto {

	private RepositorioProjeto repos = new RepositorioProjeto();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Projeto> getProjetos() {
		return repos.buscarTodos();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarProjetoPorId(@PathParam("id") Integer id) {
		Projeto projeto = repos.buscarPorId(id);
		if (projeto != null) {
			return Response.ok(projeto).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserir(Projeto projeto) {
		if (projeto != null && projeto.getId() == null) {
			boolean result = repos.salvar(projeto);
			if (result) {
				return Response.status(Status.CREATED).entity(projeto).build();
			}
		}
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}

	@Path("/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") Integer id, Projeto projeto) {
		Projeto projetoNaBase = repos.buscarPorId(id);
		if (projetoNaBase != null) {
			projeto.setId(id);
			repos.salvar(projeto);
			return Response.status(Status.ACCEPTED).entity(projeto).build();
		} else {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response remover(@PathParam("id") Integer id) {
		if (repos.remover(id)) {
			return Response.status(Status.ACCEPTED).build();
		} else {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
	}
}
