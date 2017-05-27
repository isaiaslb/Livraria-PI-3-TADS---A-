<%-- 
    Document   : resultadoUsuario
    Created on : 27/05/2017, 01:14:19
    Author     : Isaias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
      <p><c:out value="${sessionScope.novoUsuario.nome}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.cpf}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.dataNasc}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.sexo}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.email}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.telefone}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.celular}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.setor}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.senha}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.tipoAcesso}" /></p>
    </body>
</html>
