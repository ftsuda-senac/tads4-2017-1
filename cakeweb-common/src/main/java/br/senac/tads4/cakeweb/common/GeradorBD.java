/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.cakeweb.common;

import javax.persistence.Persistence;

/**
 * https://antoniogoncalves.org/2014/12/11/generating-database-schemas-with-jpa-2-1/
 * @author fernando.tsuda
 */
public class GeradorBD {
  
  public static void main(String... args) {
    Persistence.generateSchema("CAKE_WEB_PU", null);
  }
  
}
