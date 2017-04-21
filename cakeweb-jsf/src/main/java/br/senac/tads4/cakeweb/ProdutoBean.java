/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.cakeweb;

import br.senac.tads4.cakeweb.common.entidade.Produto;
import br.senac.tads4.cakeweb.common.service.ProdutoService;
import br.senac.tads4.cakeweb.common.service.jpaimpl.ProdutoServiceJPAImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;

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

  private Date dataTeste = new Date();

  private Produto produto = new Produto();

  private Part imagem;

  /**
   * Creates a new instance of ProdutoBean
   */
  public ProdutoBean() {
  }

  public List<Produto> getProdutos() {
    ProdutoService service = new ProdutoServiceJPAImpl();
    return service.listar(0, 100);
  }

  public String salvar() {
    
    this.produto = new Produto();

    if (imagem != null) {
      String partHeader = imagem.getHeader("content-disposition");
      System.out.println("***** partHeader: " + partHeader);
      for (String content : partHeader.split(";")) {
	if (content.trim().startsWith("filename")) {
	  System.out.println("***** content: " + content);
	  String nomeArquivo = content.substring(content.indexOf('=') + 1);
	  System.out.println("***** nomeArquivo 1: " + nomeArquivo);
	  nomeArquivo = nomeArquivo.trim().replace("\"", "");
	  int lastFilePart = nomeArquivo.lastIndexOf("\\");
	  if (lastFilePart > 0) {
	    nomeArquivo = nomeArquivo.substring(lastFilePart, nomeArquivo.length());
	  }
	  String destino = "C:\\desenv\\imagens\\";
	  File arquivo = new File(destino + nomeArquivo);
	  System.out.println("***** arquivo: " + arquivo.getAbsolutePath());

	  try (InputStream inputStream = imagem.getInputStream();
		  OutputStream outputStream
		  = new FileOutputStream(arquivo)) {
	    int read = 0;
	    final byte[] imgBytes = new byte[1024];
	    while ((read = inputStream.read(imgBytes)) != -1) {
	      outputStream.write(imgBytes, 0, read);
	    }

	  } catch (IOException ex) {
	    Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
	  }

	}
      }
    }
    return "sucesso";
  }

  public Produto getProduto() {
    if (produto == null) {
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String, String> mapParam
	      = fc.getExternalContext().getRequestParameterMap();
      Long idProd = Long.parseLong(mapParam.get("id"));

      ProdutoService service = new ProdutoServiceJPAImpl();
      produto = service.obter(idProd);
    }
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

  public Date getDataTeste() {
    return dataTeste;
  }

  public void setDataTeste(Date dataTeste) {
    this.dataTeste = dataTeste;
  }

  public Part getImagem() {
    return imagem;
  }

  public void setImagem(Part imagem) {
    this.imagem = imagem;
  }

}
