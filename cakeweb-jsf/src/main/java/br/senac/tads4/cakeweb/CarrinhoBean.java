/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.cakeweb;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 *
 * @author fernando.tsuda
 */
@Named
@SessionScoped
public class CarrinhoBean implements Serializable {
  
  List<Long> idsProdutos = new ArrayList<>();

  public CarrinhoBean() {
  }
  
  public String adicionar(long idProduto) {
    this.idsProdutos.add(idProduto);
    Flash flash = FacesContext.getCurrentInstance()
	    .getExternalContext().getFlash();
    flash.put("mensagem", "Produto " + idProduto 
	    + " adicionado com sucesso.");
    return "index";
  }
  
  public int getQuantidade() {
    return idsProdutos.size();
  }
  
  public List<Long> getIdsProdutos() {
    return idsProdutos;
  }
  
}
