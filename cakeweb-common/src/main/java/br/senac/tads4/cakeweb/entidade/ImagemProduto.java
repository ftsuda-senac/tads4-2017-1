/*
 * The MIT License
 *
 * Copyright 2016 fernando.tsuda.
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

import java.io.Serializable;

/**
 *
 * @author fernando.tsuda
 */
public class ImagemProduto implements Serializable {

  private Long id;

  private String nomeArquivo;

  private String legenda;

  private Produto produto;

  public ImagemProduto() {

  }

  public ImagemProduto(Long id, String nomeArquivo, String legenda) {
    this.id = id;
    this.nomeArquivo = nomeArquivo;
    this.legenda = legenda;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNomeArquivo() {
    return nomeArquivo;
  }

  public void setNomeArquivo(String nomeArquivo) {
    this.nomeArquivo = nomeArquivo;
  }

  public String getLegenda() {
    return legenda;
  }

  public void setLegenda(String legenda) {
    this.legenda = legenda;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public String getUrlArquivo() {
    return "http://localhost:8080/imagens/" + nomeArquivo;
  }

  @Override
  public String toString() {
    return "ImagemProduto{" + "id=" + id + ", legenda=" + legenda + ", nomeArquivo=" + nomeArquivo + '}';
  }

}
