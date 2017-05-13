<%-- 
    Document   : resultadoCliente
    Created on : 12/05/2017, 21:13:09
    Author     : douglas.gsilva2
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
    <h1>Novo cliente adicionado</h1>
      <%-- sessionScope permite obter os dados da sessão --%>
      <h2><c:out value="${sessionScope.novoUsuario.nome}" /></h2>
      <p><c:out value="${sessionScope.novoUsuario.cpf}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.endereco}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.bairro}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.cep}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.estado}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.cel}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.email}" /></p>
      
  </body>
  
  <%-- Apaga o valor da sessão --%>
  <c:remove scope="session" var="novoCliente" />
</html>