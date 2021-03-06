<%-- 
    Document   : venda
    Created on : 09/05/2017, 10:32:00
    Author     : Fernanda
--%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Vector"%>
<%@page import="br.senac.tads.livraria.pi3a.model.Produtos"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Livraria Astec</title>

        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="${pageContext.request.contextPath}/bootstrap/css/sb-admin.css" rel="stylesheet">

        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.1/jquery.min.js"></script>

        <!-- Custom Fonts -->
        <link href="${pageContext.request.contextPath}/bootstrap/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style>

            table{
                width: 100%;
                border-collapse:collapse;
            }
            table tr {
                border-bottom: solid white 8px; /*Distancia entre tr*/
            }
            table tr td {
                background-color:White;  /*Cor para criar ilusão de borda*/
            }
            table tr td:not(:last-child) {
                padding: 1px 0 1px 1px; /*Retirar padding a direita da td, exceto da última para não criar colapso de bordas*/
            }
            table tr td span {
                display:block;
                background-color:white;
                padding:5px 5px 0 5px;
            }
            table tr:nth-child(even) td span {
                background-color:White; /*Se desejar alternar cores das linhas*/
            }

        </style>
    </head>

    <body>

        <div id="wrapper">

            <c:choose>
                <c:when test="${papel eq 'Admin'}"></c:when>
                <c:when test="${papel eq 'Com'}"></c:when>	
            </c:choose>

            <!-- Navigation -->  
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/bootstrap/index.jsp">Astec</a>
                </div>
                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">
                    <li class="dropdown">
                        <c:if test="${not empty sessionScope.usuAutenticado}">

                        <li class="dropdown">
                            <a href="#"><i class="fa fa-gear"></i> ${sessionScope.usuAutenticado.tipoAcesso}</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${usuAutenticado.nome} <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="${pageContext.request.contextPath}/Autenticador"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                                </li>
                            </c:if>
                        </ul>
                    </li>
                </ul>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <c:if test="${not empty sessionScope.usuAutenticado && sessionScope.usuAutenticado.temPapel('Admin') && sessionScope.usuAutenticado.temEmpresa('matriz')}">
                            <li>
                                <a href="javascript:;" data-toggle="collapse" data-target="#emp"><i class="fa fa-fw fa-home"></i> Empresa <i class="fa fa-fw fa-caret-down"></i></a>
                                <ul id="emp" class="collapse">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/bootstrap/empresa.jsp">Cadastro</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/bootstrap/buscarEmpresa.jsp">Buscar</a>
                                    </li>
                                </ul>
                            </li>
                        </c:if>
                        <li>
                            <a href="javascript:;" data-toggle="collapse" data-target="#prod"><i class="fa fa-fw fa-book"></i> Produto <i class="fa fa-fw fa-caret-down"></i></a>
                            <ul id="prod" class="collapse">
                                <c:if test="${not empty sessionScope.usuAutenticado  && sessionScope.usuAutenticado.temEmpresa('matriz')}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/bootstrap/produto.jsp">Cadastro</a>
                                    </li>
                                </c:if>
                                <li>
                                    <a href="${pageContext.request.contextPath}/bootstrap/buscarProduto.jsp">Buscar</a>
                                </li>
                            </ul>
                        </li>
                        <c:if test="${not empty sessionScope.usuAutenticado && sessionScope.usuAutenticado.temPapel('Admin')}">
                            <li>
                                <a href="javascript:;" data-toggle="collapse" data-target="#usu"><i class="fa fa-fw fa-user"></i> Usuario <i class="fa fa-fw fa-caret-down"></i></a>
                                <ul id="usu" class="collapse">

                                    <li>
                                        <a href="${pageContext.request.contextPath}/bootstrap/usuario.jsp">Cadastro</a>
                                    </li>

                                    <li>
                                        <a href="${pageContext.request.contextPath}/bootstrap/buscarUsuario.jsp">Buscar</a>
                                    </li>
                                </ul>
                            </li>
                        </c:if>
                        <li>
                            <a href="javascript:;" data-toggle="collapse" data-target="#cli"><i class="fa fa-fw fa-users"></i> Cliente <i class="fa fa-fw fa-caret-down"></i></a>
                            <ul id="cli" class="collapse">
                                <li>
                                    <a href="${pageContext.request.contextPath}/bootstrap/cliente.jsp">Cadastro</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/bootstrap/buscarCliente.jsp">Buscar</a>
                                </li>
                            </ul>
                        </li>
                        <c:if test="${not empty sessionScope.usuAutenticado && sessionScope.usuAutenticado.temPapel('Admin') && sessionScope.usuAutenticado.temEmpresa('matriz')}">
                            <li>
                                <a href="${pageContext.request.contextPath}/bootstrap/relatorio.jsp"><i class="fa fa-fw fa-list-alt"></i> Relatório</a>
                            </li>
                        </c:if>
                        <li>
                            <a href="${pageContext.request.contextPath}/bootstrap/venda.jsp"><i class="fa fa-fw fa-shopping-cart"></i> Venda</a>
                        </li>


                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>


            <div id="page-wrapper">


                <div class="container-fluid">



                </div>

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Venda
                            <img src="imagens/venda_carinho.png" width="50">
                        </h1>

                    </div>
                </div>
                <!-- /.row -->
                <div class="row">                    
                    <div class="col-lg-12">                         


                        <div class="col-lg-6">
                            <table ><tr>
                                    <td><label for="codigo" class="alinhar" >Codigo filial:</label></td>
                                    <td><input class="form-control" id="codigo" name="codigo" type="text" readonly/></td>
                                    </div>
                                </tr>

                                <tr>
                                <div class="col-lg-7">
                                    <form  action="${pageContext.request.contextPath}/vendaServlet" method="get">
                                        <input type="hidden" name="comando" value="buscaCli"  />
                                        <td><label>Cliente:</label></td>
                                        <td><input value="${sessionScope.listCliente.cpf}" onkeypress="formatar('###.###.###-##', this)" maxlength="14" onkeyup="somenteNumeros(this);"class="form-control" name="clibusca" placeholder="Digite o cpf.." type="text"/></td>
                                        <td><input type="image" src="imagens/Imagens-em-png-queroimagem.png" width="30"></td>           
                                        <td><label>${sessionScope.listCliente.nome}</label></td>


                                        </tr>
                                    </form>   
                                    <tr>
                                        <td><label for="vendedor" class="alinhar" >Vendedor:</label></td>
                                        <td><input class="form-control" value="${usuAutenticado.nome}" id="vendedor" name="vendedor" type="text" readonly/></td>
                                </div>
                                </tr>

                            </table>                                                     
                        </div>
                        <div class="col-lg-6">


                        </div>
                        <br>


                        <div class="row">
                            <div class="col-lg-12">        

                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>Id Prod.</th>
                                                <th>Nome</th>
                                                <th>Genero</th>
                                                <th>Autor</th>
                                                <th>Vl. Unitario</th>
                                                <th>Qtd</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <%
                                            Vector carrinho = (Vector) session.getAttribute("carrinho");
                                            if (carrinho == null) {
                                                carrinho = new Vector();
                                                session.setAttribute("carrinho", carrinho);
                                            }
                                            double total = 0;
                                            for (int cont = 0; cont < carrinho.size(); cont++) {
                                                Produtos p = (Produtos) carrinho.get(cont);
                                                total += p.getProdVal();

                                        %>    
                                        <tbody>
                                            <tr>
                                                <td><%=p.getProdId()%></td>;
                                                <td><%=p.getProdNome()%></td>
                                                <td><%=p.getProdGenero()%></td>
                                                <td><%=p.getProdAutor()%></td>
                                                <td><%=p.getProdVal()%></td>
                                                <td><input type="number" /></td>  
                                                <td style type="text-align: left">

                                                    <input type="button" onclick="window.open('${pageContext.request.contextPath}/excluir?id=<%= cont%>', '_self')" value="Remover" />

                                                </td>
                                            </tr>

                                        </tbody>
                                        <%
                                            }
                                        %>
                                    </table>
                                </div>
                                <div class="col-lg-6">
                                    <h2><label for="total" class="alinhar">Total</label></h2>
                                    <input id="total" value="<%out.println(NumberFormat.getCurrencyInstance().format(total));%>" class="form-control" name="total" type="text" readonly/>     
                                </div>


                            </div>
                            <div class="col-lg-6">

                                <button type="button" class="btn btn-lg btn-default">Salvar</button>                              
                                <button type="button" class="btn btn-lg btn-default">Sair</button>
                            </div>

                        </div>

                        <!-- /.container-fluid -->

                    </div>
                    <!-- /#page-wrapper -->

                </div>
            </div>

            <!-- Máscara para cobrir a tela -->
            <div id="mask"></div>

        </div>
    </div>

    <!-- /#wrapper -->
    <script>
        function somenteNumeros(num) {
            var er = /[^0-9./-]/;
            er.lastIndex = 0;
            var campo = num;
            if (er.test(campo.value)) {
                campo.value = "";
            }
        }
    </script>

    <script>
        function formatar(mascara, documento) {
            var i = documento.value.length;
            var saida = mascara.substring(0, 1);
            var texto = mascara.substring(i)

            if (texto.substring(0, 1) != saida) {
                documento.value += texto.substring(0, 1);
            }

        }


    </script>  

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>
