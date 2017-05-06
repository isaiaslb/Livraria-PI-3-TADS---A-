<%-- 
    Document   : Usuario
    Created on : 30/04/2017, 13:09:50
    Author     : Fernanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario - Cadastrar Novo</title>
    </head>
    <body>        
        <h2>Cadastrar</h2>
        <form action="UsuarioServlet" method="post">

            <table>
                <tr>
                    <td>Nome:</td>
                    <td><input type="text" name="nome" class="form-control" placeholder="Digite o nome..."></td>                    
                </tr>
                <tr>
                    <td>Telefone:</td>
                    <td><input type="text" nome="fixo" class="form-control" placeholder="Digite o fixo..."></td>
                </tr>
                
                <tr>
                    <td>Email:</td>
                    <td><input  type="text" nome="email" placeholder="Digite o email..."></td>
                </tr>
              
                <tr>
                    <td><button type="submit" value="Cadastrar" class="btn btn-lg btn-default">Cadastrar</button></td>
                </tr>
            </table>
        </form>

    </body>
</html>
