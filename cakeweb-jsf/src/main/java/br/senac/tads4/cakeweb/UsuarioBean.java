/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.cakeweb;

import br.senac.tads4.cakeweb.entidade.UsuarioSistema;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author fernando.tsuda
 */
@Named
@SessionScoped
public class UsuarioBean implements Serializable {
  
  private UsuarioSistema usuario = null;
  
  /** Nome de usuário informado */
  private String nomeUsuario;
  
  /** Senha informada */
  private String senha;

  /**
   * Creates a new instance of UsuarioBean
   */
  public UsuarioBean() {
  }
  
  public String autenticar() {
    usuario = UsuarioSistema.obterUsuario(nomeUsuario, senha);
    if (usuario != null) {
      return "/protegido/pagina-admin.xhtml?faces-redirect=true";
    }
    return "/erro-login.xhtml?faces-redirect=true";
  }
  
  public UsuarioSistema getUsuario() {
    return usuario;
  }

  public void setUsuario(UsuarioSistema usuario) {
    this.usuario = usuario;
  }

  public String getNomeUsuario() {
    return nomeUsuario;
  }

  public void setNomeUsuario(String nomeUsuario) {
    this.nomeUsuario = nomeUsuario;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
  
}
