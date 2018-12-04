package br.com.cursojava;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

public class CORSFilter implements ContainerResponseFilter {
	
	private static int count = 1;
	   @Override
	   public void filter(final ContainerRequestContext requestContext,
	                      final ContainerResponseContext cres) throws IOException {
		   System.out.println("Passou aqui " + count++);
	      cres.getHeaders().add("Access-Control-Allow-Origin", "*");
	      cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
	      cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
	      cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	      cres.getHeaders().add("Access-Control-Max-Age", "1209600");
	   }


}
