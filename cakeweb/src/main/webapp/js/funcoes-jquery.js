$(function () {
  mostrarMensagem("DOMLoaded");

  // Exemplo 1 - animação no mouseover/mouseout
  /*
   $("#sobreprincipal").mouseover(function() {
   $(this).css("background-color", "#f00");
   });
   $("#sobreprincipal").mouseout(function() {
   $(this).css("background-color", "#ccc");
   });
   */

  // Mesmo código
  $("#sobreprincipal").on("mouseover", function () {
    //$(this).css("background-color", "#0f0");
    $(this).addClass("ativo");
  }).on("mouseout", function () {
    //$(this).css("background-color", "#ccc");
    $(this).removeClass("ativo");
  });

  // Exemplo 2 - Validação de formulário
  $("#frmcontato").submit(function (ev) {
    var empresa = $("#txtempresa").val();
    var responsavel = $("#txtresponsavel").val();
    var email = $("#txtemail").val();
    if (empresa !== '' && responsavel !== '' && email !== '') {
      return true;
    }
    alert("Preencha os campos");
    ev.preventDefault();
  });

  // Exemplo 3 - Criação dinâmica de elementos HTML
  $("#btnadicionar1").click(function () {
    $("#secao").html("<section>" +
	    "<h1>Nova seção</h1>" +
	    "<p>Lorem ipsum</p>" +
	    "</section>");
  });

  // Exemplo 4 - Chamada AJAX
  $("#btnadicionar2").on("click", function () {
    /*
    $.ajax({
      method: "GET",
      url: "AjaxServlet",
      dataType: "json"
    }).done(function (dataJSON) {
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
      
      var conteudoAntigo = $("#secaoAjax").html();
      $("#secaoAjax").html(conteudoAntigo + htmlSecao);
    });
    */
    // Versão reduzida
    $.getJSON("AjaxServlet", function(dataJSON) {
      var htmlSecao = "<section><h1>Dados do Produto versão reduzida</h1>" +
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
      
      var conteudoAntigo = $("#secaoAjax").html();
      $("#secaoAjax").html(conteudoAntigo + htmlSecao);
    });
   
  });




});

function mostrarMensagem(origem) {
  var mensagem = origem + " Bem vindo a Cake Web";
  var contador = 1;
  alert(mensagem + " " + contador);
}

