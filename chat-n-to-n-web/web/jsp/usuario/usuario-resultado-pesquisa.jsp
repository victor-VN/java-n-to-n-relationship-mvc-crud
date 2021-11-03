<%@ page import="com.io.victorvn.model.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="com.io.victorvn.model.Chat" %>
<%@ page import="com.io.victorvn.controller.UsuarioChatController" %>
<%@ page import="com.io.victorvn.controller.ChatController" %>
<%@ page import="java.lang.reflect.Field" %><%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 02/11/2021
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../common/head.jsp" />
<body>
<jsp:include page="../common/navbar.jsp" />

<%
    List<Usuario> usuarioList = (List<Usuario>) request.getSession().getAttribute("usuarioList");

    UsuarioChatController usuarioChatController = new UsuarioChatController();

    ChatController chatController = new ChatController();
    List<Chat> allChats = chatController.buscarTodosChats();

%>

<script>
    $(document).ready(function(){
        $('td[class^="notrow"]').on('mouseenter', function () {
            let usuarioId = $(this).attr('id').split('-')[0];
            $('td[id^="'+usuarioId+'"]').css("background-color", "#f0f0f0")
        })

        $('td[class^="notrow"]').on('mouseleave', function () {
            //$(this).css
            $('td[class^="notrow"]').css("background-color", "white")
        })

        $('td[class^="notrow"]').on('click', function () {
            //let oi = window.location.href + $(this).attr('title');
            let usuarioId = $(this).attr('id').split('-')[0];

            document.location.href = $("#"+usuarioId).attr('title');
        })
    });

</script>

<div class="container">
    <div class="row">

        <% if (usuarioList.size() <= 1){ Usuario usuario = usuarioList.get(0); %>
                <form class="col s12" action="../../process/usuario/atualiza-usuario.jsp" method="post">
            <input type="hidden" value="<%=usuario.getId()%>" name="id">
        <input type="hidden" value="<%=usuario.getAvatar()%>" name="avatar">
        <div class="row" style="margin-top: 10%">
            <div class="input-field col s4">
                <input placeholder="Placeholder" name="nome" value="<%=usuario.getNome()%>" id="first_name-1" type="text" class="validate">
                <label for="first_name-1">Nome</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s4">
                <input id="email-1" type="text" name="email" value="<%=usuario.getEmail()%>" class="validate">
                <label for="email-1">Email</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s4">
                <input placeholder="Placeholder" name="descricao" value="<%=usuario.getDescricao()%>" id="descricao-1" type="text" class="validate">
                <label for="descricao-1">Descrição</label>
            </div>
        </div>

        <div class="row">
            <button class="btn waves-effect waves-light" type="submit" name="action">Atualizar
                <i class="material-icons right">send</i>
            </button>
        </div>
        </form>
        <% }  %>

        <% if (usuarioList.size() > 1) { %>

        <table style="margin-top: 5%">
            <thead>
            <tr>
                <% for (Field field: Usuario.class.getDeclaredFields()){  %>

                <% if (field.getName().equalsIgnoreCase("avatar")) { %>
                <th>Sobrenome</th>
                <% } %>

                <% if (!field.getName().equalsIgnoreCase("avatar")) { %>
                <th><%=field.getName().substring(0,1).toUpperCase() + field.getName().substring(1).toLowerCase()%></th>
                <% } %>

                <% } %>
            </tr>
            </thead>

            <tbody>

            <% for (Usuario usuario : usuarioList) { %>

        <tr style="cursor: pointer;" id="nothead<%=usuario.getId()%>">

            <td class="notrow"
                title="../../process/usuario/buscar-usuario-unico.jsp?id=<%=usuario.getId()%>"
                id="<%=usuario.getId()%>"><%=usuario.getId()%></td>

            <td class="notrow" id="<%=usuario.getId()%>-nome-"><%=usuario.getNome().substring(0,1).toUpperCase() + usuario.getNome().substring(1).toLowerCase()%></td>
            <td class="notrow" id="<%=usuario.getId()%>-email-<%=usuario.getId()%>"><%=usuario.getEmail()%></td>
            <td class="notrow" id="<%=usuario.getId()%>-avatar-<%=usuario.getId()%>"><%=usuario.getAvatar()%></td>
            <td class="notrow" id="<%=usuario.getId()%>-descricao-<%=usuario.getId()%>"><%=usuario.getDescricao()%></td>
            <td>
                <div>
                    <a href="#remUser<%=usuario.getId()%>" class="modal-trigger secondary-content">
                        <i class="material-icons" style="color: red">clear</i>
                    </a>

                    <a href="#remChat<%=usuario.getId()%>" class="modal-trigger secondary-content">
                        <i class="material-icons" style="color: black">remove</i>
                    </a>

                    <a href="#addChat<%=usuario.getId()%>" class="modal-trigger secondary-content">
                        <i class="material-icons">add</i>
                    </a>

                    <a href="#dadosUsuario<%=usuario.getId()%>" class="modal-trigger secondary-content">
                        <i class="material-icons" style="color: blue">create</i>
                    </a>
                </div>
            </td>

        </tr>

        <%  } %>

        </tbody>
        </table>


        <% for (Usuario usuario: usuarioList) { %>
        <!-- Modal Structure -->
        <div id="dadosUsuario<%=usuario.getId()%>" class="modal">
            <div class="container">
                <div class="row">
                    <form class="col s12" action="../../process/usuario/atualiza-usuario.jsp" method="post">
                        <input type="hidden" value="<%=usuario.getId()%>" name="id">
                        <input type="hidden" value="<%=usuario.getAvatar()%>" name="avatar">
                        <div class="row" style="margin-top: 10%">
                            <div class="input-field col s6">
                                <input placeholder="Placeholder" name="nome" value="<%=usuario.getNome()%>" id="first_name" type="text" class="validate">
                                <label for="first_name">Nome</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="sobrenome" type="text" name="sobrenome" value="<%=usuario.getAvatar()%>" class="validate">
                                <label for="sobrenome">Sobrenome</label>
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s12">
                                <input id="email" type="text" name="email" value="<%=usuario.getEmail()%>" class="validate">
                                <label for="email">Email</label>
                            </div>
                        </div>


                        <div class="row">
                            <div class="input-field col s12">
                                <input placeholder="Placeholder" name="descricao" value="<%=usuario.getDescricao()%>" id="descrição" type="text" class="validate">
                                <label for="first_name">Descrição</label>
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
                        <th>Nome do Chat</th>
                        <th>Status</th>
                        <th>Capacidade Máxima</th>
                        <th>Assunto</th>
                    </tr>
                    </thead>
                    <tbody>

                    <% for (Chat chat : usuarioChatController.listarTodosChatsDoUsuario(usuario.getId())) { %>

                    <tr>
                        <td><%=chat.getNome()%></td>
                        <td><%=chat.getStatus()%></td>
                        <td><%=chat.getCapacidade()%></td>
                        <td><%=chat.getAssunto()%></td>
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
        <div id="addChat<%=usuario.getId()%>" class="modal modal-fixed-footer" style="padding-bottom: 10%">
            <div class="container">
                <div class="row" style="margin-top: 10%">
                    <form class="col s12" action="../../process/usuario/adicionar-chat-usuario.jsp">
                        <div class="input-field col s6">
                            <input type="hidden" name="usuarioId" value="<%=usuario.getId()%>">
                            <select name="chatId">
                                <option value="" disabled selected>Escolha um chat</option>
                                <% for (Chat chat : allChats) { %>
                                <% if (!usuarioChatController.listarTodosChatsDoUsuario(usuario.getId()).isEmpty()) { %>
                                <% for (Chat chatUsuario : usuarioChatController.listarTodosChatsDoUsuario(usuario.getId())){ %>
                                <% if (chat.getId() != chatUsuario.getId()) { %>
                                <option value="<%=chat.getId()%>"><%=chat.getNome()%></option>
                                <% } %>
                                <% } %>
                                <% } %>
                                <% if (usuarioChatController.listarTodosChatsDoUsuario(usuario.getId()).isEmpty()){ %>
                                <option value="<%=chat.getId()%>"><%=chat.getNome()%></option>
                                <% } %>
                                <% } %>
                            </select>
                            <label>Chats</label>
                        </div>

                        <div class="row">
                            <button class="btn waves-effect waves-light light-green darken-2" type="submit" name="action">Salvar
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
        <div id="remChat<%=usuario.getId()%>" class="modal modal-fixed-footer" style="padding-bottom: 10%">
            <div class="container">
                <div class="row" style="margin-top: 10%">
                    <form class="col s12" action="../../process/usuario/remover-chat-usuario.jsp">
                        <div class="input-field col s6">
                            <input name="usuarioId" type="hidden" value="<%=usuario.getId()%>">
                            <select name="chatId">
                                <option value="" disabled selected>Escolha um chat</option>
                                <% for (Chat chat : usuarioChatController.listarTodosChatsDoUsuario(usuario.getId())) { %>
                                <option value="<%=chat.getId()%>"><%=chat.getNome()%></option>
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

        <div id="remUser<%=usuario.getId()%>" class="modal modal-fixed-footer">
            <div class="container">
                <div class="row" style="margin-top: 10%">
                    <form class="col s12" action="../../process/usuario/remover-usuario.jsp">
                        <h4>Tem certeza que deseja excluir o usuário?</h4>
                        <div class="">
                            <input type="hidden" value="<%=usuario.getId()%>" name="usuarioId">
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

        <% } %>


        <% } %>
    </div>
</div>
</body>
</html>
