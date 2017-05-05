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
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author fernando.tsuda
 */
@Default
public class ProdutoServiceJPAImpl implements ProdutoService {

  private EntityManagerFactory emFactory
	  = Persistence.createEntityManagerFactory("CAKE_WEB_PU");

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
    EntityManager em = emFactory.createEntityManager();
    try {
      Query query = em.createQuery(
	      "SELECT DISTINCT p "
	      + "FROM Produto p "
	      + "LEFT JOIN FETCH p.categorias "
	      + "LEFT JOIN FETCH p.imagens "
	      + "INNER JOIN p.categorias c "
	      + "WHERE c.id = :idCat");
      return query.getResultList();
    } finally {
      em.close();
    }
  }

  @Override
  public Produto obter(long idProduto) {
    EntityManager em = emFactory.createEntityManager();
    try {
      Query query = em.createQuery("SELECT p "
	      + "FROM Produto p "
	      + "LEFT JOIN FETCH p.categorias "
	      + "LEFT JOIN FETCH p.imagens "
	      + "WHERE p.id = :idProd")
	      .setParameter("idProd", idProduto);
      Produto p = (Produto) query.getSingleResult();
      return p;
    } finally {
      em.close();
    }
  }

  @Override
  public void incluir(Produto p) {
    EntityManager em = emFactory.createEntityManager();
    EntityTransaction transacao = em.getTransaction();
    try {
      transacao.begin();
      for (Categoria c : p.getCategorias()) {
	if (c.getId() != null) {
	  em.merge(c);
	} else {
	  em.persist(c);
	}
      }
      em.persist(p);
      transacao.commit();
    } catch (Exception e) {
      transacao.rollback();
    } finally {
      em.close();
    }
  }

  @Override
  public void alterar(Produto p) {
    EntityManager em = emFactory.createEntityManager();
    EntityTransaction transacao = em.getTransaction();
    try {
      transacao.begin();
      for (Categoria c : p.getCategorias()) {
	if (c.getId() != null) {
	  em.merge(c);
	} else {
	  em.persist(c);
	}
      }
      p = em.merge(p);
      transacao.commit();
    } catch (Exception e) {
      transacao.rollback();
    } finally {
      em.close();
    }
  }

  @Override
  public void remover(long idProduto) {
    EntityManager em = emFactory.createEntityManager();
    EntityTransaction transacao = em.getTransaction();
    try {
      transacao.begin();
      Produto p = em.find(Produto.class, idProduto);
      em.remove(p);
      transacao.commit();
    } catch (Exception e) {
      transacao.rollback();
    } finally {
      em.close();
    }
  }

}
