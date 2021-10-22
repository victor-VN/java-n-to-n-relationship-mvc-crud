<%--
  Created by IntelliJ IDEA.
  User: victor.oliveira
  Date: 08/10/2021
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <jsp:include page="jsp/common/head.jsp" />
  <body>

  <%
    Cookie[] cookies = request.getCookies();
    String cookieValue = "";
    for (Cookie cookie : cookies){
      if (cookie.getName().equalsIgnoreCase("JASE")){
        cookieValue = cookie.getValue();
      }
    }

    if (cookieValue.equalsIgnoreCase("ok")){
      response.sendRedirect("./homepage.jsp");
    } else {
      response.sendRedirect("./login.jsp");
    }

  %>

  </body>
</html>
