<%@ page import="com.io.victorvn.controller.UsuarioController" %>
<%@ page import="com.io.victorvn.controller.ChatController" %>
<%@ page import="com.io.victorvn.model.Chat" %>
<%@ page import="com.io.victorvn.model.Usuario" %>
<%@ page import="com.io.victorvn.controller.UsuarioChatController" %>
<%@ page import="com.io.victorvn.model.UsuarioChat" %><%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 22/10/2021
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UsuarioController usuarioController = new UsuarioController();
    ChatController chatController = new ChatController();
    UsuarioChatController usuarioChatController = new UsuarioChatController();

    Usuario usuario = usuarioController.buscarUsuarioPorNome(request.getParameter("usuarioNome")).get(0);

    UsuarioChat usuarioChat = new UsuarioChat(
            0,
            usuario,
            chatController.buscarChatPorId(Integer.parseInt(request.getParameter("chatId"))),
            "NAO",
            "NAO"
    );

    usuarioChatController.adicionarUsuarioNoChat(usuarioChat);
    response.sendRedirect("../../jsp/chat/chats.jsp");
%>
