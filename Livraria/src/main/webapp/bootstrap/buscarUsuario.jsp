<%-- 
    Document   : buscarClienteUsuario
    Created on : 08/05/2017, 13:10:07
    Author     : Isaias
--%>

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
<!--
        <script type="text/javascript">
            function habilita_a() {
                document.getElementById('nome').disabled = false;
                document.getElementById('end').disabled = false;
                document.getElementById('bairro').disabled = false;
                document.getElementById('cep').disabled = false;
                document.getElementById('est').disabled = false;
                document.getElementById('cel').disabled = false;
                document.getElementById('email').disabled = false;
            }
        </script>
-->
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
                                    <a href="produto.jsp">Cadastro</a>
                                </li>
                                <li>
                                    <a href="buscarProduto.jsp">Buscar</a>
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

            <div id="page-wrapper">

                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Buscar Usuario
                            </h1>
                        </div>
                    </div>
                    <!-- /.row -->


                    <div class="col-lg-6">
                        <form role="form" action="${pageContext.request.contextPath}/buscarUsuario" method="get">
                            <div>
                                <label>Pesquisa CPF</label>
                                <input class="form-control" name="buscarCpf" var="testaBusca" placeholder="Digite o CPF para buscar..."></br>
                                <button type="submit" class="btn btn-lg btn-default">Pesquisa</button></br></br>
                            </div>
                        </form>
                        <form role="form" action="${pageContext.request.contextPath}/buscarCliente" method="post">
                            <div class="form-group">
                                <label>Nome</label>
                                <input class="form-control" name="nomeBusca" value="${listaUsuario.nome}" disabled="">
                            </div>
                            <div class="form-group">
                                <label>CPF</label>
                                <input class="form-control" name="cpfBusca" value="${listaUsuario.cpf}" disabled="">
                            </div>
                            <div class="form-group">
                                <label>Data de Nascimento</label>
                                <input class="form-control" name="dataNascBusca" id="dataNasc" value="${listaUsuario.dataNasc}" type="date" disabled="">
                            </div>
                            <div class="form-group">
                                <label>Sexo</label>
                                <select class="form-control" name="sexoBusca" id="sexo" value="${listaUsuario.sexo}" disabled="">
                                    <option>Selecione...</option>
                                    <option value="m" >Masculino</option>
                                    <option value="f">Feminino</option>     
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Email</label>
                                <input class="form-control" name="emailBusca" id="email" value="${listaUsuario.email}" disabled="">
                            </div>
                            <div class="form-group">
                                <label>Telefone</label>
                                <input class="form-control" name="telefoneBusca" id="telefone" value="${listaUsuario.telefone}" disabled="">
                            </div>
                            <div class="form-group">
                                <label>Celular</label>
                                <input class="form-control" name="celularBusca" id="celular" value="${listaUsuario.celular}" disabled="">
                            </div>
                            <div class="form-group">
                                <label>Setor</label>
                                <input class="form-control" name="setorBusca" id="setor" value="${listaUsuario.setor}" disabled="">
                            </div>
                            <div class="form-group">
                                <label>Senha</label>
                                <input class="form-control" name="senhaBusca" id="senha" value="${listaUsuario.senha}" type="password" disabled="">
                            </div>
                            <div class="form-group">
                                <label>Tipo de acesso</label>
                                <select class="form-control" name="tipoAcessoBusca" id="tipoAcesso" value="${listaUsuario.tipoAcesso}" disabled="">
                                    <option>Selecione...</option>
                                    <option value="adm">Administrador</option>
                                    <option value="comum">Comum</option>     
                                </select>
                            </div>
                        </form>
                       
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

    </body>

</html>
