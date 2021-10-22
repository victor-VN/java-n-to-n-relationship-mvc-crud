<%@ page import="com.io.victorvn.controller.UsuarioChatController" %>
<%@ page import="com.io.victorvn.model.UsuarioChat" %>
<%@ page import="com.io.victorvn.controller.UsuarioController" %>
<%@ page import="com.io.victorvn.controller.ChatController" %><%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 22/10/2021
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    UsuarioChatController usuarioChatController = new UsuarioChatController();
    UsuarioController usuarioController = new UsuarioController();
    ChatController chatController = new ChatController();


    UsuarioChat usuarioChat = new UsuarioChat(
            0,
            usuarioController.buscarUsuarioPorId(Integer.parseInt(request.getParameter("usuarioId"))),
            chatController.buscarChatPorId(Integer.parseInt(request.getParameter("chatId"))),
            "NAO",
            "NAO"
    );

    usuarioChatController.adicionarUsuarioNoChat(usuarioChat);
    response.sendRedirect("../../jsp/usuario/usuarios.jsp");

%>

