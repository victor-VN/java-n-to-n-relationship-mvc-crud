<%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 20/10/2021
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="jsp/common/head.jsp" />

<body>

<div class="container mt-5" style="margin-top: 5%">
    <div class="row">
        <form class="col s12" action="./process/login-process.jsp" method="post">
            <div class="row">
                <div class="input-field col s12 m4 l4 xl4">
                    <input placeholder="Ex: admin" id="first_name" name="nome" type="text" class="validate">
                    <label for="first_name">Usuário</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12 m4 l4 xl4">
                    <input id="password" name="senha" type="password" class="validate">
                    <label for="password">Senha</label>
                </div>
            </div>

            <div class="row">
                <button class="btn waves-effect waves-light indigo darken-4" type="submit" name="action">Entrar
                    <i class="material-icons right">send</i>
                </button>
            </div>

        </form>
    </div>
</div>


</body>
</html>
