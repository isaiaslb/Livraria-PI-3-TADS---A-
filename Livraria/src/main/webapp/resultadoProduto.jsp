<%-- 
    Document   : resultadoProduto
    Created on : 19/05/2017, 16:38:46
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
       <h1>Novo produto adicionado</h1>
    <div>
      <%-- sessionScope permite obter os dados da sessão --%>
      
      
      <p><c:out value="${sessionScope.novoProduto.prodnome}" /></p>
      <p><c:out value="${sessionScope.novoProduto.prodgenero}" /></p>
      <p><c:out value="${sessionScope.novoProduto.prodautor}" /></p>
      <p><c:out value="${sessionScope.novoProduto.prodqtd}" /></p>
      <p><c:out value="${sessionScope.novoProduto.prodvalcompra}" /></p>
      <p><c:out value="${sessionScope.novoProduto.prodvalvenda}" /></p>
      <p><c:out value="${sessionScope.novoProduto.proddesc}" /></p>
      
  </body>
  
  <%-- Apaga o valor da sessão --%>
  <c:remove scope="session" var="novoProduto" />
</html>