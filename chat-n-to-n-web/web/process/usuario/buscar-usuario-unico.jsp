<%@ page import="com.io.victorvn.controller.UsuarioController" %>
<%@ page import="com.io.victorvn.model.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 02/11/2021
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    UsuarioController usuarioController = new UsuarioController();
    Usuario usuario = usuarioController.buscarUsuarioPorId(id);

    HttpSession httpSession = request.getSession();
    session.setAttribute("usuario", usuario);

    if(usuario == null){
        response.sendRedirect("../../homepage.jsp");
    } else {
        response.sendRedirect("../../jsp/usuario/usuario-unico.jsp");
    }

%>


<%--<%=request.getParameter("id")%><br>--%>
<%--<%=request.getRequestURI()%><br>--%>
<%--<%=request.getRequestURL()%>--%>