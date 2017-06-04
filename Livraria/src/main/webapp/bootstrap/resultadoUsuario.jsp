<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
       <h1>Novo Usuario Adicionado</h1>
    <div>
      <%-- sessionScope permite obter os dados da sessão --%>
      
      <h2><p><c:out value="${sessionScope.novoUsuario.nome}" /></p></h2>
      <p><c:out value="${sessionScope.novoUsuario.cpf}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.dataNasc}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.sexo}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.email}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.telefone}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.celular}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.setor}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.senha}" /></p>
      <p><c:out value="${sessionScope.novoUsuario.tipoAcesso}" /></p>
      </div>
  </body>
  
  <%-- Apaga o valor da sessão --%>
  <c:remove scope="session" var="novoCliente" />
  
  
</html>