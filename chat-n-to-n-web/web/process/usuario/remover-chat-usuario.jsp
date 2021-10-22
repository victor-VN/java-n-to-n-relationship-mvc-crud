<%@ page import="com.io.victorvn.controller.UsuarioChatController" %><%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 22/10/2021
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UsuarioChatController usuarioChatController = new UsuarioChatController();

    usuarioChatController.removerUsuarioDoChat(
            Integer.parseInt(request.getParameter("usuarioId")),
            Integer.parseInt(request.getParameter("chatId"))
    );

    response.sendRedirect("../../jsp/usuario/usuarios.jsp");

%>
