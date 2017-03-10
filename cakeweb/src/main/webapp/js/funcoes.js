// http://youmightnotneedjquery.com
var documentReady = function(fn) {
  if (document.readyState !== "loading") {
    fn();
  } else {
    document.addEventListener("DOMContentLoaded", fn);
  }
};

documentReady(function() {
  
  // Exemplo 1 - animação no mouseover/mouseout
  var areaPrincipal = document.getElementById("sobreprincipal");
  areaPrincipal.addEventListener("mouseover", function() {
    //this.style.backgroundColor = "#f00";
    this.classList.add("ativo");
  });
  areaPrincipal.addEventListener("mouseout", function() {
    //this.style.backgroundColor = "#ccc";
    this.classList.remove("ativo");
  });
  
  // Exemplo 2 - validação de formulário
  var formulario = document.getElementById("frmcontato");
  formulario.addEventListener("submit", function(ev) {
    var empresa = document.getElementById("txtempresa");
    var responsavel = document.getElementById("txtresponsavel");
    var email = document.getElementById("txtemail");
    
    if (empresa.value !== ''&& responsavel.value !== '' && email.value !== '') {
      return true;
    }
    alert("Preencha os campos");
    ev.preventDefault();
  });
  
  // Exemplo 3 - Criação de elementos HTML
  var botao1 = document.getElementById("btnadicionar1");
  botao1.addEventListener("click", function(ev) {
    var novaSecao = document.getElementById("secao");
    novaSecao.innerHTML = "<section><h1>Nova seção</h1>" +
	    "<p>Lorem ipsum</p></section>";
  });
  
  // Exemplo 4 - Chamada AJAX
  var botao2 = document.getElementById("btnadicionar2");
  botao2.addEventListener("click", function(ev) {
    var request = new XMLHttpRequest();
    request.open("GET", "AjaxServlet", true);
    request.onload = function() {
      if (request.status >= 200 && request.status < 300) {
	var response = request.responseText;
	var dataJSON = JSON.parse(response);
	
	var htmlSecao = "<section><h1>Dados do Produto</h1>" +
		"<ul>" +
		"<li>" + dataJSON.id + "</li>" +
		"<li>" + dataJSON.nome + "</li>" +
		"<li>" + dataJSON.descricao + "</li>" +
		"<li>Categorias" + 
		"<ul>";
	for (var i = 0; i < dataJSON.categorias.length; i++) {
	  htmlSecao += "<li>" + dataJSON.categorias[i].nome + "</li>";
	}	
	htmlSecao += "</ul></li></ul></section>";
	var secaoAjax = document.getElementById("secaoAjax");
	secaoAjax.innerHTML += htmlSecao;
      }
    }
    request.send();

  });

});

function mostrarMensagem(origem) {
  var mensagem = origem + " Bem vindo a Cake Web";
  var contador = 1;
  alert(mensagem + " " + contador);
}