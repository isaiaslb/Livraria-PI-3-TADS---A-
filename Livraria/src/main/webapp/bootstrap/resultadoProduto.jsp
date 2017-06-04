<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
       <h1>Novo Produto Adicionado</h1>
    <div>
      <%-- sessionScope permite obter os dados da sessão --%>
      
      
      <h2><p><c:out value="${sessionScope.novoProduto.prodNome}" /></p></h2>
      <p><c:out value="${sessionScope.novoProduto.prodGenero}" /></p>
      <p><c:out value="${sessionScope.novoProduto.prodAutor}" /></p>
      <p><c:out value="${sessionScope.novoProduto.prodQtd}" /></p>
      <p><c:out value="${sessionScope.novoProduto.prodValCompra}" /></p>
      <p><c:out value="${sessionScope.novoProduto.prodValVenda}" /></p>
      <p><c:out value="${sessionScope.novoProduto.prodDesc}" /></p>
    </div>
  </body>
  
  <%-- Apaga o valor da sessão --%>
  <c:remove scope="session" var="novoProduto" />
  
  
</html>