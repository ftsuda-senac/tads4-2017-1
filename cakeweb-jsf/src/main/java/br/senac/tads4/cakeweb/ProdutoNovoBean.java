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
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.Part;

/**
 *
 * @author fernando.tsuda
 */
@Named
@ViewScoped
public class ProdutoNovoBean implements Serializable {

  private ProdutoService service = new ProdutoServiceJPAImpl();

  private String nome;

  private String descricao;

  private BigDecimal preco;
  
  private List<Integer> idsCategorias;

  /**
   * Creates a new instance of ProdutoNovoBean
   */
  public ProdutoNovoBean() {
  }

  public String salvar() {
    Produto p = 
	    new Produto(null, nome, descricao, preco, new Date());
    service.incluir(p);
    return "sucesso";
  }

  private String salvarImagem() {

    String nomeArquivo = null;
    /*
    if (imagem != null) {
      String partHeader = imagem.getHeader("content-disposition");
      System.out.println("***** partHeader: " + partHeader);
      for (String content : partHeader.split(";")) {
	if (content.trim().startsWith("filename")) {
	  System.out.println("***** content: " + content);
	  nomeArquivo = content.substring(content.indexOf('=') + 1);
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
     */
    return nomeArquivo;
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

  public List<Integer> getIdsCategorias() {
    return idsCategorias;
  }

  public void setIdsCategorias(List<Integer> idsCategorias) {
    this.idsCategorias = idsCategorias;
  }

}
