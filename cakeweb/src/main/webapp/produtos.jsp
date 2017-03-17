<%-- 
    Document   : produtos
    Created on : 16/03/2017, 20:40:30
    Author     : fernando.tsuda
--%>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="br.senac.tads4.playgroundweb.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <%
    Produto p1 = new Produto(1L, "Bolo de chocolate", 
	    "descrição do bolo de chocolate", 
	    new BigDecimal("30.0"));
    Produto p2 = new Produto(1L, "Bolo de cenoura", 
	    "descrição do bolo de cenoura", new BigDecimal("20.0"));
    List<Produto> lista = Arrays.asList(p1, p2);
    %>
    <h1>Cake Web - JSP + Scriptlet</h1>
    <ul>
      <% for (Produto p : lista) { %>
      <li><div>
	<h3><%= p.getNome() %></h3>
	<p><%= p.getDescricao() %></p>
	<p><%= p.getPreco().toString() %></p>
      <% } %>
      </div></li>
    </ul>
  </body>
</html>
