/*
 * The MIT License
 *
 * Copyright 2016 Fernando.
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
import br.senac.tads4.cakeweb.service.CategoriaService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fernando
 */
public class CategoriaServiceFakeImpl implements CategoriaService {

  private static final Map<Integer, Categoria> MAP_CATEGORIA = new LinkedHashMap<Integer, Categoria>();

  static {
    MAP_CATEGORIA.put(1, new Categoria(1, "Bolo"));
    MAP_CATEGORIA.put(2, new Categoria(2, "Torta"));
    MAP_CATEGORIA.put(3, new Categoria(3, "Chocolate"));
    MAP_CATEGORIA.put(4, new Categoria(4, "Morango"));
    MAP_CATEGORIA.put(5, new Categoria(5, "Light"));
    MAP_CATEGORIA.put(6, new Categoria(6, "Crocante"));
    MAP_CATEGORIA.put(7, new Categoria(7, "Abacaxi"));
    MAP_CATEGORIA.put(8, new Categoria(8, "Coco"));
  }

  @Override
  public List<Categoria> listar() {
    return new ArrayList<Categoria>(MAP_CATEGORIA.values());
  }

  @Override
  public Categoria obter(int id) {
    return MAP_CATEGORIA.get(id);
  }
}
