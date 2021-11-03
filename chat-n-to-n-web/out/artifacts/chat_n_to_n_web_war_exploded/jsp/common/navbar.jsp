<%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 20/10/2021
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String url = request.getRequestURI();
    url = url.substring(0, 29);

    boolean isHomepage = request.getRequestURI().contains("homepage");

%>

<nav>

    <script>

        function createCookie(name, value, days) {
            var expires;

            if (days) {
                var date = new Date();
                date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
                expires = "; expires=" + date.toGMTString();
            } else {
                expires = "";
            }
            document.cookie = encodeURIComponent(name) + "=" + encodeURIComponent(value) + expires + "; path=/";
        }

        function readCookie(name) {
            var nameEQ = encodeURIComponent(name) + "=";
            var ca = document.cookie.split(';');
            for (var i = 0; i < ca.length; i++) {
                var c = ca[i];
                while (c.charAt(0) === ' ')
                    c = c.substring(1, c.length);
                if (c.indexOf(nameEQ) === 0)
                    return decodeURIComponent(c.substring(nameEQ.length, c.length));
            }
            return null;
        }

        function eraseCookie(name) {
            createCookie(name, "", -1);
        }


        function logout() {
            eraseCookie('JASE')
            window.location.href = '/chat_n_to_n_web_war_exploded/login.jsp';
        }

        function submitForm() {
            $('#formPesquisa').submit();
        }
    </script>
    <div class="nav-wrapper indigo lighten-1">
        <a href="<%= url %>/homepage.jsp" class="brand-logo" style="margin-left: 3%">Chat</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="<%= url %>/jsp/usuario/usuarios.jsp">Usuários</a></li>
            <li><a href="<%= url %>/jsp/chat/chats.jsp">Chat</a></li>
            <li><a href="" onclick="logout()">Logout</a></li>
            <li>
                <% if (isHomepage) { %>
                <form style="padding: 3%" id="formPesquisa" action="./process/usuario/buscar-usuario-nome.jsp" method="post">
                    <input type="text" name="usuarioNome" placeholder="Ex: Maria">
                </form>
                <% } %>

                <% if (!isHomepage) { %>
                <form style="padding: 3%" id="formPesquisa" action="../../process/usuario/buscar-usuario-nome.jsp" method="post">
                    <input type="text" name="usuarioNome" placeholder="Ex: Maria">
                </form>
                <% } %>

            </li>
            <li>
                <a class="waves-effect waves-light btn indigo darken-4" onclick="submitForm()">Pesquisar</a>
            </li>
        </ul>
    </div>
</nav>
