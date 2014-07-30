package com.webService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entity.Pessoa;

@Path("/pessoa-service")
public class PessoaWS {
	
	    private List<Pessoa> pessoa = new ArrayList<Pessoa>();;
	 
	    public PessoaWS(){
	    	
	        Pessoa p = new Pessoa();
	        p.setId(12L);
	        p.setNome("Jaderson");
	        p.setIdade(23);
	        
	        Pessoa pp = new Pessoa();
	        pp.setId(13L);
	        pp.setNome("Lucila");
	        pp.setIdade(20);
	        
	        pessoa.add(p);
	        pessoa.add(pp);
	    }
	 
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    @Path("/pessoa") // Path para acesso: /rest-sample/ws/pessoa/
	    public Response findAll() {
	        return Response
	                .ok()
	                .type(MediaType.APPLICATION_JSON)
	                .entity(pessoa)
	                .build();
	    }
	     
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    @Path("/pessoa/id/{id}") // Path para acesso: /rest-sample/ws/pessoa/id/1
	    public Response getById(@PathParam("id") Long id) {
	        for(Pessoa p : pessoa){
	            if(p.getId().equals(id)){
	                return Response
	                        .ok()
	                        .type(MediaType.APPLICATION_JSON)
	                        .entity(pessoa)
	                        .build();
	            }
	        }
	        return Response
	                .status(404)
	                .entity("User Not Found")
	                .build();
	    }
}
