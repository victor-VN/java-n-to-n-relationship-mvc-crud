<%@ page import="com.io.victorvn.controller.UsuarioChatController" %>
<%@ page import="com.io.victorvn.controller.ChatController" %>
<%@ page import="com.io.victorvn.model.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 22/10/2021
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UsuarioChatController usuarioChatController = new UsuarioChatController();
    ChatController chatController = new ChatController();

    for (Usuario usuario : usuarioChatController.listarTodosUsuariosDoChat(Integer.parseInt(request.getParameter("chatId")))){
        usuarioChatController.removerUsuarioDoChat(usuario.getId(), Integer.parseInt(request.getParameter("chatId")));
    }

    chatController.deletarChat(Integer.parseInt(request.getParameter("chatId")));
    response.sendRedirect("../../jsp/chat/chats.jsp");

%>
