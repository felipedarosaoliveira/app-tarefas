package br.com.cursojava.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/autenticacao")
public class ControllerLogin {

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response autenticar(Credencial credencial) {
		if (credencial.getEmail().equals("meuEmail") && credencial.getSenha().equals("minhaSenha")) {
			return Response.status(Status.ACCEPTED).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/logoff")
	public Response logoff(@Context HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return Response.status(Status.ACCEPTED).build();
	}

}
