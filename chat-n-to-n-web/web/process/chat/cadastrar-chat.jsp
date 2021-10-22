<%@ page import="com.io.victorvn.controller.ChatController" %>
<%@ page import="com.io.victorvn.model.Chat" %><%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 22/10/2021
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ChatController chatController = new ChatController();

    Chat chat = new Chat(
            0,
            request.getParameter("nome"),
            request.getParameter("status"),
            Integer.parseInt(request.getParameter("capacidade")),
            request.getParameter("assunto")
    );

    chatController.cadastrarChat(chat);
    response.sendRedirect("../../homepage.jsp");
%>
