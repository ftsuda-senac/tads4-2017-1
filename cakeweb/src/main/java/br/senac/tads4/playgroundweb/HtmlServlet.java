/*
 * The MIT License
 *
 * Copyright 2017 fernando.tsuda.
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
package br.senac.tads4.playgroundweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "HtmlServlet", urlPatterns = {"/HtmlServlet"})
public class HtmlServlet extends HttpServlet {

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    Categoria c1 = new Categoria(1, "Bolo");
    Categoria c2 = new Categoria(2, "Chocolate");
    List<Categoria> categorias1 = Arrays.asList(c1, c2);

    Produto p1 = new Produto(1L, "Bolo de chocolate", "O melhor bolo do mundo", new BigDecimal("50.0"));
    p1.setCategorias(categorias1);

    StringBuilder strBuilder = new StringBuilder();
    strBuilder.append("<!DOCTYPE html>");
    strBuilder.append("<html>");
    strBuilder.append("<head>");
    strBuilder.append("<title>Servlet HtmlServlet</title>");
    strBuilder.append("</head>");
    strBuilder.append("<body>");
    strBuilder.append("<section>");
    strBuilder.append("<h1>Dados do Produto</h1>");
    strBuilder.append("<ul>");
    strBuilder.append("<li>").append(p1.getId()).append("</li>");
    strBuilder.append("<li>").append(p1.getNome()).append("</li>");
    strBuilder.append("<li>").append(p1.getDescricao()).append("</li>");
    strBuilder.append("<li><ul>");
    for (int i = 0; i < p1.getCategorias().size(); i++) {
      strBuilder.append("<li>").append(p1.getCategorias().get(i).getNome()).append("</li>");
    }
    strBuilder.append("</ul></li>");
    strBuilder.append("</ul>");
    strBuilder.append("</section>");
    strBuilder.append("</body>");
    strBuilder.append("</html>");

    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      out.print(strBuilder.toString());
    }
  }

}
