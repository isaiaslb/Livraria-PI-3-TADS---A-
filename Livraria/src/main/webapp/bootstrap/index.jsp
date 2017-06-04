<%-- 
    Document   : index
    Created on : 09/05/2017, 10:29:42
    Author     : Fernanda
--%>
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

        <!-- Morris Charts CSS -->
        <link href="${pageContext.request.contextPath}/bootstrap/css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="${pageContext.request.contextPath}/bootstrap/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
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
                    <a class="navbar-brand" href="login.jsp">Astec</a>
                </div>
                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">
                    <li class="dropdown">
                        <c:if test="${not empty sessionScope.usuAutenticado}">
                            <a href="#" ><i class="fa fa-home"></i> ${usuAutenticado.nome}</a>
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
                        <c:if test="${not empty sessionScope.usuAutenticado && sessionScope.usuAutenticado.temPapel('Admin')}">
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
                                <li>
                                    <a href="${pageContext.request.contextPath}/bootstrap/produto.jsp">Cadastro</a>
                                </li>
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
                        <c:if test="${not empty sessionScope.usuAutenticado && sessionScope.usuAutenticado.temPapel('Admin')}">
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

                    <!-- Page Heading -->
                    <div class="row">
                        <div align="center" class="col-lg-12">
                            <h1  class="page-header">
                              Olá ${usuAutenticado.nome}, Seja Bem vindo a Livraria Astec
                            </h1>


                        </div>
                        <!-- /.row -->


                        <!-- /.row -->

                        <div class="row">
                            <form action="${pageContext.request.contextPath}/Autenticador" method="post">
                                <div class="col-lg-3 col-md-6">

                                    <div class="panel panel-primary">
                                        <div class="panel-heading">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <i class="fa fa-comments fa-5x"></i>
                                                </div><a href="${pageContext.request.contextPath}/bootstrap/cliente.jsp">
                                                    <div class="col-xs-9 text-right">
                                                        <div class="huge"><img src="${pageContext.request.contextPath}/bootstrap/imagens/users_clients_group_16774.png" width="100" height="100"/></div>

                                                    </div>
                                            </div>
                                        </div>
                                        <a href="${pageContext.request.contextPath}/bootstrap/cliente.jsp">
                                            <div class="panel-footer">
                                                <span class="pull-left">Cadastrar Cliente</span>
                                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                <div class="clearfix"></div>
                                            </div>
                                        </a>
                                    </div>

                                </div>
                                            <c:if test="${not empty sessionScope.usuAutenticado && sessionScope.usuAutenticado.temPapel('Admin')}">
                                <div class="col-lg-3 col-md-6">
                                    <div class="panel panel-green">
                                        <div class="panel-heading">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <i class="fa fa-tasks fa-5x"></i>
                                                </div><a href="${pageContext.request.contextPath}/bootstrap/usuario.jsp">
                                                    <div class="col-xs-9 text-right">
                                                        <div class="huge"><img src="${pageContext.request.contextPath}/bootstrap/imagens/system-user-man-icon.png" width="100" height="100"/></div>

                                                    </div>
                                            </div>
                                        </div>
                                        <a href="${pageContext.request.contextPath}/bootstrap/usuario.jsp">
                                            <div class="panel-footer">
                                                <span class="pull-left">Usuario Cadastrar</span>
                                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                <div class="clearfix"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                            </c:if>
                                <div class="col-lg-3 col-md-6">
                                    <div class="panel panel-yellow">
                                        <div class="panel-heading">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <i class="fa fa-shopping-cart fa-5x"></i>
                                                </div>
                                                <div class="col-xs-9 text-right">
                                                    <div class="huge"></div><a href="${pageContext.request.contextPath}/bootstrap/venda.jsp"> 
                                                        <div > <img src="${pageContext.request.contextPath}/bootstrap/imagens/book-305126_960_720.png" width="100" height="100"/></div>

                                                </div>
                                            </div>
                                        </div>
                                        <a href="${pageContext.request.contextPath}/bootstrap/venda.jsp"> 
                                            <div class="panel-footer">
                                                <span class="pull-left">Realizar Venda</span>
                                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                <div class="clearfix"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                      <c:if test="${not empty sessionScope.usuAutenticado && sessionScope.usuAutenticado.temPapel('Admin')}">      
                                <div class="col-lg-3 col-md-6">
                                    <div class="panel panel-red">
                                        <div class="panel-heading">
                                            <div class="row">
                                                <div class="col-xs-3">
                                                    <i class="fa fa-support fa-5x"></i>
                                                </div>
                                                <div class="col-xs-9 text-right">
                                                    <a href="${pageContext.request.contextPath}/bootstrap/empresa.jsp">  
                                                        <div class="huge"><img src="${pageContext.request.contextPath}/bootstrap/imagens/condominio.png" width="100" height="100"/></div>

                                                </div>
                                            </div>
                                        </div>
                                        <a href="${pageContext.request.contextPath}/bootstrap/empresa.jsp">
                                            <div class="panel-footer">
                                                <span class="pull-left">Cadastrar filial </span>
                                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                                <div class="clearfix"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                                </c:if>
                            </form>
                        </div>
                        <!-- /.row -->

                        <div class="row">
                            <div class="col-lg-12">
                                <img src="${pageContext.request.contextPath}/bootstrap/imagens/livro.png" width="40%" height="20%"/>
                                <img src="${pageContext.request.contextPath}/bootstrap/imagens/book2.png" left="90%" width="40%" height="20%"/>
                            </div>
                        </div>
                        <!-- /.row -->

                        <div class="row">

                            <!-- /.row -->

                        </div>
                        <!-- /.container-fluid -->

                    </div>
                    <!-- /#page-wrapper -->

                </div>
                <!-- /#wrapper -->

                <!-- jQuery -->
                <script src="${pageContext.request.contextPath}/bootstrap/js/jquery.js"></script>

                <!-- Bootstrap Core JavaScript -->
                <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

                <!-- Morris Charts JavaScript -->
                <script src="${pageContext.request.contextPath}/bootstrap/js/plugins/morris/raphael.min.js"></script>
                <script src="${pageContext.request.contextPath}/bootstrap/js/plugins/morris/morris.min.js"></script>
                <script src="${pageContext.request.contextPath}/bootstrap/js/plugins/morris/morris-data.js"></script>

                </body>

                </html>
