package br.com.cursojava;

import javax.ws.rs.Path;

@Path("situacoes")
public class ControllerSituacao {

//	RepositorioSituacao repositorio = new RepositorioSituacao();
//
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Situacao> getSituacao(){
//		return repositorio.buscarTodos();
//		}
//
//	@GET
//	@Path("/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response buscarPorId(@PathParam("id") Integer id) {
//		Situacao situacao = repositorio.buscarPorId(id);
//		if (situacao != null) {
//			return Response.ok(situacao).build();
//		} else {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//
//	}
//
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response inserir(Situacao situacao) {
//		if (situacao != null ) {
//			boolean resultado = repositorio.salvar(situacao);
//			if (resultado) {
//				return Response.status(Status.CREATED).entity(situacao).build();
//			}
//		}
//		return Response.status(Status.NOT_ACCEPTABLE).build();
//	}
//
//	@PUT
//	@Path("/{id}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response atualizar(@PathParam("id") Integer id, Situacao situacao) {
//		Situacao situacaoBase = repositorio.buscarPorId(id);
//		System.out.println("Passando no atualizando"); // teste
//		if (situacaoBase != null) {
////			situacao.setId(id);
//			repositorio.salvar(situacao);
//			return Response.status(Status.ACCEPTED).entity(situacao).build();
//		} else {
//			return Response.status(Status.NOT_ACCEPTABLE).build();
//		}
//	}
//
//	@DELETE
//	@Path("/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response remover(@PathParam("id") Integer id) {
//		System.out.println("Passando no remover"); // teste
//
//		if (repositorio.remover(id)) {
//			return Response.status(Status.ACCEPTED).build();
//		} else {
//			return Response.status(Status.NOT_ACCEPTABLE).build();
//		}
//	}

}
