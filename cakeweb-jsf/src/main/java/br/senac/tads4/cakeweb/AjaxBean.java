/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.cakeweb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author fernando.tsuda
 */
@Named
@ViewScoped
public class AjaxBean implements Serializable {

  private String texto;
  
  private int quantidade;
  
  private List<String> resultados;

  public AjaxBean() {
  }
  
  public void executar() {
    resultados = new ArrayList<>();
    for (int i = 1 ; i <= quantidade; i++) {
      resultados.add(texto + " " + i);
    }
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }
  
  public List<String> getResultados() {
    return resultados;
  }

}
