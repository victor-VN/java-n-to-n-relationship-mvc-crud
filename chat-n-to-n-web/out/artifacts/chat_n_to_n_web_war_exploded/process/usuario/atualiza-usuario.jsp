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
            Integer.parseInt(request.getParameter("id")),
            request.getParameter("nome"),
            request.getParameter("email"),
            request.getParameter("sobrenome"),
            request.getParameter("descricao")
    );

    usuarioController.atualizarUsuario(usuario);
    response.sendRedirect("../../jsp/usuario/usuarios.jsp");

%>
