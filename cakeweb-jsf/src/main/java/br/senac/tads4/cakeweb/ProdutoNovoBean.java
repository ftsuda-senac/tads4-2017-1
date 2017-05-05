/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.cakeweb;

import br.senac.tads4.cakeweb.common.entidade.Categoria;
import br.senac.tads4.cakeweb.common.entidade.Produto;
import br.senac.tads4.cakeweb.common.service.CategoriaService;
import br.senac.tads4.cakeweb.common.service.ProdutoService;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author fernando.tsuda
 */
@Named
@ViewScoped
public class ProdutoNovoBean implements Serializable {

  @Inject
  private ProdutoService service;
  
  @Inject
  private CategoriaService categoriaService;
  
  private Produto produto = null;

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
    List<Categoria> categorias = new ArrayList<Categoria>();
    if (idsCategorias != null) {
      for (int i : idsCategorias) {
	Categoria c  = categoriaService.obter(i);
	categorias.add(c);
	c.setProdutos(Arrays.asList(produto));
      }
      produto.setCategorias(categorias);
    }
    if (produto.getId() == null) {
      service.incluir(produto);
    } else {
      service.alterar(produto);
    }
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

  public Produto getProduto() {
    if (produto == null) {
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String, String> params = fc.getExternalContext()
	      .getRequestParameterMap();
      String id = params.get("id");
      if (id != null) {
	produto = service.obter(Long.parseLong(id));
      } else {
	produto = new Produto();
      }
    }
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
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
