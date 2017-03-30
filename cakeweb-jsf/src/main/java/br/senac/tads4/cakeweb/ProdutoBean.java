/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.cakeweb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author fernando.tsuda
 */
@Named(value = "produtoBean") // o (value = "produtoBean") é opcional
@RequestScoped
public class ProdutoBean {

  private String email;

  private String[] categorias;

  private String nivel;
  
  private Integer nota;


  private Produto produto = new Produto();

  /**
   * Creates a new instance of ProdutoBean
   */
  public ProdutoBean() {
  }

  public List<Produto> getProdutos() {
    List<Produto> produtos = new ArrayList<>();
    for (int i = 1; i < 13; i++) {
      produtos.add(new Produto("Produto " + i,
	      "Descrição do produto " + i,
	      new BigDecimal(i * 10)));
    }
    return produtos;

  }

  public String salvar() {
    //this.produto = new Produto(nome, descricao, preco);
    return "sucesso";
  }

  public Produto getProduto() {
    return produto;
  }

  /**
   * Metodo que retorna os valores possíveis das categorias
   *
   * @return
   */
  public List<String> getValoresCategorias() {
    return Arrays.asList("Categoria 1", "Categoria 2", "Categoria 3");
  }

  /**
   * Método que retorna os valores possíveis dos níveis
   *
   * @return
   */
  public List<String> getValoresNiveis() {
    return Arrays.asList("Nivel 1", "Nivel 2", "Nivel 3");
  }
  
  public List<Integer> getValoresNotas() {
    return Arrays.asList(1, 2, 3, 4, 5);
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String[] getCategorias() {
    return categorias;
  }

  public void setCategorias(String[] categorias) {
    this.categorias = categorias;
  }

  public String getNivel() {
    return nivel;
  }

  public void setNivel(String nivel) {
    this.nivel = nivel;
  }

  public Integer getNota() {
    return nota;
  }

  public void setNota(Integer nota) {
    this.nota = nota;
  }


}