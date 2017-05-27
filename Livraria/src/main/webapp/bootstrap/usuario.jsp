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

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/bootstrap/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    
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
                                <a href="cliente.jsp">Cadastro</a>
                            </li>
                            <li>
                                <a href="buscarCliente.jsp">Buscar</a>
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
                            Cadastrar usuário
                        </h1>
                    </div>
                </div>
                  <div class="col-lg-6">
                          <form action="${pageContext.request.contextPath}/UsuarioServlet" method="post">
                          <div class="form-group">
                              <label>Nome</label>
                              <input name="nome" id="nome" class="form-control" placeholder="Digite o nome..." value="${resusuario.nome}">
                          </div>
                          <div class="form-group">
                              <label>CPF</label>
                              <input name="cpf" id="cpf" class="form-control" placeholder="Digite o cpf..." value="${resusuario.nome}">
                          </div>
                             <div class="form-group">
                              <label>Data de Nascimento</label>
                              <input name="dataNasc" id="dataNasc" class="form-control" type="text">
                          </div>
                           <div class="form-group">
                              <label>Sexo</label>
                              <select name="sexo" id="sexo" class="form-control">
                                  <option>Selecione...</option>
                                <option name="m" id="m" value="m">Masculino</option>
	                        <option name="f" id="f" value="f">Feminino</option>     
                              </select>
                          </div>
                          
                             <div class="form-group">
                              <label>Email</label>
                              <input name="email" id="email" class="form-control" placeholder="Digite o email...">
                          </div>
                             <div class="form-group">
                              <label>Telefone</label>
                              <input name="telefone" id="telefone" class="form-control" placeholder="Digite o telefone...">
                          </div>
                             <div class="form-group">
                              <label>Celular</label>
                              <input name="celular" id="celular" class="form-control" placeholder="Digite o celular...">
                          </div>
                             <div class="form-group">
                              <label>Setor</label>
                              <input name="setor" id="setor" class="form-control" placeholder="Digite o setor...">
                          </div>
                             <div class="form-group">
                              <label>Senha</label>
                              <input name="senha" id="senha" class="form-control" type="password" placeholder="Digite a senha...">
                          </div>
                          <div class="form-group">
                              <label>Tipo de acesso</label>
                              <select name="tipoAcesso" id="tipoAcesso" class="form-control">
                                  <option>Selecione...</option>
                                <option name="tipoAdm" id="tipoAdm" value="adm">Administrador</option>
	                        <option name="tipoComum" id="tipoComum" value="comum">Comum</option>     
                              </select>
                          </div>
                          <button type="submit" class="btn btn-lg btn-default">Cadastrar</button>

                </div>
              </form>
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
