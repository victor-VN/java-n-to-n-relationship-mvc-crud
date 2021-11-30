<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 20/10/2021
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Cookie[] cookies = request.getCookies();
    boolean isSessionOk = false;
    String cookieValue = "";

    for (Cookie cookie : cookies){
        if (cookie.getName().equalsIgnoreCase("JASE")){
            cookieValue = cookie.getValue();
        }
    }

    if (!cookieValue.equalsIgnoreCase("ok")){
        response.sendRedirect("./login.jsp");
    }

%>
<html>
<jsp:include page="jsp/common/head.jsp" />
<body>

<jsp:include page="jsp/common/navbar.jsp" />

<div class="container">
    <div class="row" style="margin-top: 10%">
      <div class="col s12 m6">
          <div class="collection">
              <a href="#dadosUsuario" class="modal-trigger collection-item">Adicionar Usuário</a>
              <a href="#dadosChat" class="modal-trigger collection-item">Adicionar Chat</a>
          </div>
      </div>
    </div>

    <!-- Modal Structure -->
    <div id="dadosChat" class="modal">
        <div class="container">
            <div class="row">
                <form class="col s12" action="process/chat/cadastrar-chat.jsp" method="post">
                    <input type="hidden" value="" name="chatId">
                    <div class="row" style="margin-top: 10%">
                        <div class="input-field col s4">
                            <input placeholder="Ex: Chat da Galera" name="nome" value="" id="nomeChat" type="text" class="validate">
                            <label for="nomeChat">Nome</label>
                        </div>
                        <div class="input-field col s4">
                            <input id="status" type="text" name="status" value="" class="validate">
                            <label for="status">Status</label>
                        </div>
                        <div class="input-field col s4">
                            <input id="capacidade" type="number" name="capacidade" value="" class="validate">
                            <label for="capacidade">Capacidade</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s12">
                            <input placeholder="Ex: Chat para discussões so condomínio" name="assunto" value="" id="descrição" type="text" class="validate">
                            <label for="first_name">Assunto</label>
                        </div>
                    </div>

                    <div class="row">
                        <button class="btn waves-effect waves-light" type="submit" name="action">Salvar
                            <i class="material-icons right">send</i>
                        </button>
                    </div>
                </form>
            </div>
        </div>

        <div class="container">
            <div class="modal-footer">
                <a href="#!" class="modal-close waves-effect waves-green btn-flat">Fechar</a>
            </div>
        </div>
    </div>


    <!-- Modal Structure -->
    <div id="dadosUsuario" class="modal">
        <div class="container">
            <div class="row">
                <form class="col s12" action="process/usuario/cadastrar-usuario.jsp" method="post">
                    <input type="hidden" value="" name="chatId">
                    <div class="row" style="margin-top: 10%">
                        <div class="input-field col s6">
                            <input placeholder="Ex: Mario" name="nome" value="" id="first_name" type="text" class="validate">
                            <label for="first_name">Nome</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="sobrenome" type="text" name="sobrenome" value="" class="validate">
                            <label for="sobrenome">Sobrenome</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s12">
                            <input id="email" type="text" name="email" value="" class="validate">
                            <label for="email">Email</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s12">
                            <input placeholder="Ex: Meu hobby favorito é jogar video-game" name="descricao" value="" id="descricao" type="text" class="validate">
                            <label for="descricao">Descricao</label>
                        </div>
                    </div>

                    <div class="row">
                        <button class="btn waves-effect waves-light" type="submit" name="action">Salvar
                            <i class="material-icons right">send</i>
                        </button>
                    </div>
                </form>
            </div>
        </div>

        <div class="container">
            <div class="modal-footer">
                <a href="#!" class="modal-close waves-effect waves-green btn-flat">Fechar</a>
            </div>
        </div>
    </div>

</div>

</body>
</html>
