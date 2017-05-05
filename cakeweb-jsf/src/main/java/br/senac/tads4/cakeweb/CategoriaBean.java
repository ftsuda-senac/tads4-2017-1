/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.cakeweb;

import br.senac.tads4.cakeweb.common.entidade.Categoria;
import br.senac.tads4.cakeweb.common.service.CategoriaService;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author fernando.tsuda
 */
@Named
@ApplicationScoped
public class CategoriaBean {
  
  @Inject
  private CategoriaService service;
  
  /**
   * Creates a new instance of CategoriaBean
   */
  public CategoriaBean() {

  }
  
  public List<Categoria> getCategorias() {
    return service.listar();
  }
  
  
}
