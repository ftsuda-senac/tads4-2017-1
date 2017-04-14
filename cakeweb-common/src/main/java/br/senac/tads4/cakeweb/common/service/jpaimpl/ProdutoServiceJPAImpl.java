/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.cakeweb.common.service.jpaimpl;

import br.senac.tads4.cakeweb.common.entidade.Categoria;
import br.senac.tads4.cakeweb.common.entidade.Produto;
import br.senac.tads4.cakeweb.common.service.ProdutoService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author fernando.tsuda
 */
public class ProdutoServiceJPAImpl implements ProdutoService {
  
  private EntityManagerFactory emFactory = 
	  Persistence.createEntityManagerFactory("CAKE_WEB_PU");

  @Override
  public List<Produto> listar(int offset, int quantidade) {
    EntityManager em = emFactory.createEntityManager();
    try {
      Query query = em.createQuery(
	      "SELECT DISTINCT p "
	      + "FROM Produto p "
	      + "LEFT JOIN FETCH p.categorias "
	      + "LEFT JOIN FETCH p.imagens");
      return query.getResultList();
    } finally {
      em.close();
    }
  }

  @Override
  public List<Produto> listarPorCategoria(Categoria categoria, int offset, int quantidade) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Produto obter(long idProduto) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void incluir(Produto p) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
