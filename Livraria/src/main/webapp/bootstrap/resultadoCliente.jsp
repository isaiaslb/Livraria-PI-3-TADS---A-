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
    <div>
      <%-- sessionScope permite obter os dados da sessão --%>
      
      
      <h2><p><c:out value="${sessionScope.novoCliente.nome}" /></p></h2>
      <p><c:out value="${sessionScope.novoCliente.cpf}" /></p>
      <p><c:out value="${sessionScope.novoCliente.end}" /></p>
      <p><c:out value="${sessionScope.novoCliente.bairro}" /></p>
      <p><c:out value="${sessionScope.novoCliente.cep}" /></p>
      <p><c:out value="${sessionScope.novoCliente.estado}" /></p>
      <p><c:out value="${sessionScope.novoCliente.cel}" /></p>
      <p><c:out value="${sessionScope.novoCliente.email}" /></p>
 
</div>
       </body>
  <%-- Apaga o valor da sessão --%>
  <c:remove scope="session" var="novoCliente" />
  
  
</html>