/*
 * The MIT License
 *
 * Copyright 2017 fernando.tsuda.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.senac.tads4.cakeweb.entidade;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author fernando.tsuda
 */
public class UsuarioSistema {

  private static final Map<String, UsuarioSistema> USUARIOS_CADASTRADOS;

  static {
    USUARIOS_CADASTRADOS = new LinkedHashMap<>();
    USUARIOS_CADASTRADOS.put("madruga", new UsuarioSistema("madruga",
	    "Seu Madruga", "pagueoaluguel", new String[]{"BASICO"}));
    USUARIOS_CADASTRADOS.put("bozo", new UsuarioSistema("bozo",
	    "Palhaço Bozo", "abcd1234", new String[]{"BASICO", "ADMIN"}));
  }

  private String usuario;

  private String nomeCompleto;

  private String hashSenha;

  private String[] papeis; // ROLES

  public UsuarioSistema() {

  }

  public UsuarioSistema(String usuario, String nomeCompleto, String senha, String[] papeis) {
    this.usuario = usuario;
    this.nomeCompleto = nomeCompleto;
    setSenha(senha);
    this.papeis = papeis;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public String getHashSenha() {
    return hashSenha;
  }

  public final void setSenha(String senha) {
    this.hashSenha = BCrypt.hashpw(senha, BCrypt.gensalt());
  }

  public String[] getPapeis() {
    return papeis;
  }

  public void setPapeis(String[] papeis) {
    this.papeis = papeis;
  }
  
  public boolean temPapel(String papel) {
    List<String> papeisUsuario = Arrays.asList(papeis);
    return papeisUsuario.contains(papel);
  }

  public static UsuarioSistema obterUsuario(String usuario, String senha) {
    UsuarioSistema usuarioEncontrado = USUARIOS_CADASTRADOS.get(usuario);
    if (usuarioEncontrado != null && BCrypt.checkpw(senha, usuarioEncontrado.getHashSenha())) {
      return usuarioEncontrado;
    }
    return null;
  }

}