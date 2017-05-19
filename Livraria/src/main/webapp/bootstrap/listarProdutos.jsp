<%-- 
    Document   : listarProdutos
    Created on : 19/05/2017, 18:02:10
    Author     : Fernanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Produtos</title>
        <link rel="stylesheet" href="estilos.css" />
    </head>
    <body >
        <form  id="lista-produtos" action="buscar-produto" method="post">
            <input type="hidden" name="0" value="0" style="display:hidden" />
        </form>  
        <script type="text/javascript">
            function submitForm()
            {
                document.forms['lista-produtos'].submit();
            }
            window.onload = submitForm;
        </script>
    </body>
</html>