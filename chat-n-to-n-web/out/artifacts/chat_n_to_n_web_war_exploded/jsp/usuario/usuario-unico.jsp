<%@ page import="com.io.victorvn.model.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 02/11/2021
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../common/head.jsp" />
<body>
<jsp:include page="../common/navbar.jsp" />

<%
    Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

%>

<div class="container">
    <div class="row">
        <form class="col s12" action="../../process/usuario/atualiza-usuario.jsp" method="post">
            <input type="hidden" value="<%=usuario.getId()%>" name="id">
            <input type="hidden" value="<%=usuario.getAvatar()%>" name="avatar">
            <div class="row" style="margin-top: 10%">
                <div class="input-field col s4">
                    <input placeholder="Placeholder" name="nome" value="<%=usuario.getNome()%>" id="first_name" type="text" class="validate">
                    <label for="first_name">Nome</label>
                </div>
            </div>

            <div class="row">
                <div class="input-field col s4">
                    <input id="email" type="text" name="email" value="<%=usuario.getEmail()%>" class="validate">
                    <label for="email">Email</label>
                </div>
            </div>

            <div class="row">
                <div class="input-field col s4">
                    <input placeholder="Placeholder" name="descricao" value="<%=usuario.getDescricao()%>" id="descrição" type="text" class="validate">
                    <label for="first_name">Descrição</label>
                </div>
            </div>

            <div class="row">
                <button class="btn waves-effect waves-light" type="submit" name="action">Atualizar
                    <i class="material-icons right">send</i>
                </button>
                <button onclick="history.back()" class="btn waves-effect waves-light deep-orange accent-3" type="submit" name="action">Cancelar
                    <i class="material-icons right">send</i>
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
