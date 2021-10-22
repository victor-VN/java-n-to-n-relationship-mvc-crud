<%@ page import="com.io.victorvn.controller.UsuarioController" %>
<%@ page import="com.io.victorvn.model.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 22/10/2021
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UsuarioController usuarioController = new UsuarioController();

    Usuario usuario = new Usuario(
            0,
            request.getParameter("nome"),
            request.getParameter("email"),
            "avatar",
            request.getParameter("descricao")
    );

    usuarioController.cadastrarUsuario(usuario);
    response.sendRedirect("../../homepage.jsp");
%>
