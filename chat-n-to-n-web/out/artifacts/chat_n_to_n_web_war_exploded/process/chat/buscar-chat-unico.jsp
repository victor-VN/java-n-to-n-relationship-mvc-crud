<%@ page import="com.io.victorvn.controller.ChatController" %>
<%@ page import="com.io.victorvn.model.Chat" %><%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 02/11/2021
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    ChatController chatController = new ChatController();
    Chat chat = chatController.buscarChatPorId(id);

    HttpSession httpSession = request.getSession();
    session.setAttribute("chat", chat);

    if(chat == null){
        response.sendRedirect("../../homepage.jsp");
    } else {
        response.sendRedirect("../../jsp/chat/chat-unico.jsp");
    }

%>

