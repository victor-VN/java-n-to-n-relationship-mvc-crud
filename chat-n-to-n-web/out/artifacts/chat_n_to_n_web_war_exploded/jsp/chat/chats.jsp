<%@ page import="java.util.List" %>
<%@ page import="com.io.victorvn.model.UsuarioChat" %>
<%@ page import="com.io.victorvn.controller.UsuarioController" %>
<%@ page import="com.io.victorvn.model.Usuario" %>
<%@ page import="com.mysql.cj.util.StringUtils" %>
<%@ page import="com.io.victorvn.controller.UsuarioChatController" %>
<%@ page import="com.io.victorvn.model.Chat" %>
<%@ page import="com.io.victorvn.controller.ChatController" %><%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 21/10/2021
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%
    UsuarioController usuarioController = new UsuarioController();
    UsuarioChatController usuarioChatController = new UsuarioChatController();
    ChatController chatController = new ChatController();

    List<Chat> chatList = chatController.buscarTodosChats();
%>

<jsp:include page="../common/head.jsp" />

<body>


<jsp:include page="../common/navbar.jsp" />
<div class="container">
    <div class="row">
        <ul class="collection with-header">
            <li class="collection-header"><h4>Chats</h4></li>
            <% for (Chat chat : chatList){ %>

            <li class="collection-item">
                <div>
                    <%=chat.getNome().substring(0,1).toUpperCase() + chat.getNome().substring(1).toLowerCase()%>
                    <a href="#remUser<%=chat.getId()%>" class="modal-trigger secondary-content">
                        <i class="material-icons" style="color: red">clear</i>
                    </a>

                    <a href="#remChat<%=chat.getId()%>" class="modal-trigger secondary-content">
                        <i class="material-icons" style="color: black">remove</i>
                    </a>

                    <a href="#addChat<%=chat.getId()%>" class="modal-trigger secondary-content">
                        <i class="material-icons">add</i>
                    </a>

                    <a href="#dadosUsuario<%=chat.getId()%>" class="modal-trigger secondary-content">
                        <i class="material-icons" style="color: blue">create</i>
                    </a>
                </div>
            </li>

            <!-- Modal Structure -->
            <div id="dadosUsuario<%=chat.getId()%>" class="modal">
                <div class="container">
                    <div class="row">
                        <form class="col s12" action="../../process/chat/atualiza-chat.jsp" method="post">
                            <input type="hidden" value="<%=chat.getId()%>" name="chatId">
                            <div class="row" style="margin-top: 10%">
                                <div class="input-field col s4">
                                    <input placeholder="Placeholder" name="nome" value="<%=chat.getNome()%>" id="first_name" type="text" class="validate">
                                    <label for="first_name">Nome</label>
                                </div>
                                <div class="input-field col s4">
                                    <input id="status" type="text" name="status" value="<%=chat.getStatus()%>" class="validate">
                                    <label for="status">Status</label>
                                </div>
                                <div class="input-field col s4">
                                    <input id="capacidade" type="text" name="capacidade" value="<%=chat.getCapacidade()%>" class="validate">
                                    <label for="capacidade">Status</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s12">
                                    <input placeholder="Placeholder" name="assunto" value="<%=chat.getAssunto()%>" id="descrição" type="text" class="validate">
                                    <label for="first_name">Assunto</label>
                                </div>
                            </div>

                            <div class="row">
                                <button class="btn waves-effect waves-light" type="submit" name="action">Atualizar
                                    <i class="material-icons right">send</i>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="container">
                    <table class="responsive-table striped">
                        <thead>
                        <tr>
                            <th>Nome do Usuario</th>
                            <th>Email</th>
                            <th>Descrição</th>
                        </tr>
                        </thead>
                        <tbody>

                        <% for (Usuario usuario : usuarioChatController.listarTodosUsuariosDoChat(chat.getId())) { %>

                        <tr>
                            <td><%=usuario.getNome()%></td>
                            <td><%=usuario.getEmail()%></td>
                            <td><%=usuario.getDescricao()%></td>
                        </tr>
                        <% } %>

                        </tbody>
                    </table>

                    <div class="modal-footer">
                        <a href="#!" class="modal-close waves-effect waves-green btn-flat">Fechar</a>
                    </div>
                </div>
            </div>

            <!-- Modal Structure -->
            <div id="addChat<%=chat.getId()%>" class="modal modal-fixed-footer">
                <div class="container">
                    <div class="row" style="margin-top: 10%">
                        <form class="col s12" action="../../process/chat/adicionar-usuario-chat.jsp" method="post">
                            <div class="input-field col s6">
                                <input type="hidden" name="chatId" value="<%=chat.getId()%>">
                                <input type="text" id="buscaAdd" name="usuarioNome" value="" placeholder="Procurar...">
                            </div>
                            <div class="row">
                                <button class="btn waves-effect waves-light light-green darken-2" type="submit" name="action">Adicionar
                                    <i class="material-icons right">send</i>
                                </button>
                            </div>
                        </form>

                    </div>
                </div>

                <div class="modal-footer">
                    <a href="#!" class="modal-close waves-effect waves-green btn-flat">Fechar</a>
                </div>
            </div>


            <!-- Modal Structure -->
            <div id="remChat<%=chat.getId()%>" class="modal modal-fixed-footer" style="padding-bottom: 10%">
                <div class="container">
                    <div class="row" style="margin-top: 10%">
                        <form class="col s12" action="../../process/chat/remover-usuario-chat.jsp" method="post">
                            <div class="input-field col s6">
                                <input name="chatId" type="hidden" value="<%=chat.getId()%>">
                                <select name="usuarioId">
                                    <option value="" disabled selected>Escolha um usuário</option>
                                    <% for (Usuario usuario : usuarioChatController.listarTodosUsuariosDoChat(chat.getId())) { %>
                                    <option value="<%=usuario.getId()%>"><%=usuario.getNome()%></option>
                                    <% } %>
                                </select>
                                <label>Chats</label>
                            </div>

                            <div class="row">
                                <button class="btn waves-effect waves-light deep-orange accent-3" type="submit" name="action">Remover
                                    <i class="material-icons right">send</i>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="modal-footer">
                    <a href="#!" class="modal-close waves-effect waves-green btn-flat">Fechar</a>
                </div>
            </div>

            <div id="remUser<%=chat.getId()%>" class="modal modal-fixed-footer">
                <div class="container">
                    <div class="row" style="margin-top: 10%">
                        <form class="col s12" action="../../process/chat/remover-chat.jsp" method="post">
                            <h4>Tem certeza que deseja excluir o chat?</h4>
                            <div class="">
                                <input type="hidden" name="chatId" value="<%=chat.getId()%>">
                            </div>

                            <div class="row" style="margin-top: 10%">
                                <button class="btn waves-effect waves-light modal-close light-green darken-2" type="button" name="action">Cancelar
                                    <i class="material-icons right">send</i>
                                </button>
                                <button class="btn waves-effect waves-light deep-orange accent-3" type="submit" name="action">Remover
                                    <i class="material-icons right">send</i>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <%  } %>

        </ul>
    </div>
</div>
</body>
</html>
