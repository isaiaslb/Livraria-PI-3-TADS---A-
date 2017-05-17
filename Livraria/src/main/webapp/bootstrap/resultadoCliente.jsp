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
    <c:forEach items="${ListaCliente}" var="contato">
      <%-- sessionScope permite obter os dados da sessão --%>
      <input value="${contato.nome}" />
      <p value="${contato.cpf}" />
      <p value="${contato.end}" />
      <p value="${contato.bairro}" />
      <p value="${contato.cep}" />
      <p value="${contato.estado}" />
      <p value="${contato.cel}" />
      <p value="${contato.email}" />
    </c:forEach>  
  </body>
  
  <%-- Apaga o valor da sessão --%>
  <c:remove scope="session" var="novoCliente" />
</html>