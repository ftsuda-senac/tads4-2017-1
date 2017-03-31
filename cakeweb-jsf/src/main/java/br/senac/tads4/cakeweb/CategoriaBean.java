/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.cakeweb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author fernando.tsuda
 */
@Named
@ApplicationScoped
public class CategoriaBean {
  
  private Map<String, String> categorias = new ConcurrentHashMap<>();

  /**
   * Creates a new instance of CategoriaBean
   */
  public CategoriaBean() {
    categorias.put("1", "Bolo");
    categorias.put("2", "Torta");
    categorias.put("3", "Doces");
    categorias.put("4", "Bebidas");
  }
  
  public List<String> getCategorias() {
    return new ArrayList<String>(categorias.values());
  }
  
  
}
