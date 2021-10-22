<%@ page import="com.io.victorvn.controller.UsuarioController" %>
<%@ page import="com.io.victorvn.controller.UsuarioChatController" %>
<%@ page import="com.io.victorvn.controller.ChatController" %>
<%@ page import="java.util.List" %>
<%@ page import="com.io.victorvn.model.Chat" %><%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 22/10/2021
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    UsuarioController usuarioController = new UsuarioController();
    UsuarioChatController usuarioChatController = new UsuarioChatController();
    ChatController chatController = new ChatController();

    List<Chat> chatList = chatController.buscarTodosChats();
    int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
    for (Chat chat : chatList){
        usuarioChatController.removerUsuarioDoChat(usuarioId, chat.getId());
    }
    usuarioController.excluirUsuario(usuarioId);

    response.sendRedirect("../../jsp/usuario/usuarios.jsp");
%>
