<%-- 
    Document   : buscarProduto
    Created on : 09/05/2017, 10:21:33
    Author     : Fernanda
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <!-- Custom Fonts -->
        <link href="${pageContext.request.contextPath}/bootstrap/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript">
            function habilita_a() {
                document.getElementById('p').disabled = false;                
            }
        </script>

    </head>

    <body>

        <div id="wrapper">

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
                    <a class="navbar-brand" href="index.jsp">Astec</a>
                </div>
                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">
                    <li class="dropdown">
                        <ul class="dropdown-menu message-dropdown">
                            <li class="message-preview">
                                <a href="#">
                                    <div class="media">
                                        <span class="pull-left">
                                            <img class="media-object" src="http://placehold.it/50x50" alt="">
                                        </span>
                                        <div class="media-body">
                                            <h5 class="media-heading"><strong>Log in</strong>
                                            </h5>
                                            <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                            <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="message-preview">
                                <a href="#">
                                    <div class="media">
                                        <span class="pull-left">
                                            <img class="media-object" src="http://placehold.it/50x50" alt="">
                                        </span>
                                        <div class="media-body">
                                            <h5 class="media-heading"><strong>Log in</strong>
                                            </h5>
                                            <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                            <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="message-preview">
                                <a href="#">
                                    <div class="media">
                                        <span class="pull-left">
                                            <img class="media-object" src="http://placehold.it/50x50" alt="">
                                        </span>
                                        <div class="media-body">
                                            <h5 class="media-heading"><strong>Log in</strong>
                                            </h5>
                                            <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                            <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="message-footer">
                                <a href="#">Read All New Messages</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${usuAutenticado.nome} <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="${pageContext.request.contextPath}/Autenticador"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li>
                            <a href="javascript:;" data-toggle="collapse" data-target="#emp"><i class="fa fa-fw fa-home"></i> Empresa <i class="fa fa-fw fa-caret-down"></i></a>
                            <ul id="emp" class="collapse">
                                <li>
                                    <a href="empresa.jsp">Cadastro</a>
                                </li>
                                <li>
                                    <a href="buscarEmpresa.jsp">Buscar</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:;" data-toggle="collapse" data-target="#prod"><i class="fa fa-fw fa-book"></i> Produto <i class="fa fa-fw fa-caret-down"></i></a>
                            <ul id="prod" class="collapse">
                                <li>
                                    <a href="${pageContext.request.contextPath}/bootstrap/produto.jsp">Cadastro</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/bootstrap/buscarProduto.jsp">Buscar</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="javascript:;" data-toggle="collapse" data-target="#usu"><i class="fa fa-fw fa-user"></i> Usuário <i class="fa fa-fw fa-caret-down"></i></a>
                            <ul id="usu" class="collapse">
                                <li>
                                    <a href="usuario.jsp">Cadastro</a>
                                </li>
                                <li>
                                    <a href="buscarUsuario.jsp">Buscar</a>
                                </li>
                            </ul>
                        </li>
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

                        <li>
                            <a href="relatorio.jsp"><i class="fa fa-fw fa-list-alt"></i> Relatório</a>
                        </li>
                        <li>
                            <a href="venda.jsp"><i class="fa fa-fw fa-shopping-cart"></i> Venda</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>


            <div class="col-lg-6">
                <form role="form" action="${pageContext.request.contextPath}/buscarProduto" method="get">
                    <div> 
                    <div>
                        <label>Pesquisa Produto</label>
                        <input  class="form-control" name="buscaProduto" var="testeProduto" type="text" placeholder="Digite o Nome do produto..."></br>                        
                    </div>
                    <div>
                        <label>Pesquisa Autor</label>
                        <input name="buscaAutor" class="form-control" var="testeBuscaAutor" type="text" placeholder="Digite o Nome do Autor..."/></br>                    
                    </div>                   
                        <button type="submit" class="btn btn-lg btn-default">Pesquisar</button>                                                    
                    </div>  
                </form>
                    <form role="form" action="${pageContext.request.contextPath}/buscarProduto" method="post">    
                    <div class="form-group">
                        <label>Filial</label>
                        <input  class="form-control" id="p" name="bFilial" value="${buscaProdutos.prodFilial}" disabled/>
                    </div>
                    <div class="form-group">
                        <label>Produto</label>
                        <input  class="form-control" id="p" name="bNome" value="${buscaProdutos.prodNome}" disabled/>
                    </div>
                    <div class="form-group">
                        <label>Autor</label>
                        <input class="form-control" id="p" name="bAutor" value="${buscaProdutos.prodAutor}" disabled/>
                    </div>                          
                    <div class="form-group">
                        <label>Genêro</label>
                        <select class="form-control" id="p" name="bGenero" value="${buscaProdutos.prodGenero}" disabled="">
                            <option>Selecione...</option>
                            <option value="Literatura">Literatura</option>
                            <option value="Romance">Romance</option>
                            <option value="Autoajuda">Autoajuda</option>
                            <option value="Infantojuvenil">Infantojuvenil</option>
                            <option value="Didático">Didático</option>
                            <option value="Artes">Artes</option>
                            <option value="Dicionários">Dicionários</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Quantidade</label>
                        <input class="form-control" id="p" name="bQtd" value="${buscaProdutos.prodQtd}" disabled/>
                    </div>
                    <div class="form-group">
                        <label>Valor de Compra</label>
                        <input class="form-control" id="p" name="bValCompra" value="${buscaProdutos.prodValCompra}" disabled/>
                    </div>
                    <div class="form-group">
                        <label>Valor de Venda</label>
                        <input class="form-control" id="p" name="bValVenda" value="${buscaProdutos.prodValVenda}" disabled/>
                    </div>
                    <div class="form-group">
                        <label>Descrição</label>
                        <textarea  class="form-control" id="p" name="bDesc" value="${buscaProdutos.prodDesc}"  rows="3" disabled></textarea>
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-lg btn-default">Salvar</button>
                        <button type="submit" class="btn btn-lg btn-default" onclick="javascript:habilita_a();">Editar</button>
                        <button type="button" class="btn btn-lg btn-default">Excluir</button>
                    </div>    

            </div>
            <!-- /.container-fluid -->

            <!-- jQuery -->
            <script src="${pageContext.request.contextPath}/bootstrap/js/jquery.js"></script>

            <!-- Bootstrap Core JavaScript -->
            <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
