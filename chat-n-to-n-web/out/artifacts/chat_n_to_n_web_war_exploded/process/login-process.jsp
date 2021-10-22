<%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 20/10/2021
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="com.io.victorvn.model.UserAuth" %>
<%@page import="com.io.victorvn.controller.UserAuthController" %>
<%@ page import="java.util.List" %>
<%
    String username = request.getParameter("nome");
    String senha = request.getParameter("senha");

    UserAuthController userAuthController = new UserAuthController();

    List<UserAuth> userAuthList = userAuthController.buscarUsuarioPorNome(username);

    if (userAuthList.isEmpty()){
        response.sendRedirect("../login.jsp");
    } else {
        UserAuth userAuth = userAuthList.get(0);

        if (userAuth.getPasswordUsr().equalsIgnoreCase(senha)){
            Cookie cookie = new Cookie("JASE", "ok");
            cookie.setMaxAge(5000);
            cookie.setPath("/");
            response.addCookie(cookie);

            response.sendRedirect("../homepage.jsp");
        } else {
            request.setAttribute("login_erro_message", "Usuario/Senha Inválidos!!");
            response.sendRedirect("../login.jsp");
        }
    }




%>
