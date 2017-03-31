/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.cakeweb;

import java.math.BigDecimal;

public class Produto {
  
  private long id;

  private String nome;

  private String descricao;

  private BigDecimal preco;

  public Produto() {
  }

  public Produto(long id, String nome, String descricao, BigDecimal preco) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }

}
