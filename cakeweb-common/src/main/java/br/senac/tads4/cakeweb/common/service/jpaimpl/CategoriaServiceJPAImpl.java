/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.cakeweb.common.service.jpaimpl;

import br.senac.tads4.cakeweb.common.entidade.Categoria;
import br.senac.tads4.cakeweb.common.service.CategoriaService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author fernando.tsuda
 */
public class CategoriaServiceJPAImpl implements CategoriaService {

    private EntityManagerFactory emFactory
	  = Persistence.createEntityManagerFactory("CAKE_WEB_PU");

  @Override
  public List<Categoria> listar() {
    EntityManager em = emFactory.createEntityManager();
    try {
      Query query = em.createNamedQuery("Categoria.findAll");
      return query.getResultList();
    } finally {
      em.close();
    }
  }

  @Override
  public Categoria obter(int id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}
