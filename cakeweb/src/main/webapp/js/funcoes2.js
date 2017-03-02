/*
 * Função que associa uma funçào listener quando o DOM é carregado
 * Obtido em http://youmightnotneedjquery.com/
 */
var documentReady = function (fn) {
  if (document.readyState !== 'loading') {
    fn();
  } else {
    document.addEventListener('DOMContentLoaded', fn);
  }
};

// http://flatuicolors.com/
var cores = ["#1dd2af", "#3498db", "#9b59b6", "#f1c40f", "#e67e22", "#e74c3c"];
var i = 0;
var interval;

/*
 * Adicionar classe ao elemento.
 * Obtido em http://youmightnotneedjquery.com/
 */
function addClass(el, className) {
  if (el.classList) {
    el.classList.add(className);
  } else {
    el.className += ' ' + className;
  }
}

/*
 * Remove classe do elemento
 * Obtido em http://youmightnotneedjquery.com/
 */
function removeClass(el, className) {
  if (el.classList) {
    el.classList.remove(className);
  } else {
    el.className = el.className.replace(new RegExp('(^|\\b)' + className.split(' ').join('|') + '(\\b|$)', 'gi'), ' ');
  }
}

documentReady(function () {
  i = 0;
  interval = setInterval(function () {
    var elemento = document.getElementById("titulo");
    elemento.style.backgroundColor = cores[i];
    i++;
    if (i >= cores.length) {
      i = 0;
    }
  }, 500);

  // 1) Mostar alert com o nome do curriculo
  var titulos = document.getElementsByTagName("h1");
  for (var i = 0; i < titulos.length; i++) {
    var texto = titulos[i].textContent;
    alert("O texto da tag <h1> é " + texto);
    break;
  }

  // 2) Adiciona tratamento para os eventos de mouseover (mouse sobre o elemento)
  // e mouseout (mouse fora do elemento). Quando isso ocorre, é adicionado ou
  // removido a classe info-selecionado, que altera as propriedades visuais do
  // elemento.
  var elements = document.querySelectorAll(".info");

  for (var i = 0; i < elements.length; i++) {
    elements[i].addEventListener("mouseover", function () {
      addClass(this, "info-selecionado");
    });
    elements[i].addEventListener("mouseout", function () {
      removeClass(this, "info-selecionado");
    });
    // OBS: NO ARQUIVO CSS, COLOCAR A DECLARACAO DO info-selecionado DEPOIS
    // DO info, POIS O BROWSER VAI USAR PROPRIEDADE QUE APARECE POR ULTIMO 
    // NO CSS
  }

  // 3) Adicionar uma nova seção no curriculo ao clicar no botão com id "botao1".
  document.getElementById("botao1").addEventListener("click", function () {
    var areaTexto = document.getElementById("area1");
    if (areaTexto) {
      areaTexto.innerHTML = "<section class=\"info\">" +
              "<h2>Nova área adicionada pelo JS</h2>" +
              "<div>Então, aqui, hoje, eu tô saudando a mandioca, uma das maiores conquistas do Brasil.</div>" +
              "</section>";
    }
  });

  // 4) Criacao formal de elementos HTML.
  document.getElementById("botao2").addEventListener("click", function () {
    // 4A) cria <section> e configura o class="info"
    var elementoSection = document.createElement("section");
    var atributoSection = document.createAttribute("class");
    atributoSection.value = "info";
    elementoSection.setAttributeNode(atributoSection);

    // 4B) cria <h2>Título criado via Javascript</h2>
    var elementoH2 = document.createElement("h2");
    var textoH1 = document.createTextNode("Título criado via Javascript");
    elementoH2.appendChild(textoH1);

    // 4C) cria <p>Gente que nunca morreu antes está morrendo hoje.</p>
    var elementoP = document.createElement("p");
    var textoP = document.createTextNode("Gente que nunca morreu antes está morrendo hoje.");
    elementoP.appendChild(textoP);

    // 4D) Coloca <h1> e <p> como filhos do <section>.
    elementoSection.appendChild(elementoH2);
    elementoSection.appendChild(elementoP);

    // 4E) Coloca section no placeholder de id="area2" no DOM.
    document.getElementById("area2").appendChild(elementoSection);
  });

  // 5) Validacao de formulario
  document.getElementsByTagName("form")[0]
          .addEventListener("submit", function (ev) {
    var nome = this.nome;
    var email = this.email;
    if (nome.value != "" && nome.value != null 
            && email.value != "" && email.value != null) {
      return true;
    }
    alert("Preencha os campos");
    ev.preventDefault();
  });


  // 6) AJAX
  document.getElementById("botao3").addEventListener("click", function () {
    var request = new XMLHttpRequest();
    request.open('GET', 'AjaxServlet', true);

    request.onload = function () {
      if (request.status >= 200 && request.status < 300) {
        // Successo!
        var dataJSON = JSON.parse(request.responseText);
        var htmlDom = "<section class=\"info\"><h2>Dados do produto</h2><ul>" +
                "<li>ID: " + dataJSON.id + "</li>" +
                "<li>Nome: " + dataJSON.nome + "</li>" +
                "<li>Descricao: " + dataJSON.descricao + "</li>" +
                "<li>Categorias:<ul>";

        for (var i = 0; i < dataJSON.categorias.length; i++) {
          htmlDom = htmlDom + "<li>" + dataJSON.categorias[i].nome + "</li>";
        }
        htmlDom = htmlDom + "</ul></li></ul></section>";
        document.getElementById("area3").innerHTML = htmlDom;
      } else {
        // Servidor retornou algum erro
      }
    };

    request.onerror = function () {
      // There was a connection error of some sort
      alert("Erro");
    };

    request.send();
  });
});