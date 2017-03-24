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
package br.senac.tads4.cakweb.service.fakeimpl;

import br.senac.tads4.cakeweb.entidade.Categoria;
import br.senac.tads4.cakeweb.entidade.ImagemProduto;
import br.senac.tads4.cakeweb.entidade.Produto;
import br.senac.tads4.cakeweb.service.CategoriaService;
import br.senac.tads4.cakeweb.service.ProdutoService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fernando.tsuda
 */
public class ProdutoServiceFakeImpl implements ProdutoService {

  private static final Map<Long, Produto> MAPA_PRODUTOS = new LinkedHashMap<Long, Produto>();

  private static final String DESCRICAO_PADRAO = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
          + "Aenean vel ipsum vehicula, venenatis leo nec, ornare felis. Ut consectetur est vel pulvinar tempus. "
          + "Suspendisse commodo cursus turpis. Etiam ac enim egestas, sollicitudin libero ac, eleifend risus. "
          + "Phasellus nec posuere magna, in vehicula elit. "
          + "Etiam rhoncus, ipsum eget dapibus vulputate, massa nisi feugiat odio, a consectetur urna diam id risus. "
          + "Morbi sed pharetra nisl, nec aliquam ex. Morbi congue urna ut semper aliquam. "
          + "Sed aliquet turpis ac sem egestas dignissim. Praesent interdum dapibus cursus. "
          + "Cras posuere tempor lectus, ac porttitor tellus maximus vel.";

  static {
    CategoriaService categorias = new CategoriaServiceFakeImpl();
    Produto produto = new Produto(1L, "Floresta negra",
            DESCRICAO_PADRAO,
            new BigDecimal(100), new Date(),
            Arrays.asList(new ImagemProduto(1L, "Bla bla bla", "imagem01a.jpg"), new ImagemProduto(2L, "Xpto Xpto", "imagem01b.jpg"), new ImagemProduto(3L, "Chola mais", "imagem01c.jpg")),
            Arrays.asList(categorias.obter(1), categorias.obter(3)));
    MAPA_PRODUTOS.put(produto.getId(), produto);
    produto = new Produto(2L, "Torta de morango",
            DESCRICAO_PADRAO,
            new BigDecimal(90), new Date(),
            Arrays.asList(new ImagemProduto(4L, "Bla bla bla", "imagem02a.jpg"), new ImagemProduto(5L, "Xpto Xpto", "imagem02b.jpg")),
            Arrays.asList(categorias.obter(1), categorias.obter(3)));
    MAPA_PRODUTOS.put(produto.getId(), produto);
    produto = new Produto(3L, "Sonho de valsa",
            DESCRICAO_PADRAO,
            new BigDecimal(110), new Date(),
            Arrays.asList(new ImagemProduto(6L, "Bla bla bla", "imagem03a.jpg")),
            Arrays.asList(categorias.obter(1), categorias.obter(3), categorias.obter(6)));
    MAPA_PRODUTOS.put(produto.getId(), produto);
    produto = new Produto(4L, "Morango com leite condensado",
            DESCRICAO_PADRAO,
            new BigDecimal(105), new Date(),
            Arrays.asList(new ImagemProduto(7L, "Bla bla bla", "imagem04a.jpg"), new ImagemProduto(8L, "Xpto Xpto", "imagem04b.jpg")),
            Arrays.asList(categorias.obter(1), categorias.obter(4)));
    MAPA_PRODUTOS.put(produto.getId(), produto);
    produto = new Produto(5L, "Abacaxi com coco",
            DESCRICAO_PADRAO,
            new BigDecimal(85), new Date(),
            Arrays.asList(new ImagemProduto(9L, "Bla bla bla", "imagem04a.jpg"), new ImagemProduto(10L, "Xpto Xpto", "imagem04b.jpg")),
            Arrays.asList(categorias.obter(1), categorias.obter(5), categorias.obter(7), categorias.obter(8)));
    MAPA_PRODUTOS.put(produto.getId(), produto);
  }

  @Override
  public List<Produto> listar(int offset, int quantidade) {
    return new ArrayList<Produto>(MAPA_PRODUTOS.values());
  }

  @Override
  public List<Produto> listarPorCategoria(Categoria categoria, int offset, int quantidade) {
    List<Produto> lista = new ArrayList<Produto>();
    for (Map.Entry<Long, Produto> entry : MAPA_PRODUTOS.entrySet()) {
      Produto p = entry.getValue();
      if (p.getCategorias().contains(categoria)) {
        lista.add(p);
      }
    }
    return lista;
  }

  @Override
  public Produto obter(long idProduto) {
    return MAPA_PRODUTOS.get(idProduto);
  }

  @Override
  public void incluir(Produto p) {
    // new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void alterar(Produto p) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void remover(long idProduto) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
