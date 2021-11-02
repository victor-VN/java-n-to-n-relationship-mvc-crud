<%@ page import="com.io.victorvn.controller.UsuarioController" %>
<%@ page import="java.util.List" %>
<%@ page import="com.io.victorvn.model.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 02/11/2021
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String usuarioNome = request.getParameter("usuarioNome");
    UsuarioController usuarioController = new UsuarioController();

    List<Usuario> usuarioList = usuarioController.buscarUsuarioPorNome(usuarioNome);
    HttpSession httpSession = request.getSession();
    session.setAttribute("usuarioList", usuarioList);

    if (usuarioList.isEmpty()){
        response.sendRedirect("../../homepage.jsp");
    } else {
        response.sendRedirect("../../jsp/usuario/usuario-resultado-pesquisa.jsp");
    }
%>