/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.cakeweb.rest;

import br.senac.tads4.cakeweb.common.entidade.Produto;
import br.senac.tads4.cakeweb.common.service.ProdutoService;
import br.senac.tads4.cakeweb.common.service.fakeimpl.ProdutoServiceFakeImpl;
import br.senac.tads4.cakeweb.common.service.jpaimpl.ProdutoServiceJPAImpl;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author fernando.tsuda
 */
@Path("produto")
public class ProdutoResource {

  @Context
  private UriInfo context;
  
  private ProdutoService service = new ProdutoServiceJPAImpl();

  /**
   * Creates a new instance of ProdutoResource
   */
  public ProdutoResource() {
  }

  /**
   * Retrieves representation of an instance of br.senac.tads4.cakeweb.rest.ProdutoResource
   * @param offset
   * @param quantidade
   * @return an instance of br.senac.tads4.cakeweb.common.entidade.Produto
   */
  @GET
  @Produces(MediaType.APPLICATION_XML)
  public Response listar(
	  @DefaultValue("0") @QueryParam("offset") Integer offset, 
	  @DefaultValue("100") @QueryParam("qtd") Integer quantidade) {
  List<Produto> resultados = service.listar(offset, quantidade);
    GenericEntity<List<Produto>> listaRest = 
	    new GenericEntity<List<Produto>>(resultados) {};
    return Response.ok().entity(listaRest).build();
  }
  
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_XML)
  public Response obter(@PathParam("id") Long id) {
    Produto resultado = service.obter(id);
    return Response.ok().entity(resultado).build();
  }

  /**
   * PUT method for updating or creating an instance of ProdutoResource
   * @param content representation for the resource
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  public void putJson(Produto content) {
  }
}
