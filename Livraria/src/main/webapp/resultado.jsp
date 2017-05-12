<%-- 
    Document   : resultado
    Created on : 30/04/2017, 13:53:59
    Author     : Fernanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Novo usuario adicionado</h1>
    <div>
      <%-- sessionScope permite obter os dados da sessão --%>
      <h2><c:out value="${sessionScope.novoUsuario.nome}" /></h2>
      <p><c:out value="${sessionScope.novoUsuario.email}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.fixo}" /></p>
  </body>
  
  <%-- Apaga o valor da sessão --%>
  <c:remove scope="session" var="novoUsuario" />
</html>
