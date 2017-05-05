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
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author fernando.tsuda
 */
@Named
@SessionScoped
public class UsuarioBean implements Serializable {

  private static final Map<String, String> IDIOMAS;

  static {
    IDIOMAS = new LinkedHashMap<String, String>();
    IDIOMAS.put("Inglês", "en-US");
    IDIOMAS.put("Portugues", "pt-BR");
  }

  private UsuarioSistema usuario = null;

  /**
   * Nome de usuário informado
   */
  private String nomeUsuario;

  /**
   * Senha informada
   */
  private String senha;

  private String localeCode;

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

  public String sair() {
    HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance()
	    .getExternalContext().getRequest();
    req.getSession().invalidate();
    return "/index.xhtml?faces-redirect=true";
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

  public String getLocaleCode() {
    return localeCode;
  }

  public void setLocaleCode(String localeCode) {
    this.localeCode = localeCode;
  }

  public Map<String, String> getCountriesInMap() {
    return IDIOMAS;
  }

  /* Referencia: https://www.mkyong.com/jsf2/jsf-2-internationalization-example/ */
  public void mudarIdioma(ValueChangeEvent e) {

    String newLocaleValue = e.getNewValue().toString();

    //loop country map to compare the locale code
    for (Map.Entry<String, String> entry : IDIOMAS.entrySet()) {

      if (entry.getValue().equals(newLocaleValue)) {
	FacesContext.getCurrentInstance()
		.getViewRoot()
		.setLocale(Locale.forLanguageTag(entry.getValue()));

      }
    }
  }

}
