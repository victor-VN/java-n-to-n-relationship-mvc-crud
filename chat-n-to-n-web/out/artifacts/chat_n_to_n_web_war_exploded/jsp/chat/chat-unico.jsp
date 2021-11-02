<%@ page import="com.io.victorvn.model.Usuario" %>
<%@ page import="com.io.victorvn.model.Chat" %><%--
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
    Chat chat = (Chat) request.getSession().getAttribute("chat");

%>

<div class="container">
    <div class="row">
        <form class="col s12" action="../../process/chat/atualiza-chat.jsp" method="post">
            <input type="hidden" value="<%=chat.getId()%>" name="chatId">
            <div class="row" style="margin-top: 10%">
                <div class="input-field col s4">
                    <input placeholder="Placeholder" name="nome" value="<%=chat.getNome()%>" id="first_name" type="text" class="validate">
                    <label for="first_name">Nome</label>
                </div>
            </div>

            <div class="row">
                <div class="input-field col s4">
                    <input id="status" type="text" name="status" value="<%=chat.getStatus()%>" class="validate">
                    <label for="status">Status</label>
                </div>
            </div>

            <div class="row" >
                <div class="input-field col s4">
                    <input id="capacidade" type="text" name="capacidade" value="<%=chat.getCapacidade()%>" class="validate">
                    <label for="capacidade">Status</label>
                </div>
            </div>

            <div class="row">
                <div class="input-field col s8">
                    <input placeholder="Placeholder" name="assunto" value="<%=chat.getAssunto()%>" id="descrição" type="text" class="validate">
                    <label for="first_name">Assunto</label>
                </div>
            </div>

            <div class="row">
                <button class="btn waves-effect waves-light" type="submit" name="action">Atualizar
                    <i class="material-icons right">send</i>
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
