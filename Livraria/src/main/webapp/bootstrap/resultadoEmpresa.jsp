<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nova Empresa Adicionada</h1>
        <div>
            <%-- sessionScope permite obter os dados da sessão --%>


           <h2><c:out value="${sessionScope.novaEmpresa.razao}" /></h2>
            <p><c:out value="${sessionScope.novaEmpresa.cnpj}" /></p>
            <p><c:out value="${sessionScope.novaEmpresa.ie}" /></p>
            <p><c:out value="${sessionScope.novaEmpresa.telefone}" /></p>
            <p><c:out value="${sessionScope.novaEmpresa.endereco}" /></p>
            <p><c:out value="${sessionScope.novaEmpresa.numero}" /></p>
            <p><c:out value="${sessionScope.novaEmpresa.complemento}" /></p>
            <p><c:out value="${sessionScope.novaEmpresa.cep}" /></p>
            <p><c:out value="${sessionScope.novaEmpresa.bairro}" /></p>
            <p><c:out value="${sessionScope.novaEmpresa.cidade}" /></p>
            <p><c:out value="${sessionScope.novaEmpresa.estado}" /></p>
        </div>
    </body>

    <%-- Apaga o valor da sessão --%>
    <c:remove scope="session" var="novaEmpresa" />


</html>