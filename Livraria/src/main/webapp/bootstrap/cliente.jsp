<%-- 
    Document   : cliente
    Created on : 09/05/2017, 19:50:57
    Author     : douglas.gsilva2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
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
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
                <a class="navbar-brand" href="index.html">Astec</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu message-dropdown">
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>John Smith</strong>
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
                                        <h5 class="media-heading"><strong>John Smith</strong>
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
                                        <h5 class="media-heading"><strong>John Smith</strong>
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu alert-dropdown">
                        <li>
                            <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">View All</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#emp"><i class="fa fa-fw fa-home"></i> Empresas <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="emp" class="collapse">
                            <li>
                                <a href="empresa.html">Cadastro</a>
                            </li>
                            <li>
                                <a href="buscarEmpresa.html">Buscar</a>
                            </li>
                        </ul>
                    </li>
					<li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#prod"><i class="fa fa-fw fa-book"></i> Produtos <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="prod" class="collapse">
                            <li>
                                <a href="produto.html">Cadastro</a>
                            </li>
                            <li>
                                <a href="buscarProduto.html">Buscar</a>
                            </li>
                        </ul>
                    </li>
					<li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#usu"><i class="fa fa-fw fa-user"></i> Usuarios <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="usu" class="collapse">
                            <li>
                                <a href="usuario.html">Cadastro</a>
                            </li>
                            <li>
                                <a href="buscarUsuario.html">Buscar</a>
                            </li>
                        </ul>
                    </li>
	         <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#cli"><i class="fa fa-fw fa-users"></i> Cliente <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="cli" class="collapse">
                            <li>
                                <a href="cliente.html">Cadastro</a>
                            </li>
                            <li>
                                <a href="buscarCliente.html">Buscar</a>
                            </li>
                        </ul>
                    </li>
					
					<li>
                        <a href="relatorio.html"><i class="fa fa-fw fa-list-alt"></i> Relatorio</a>
                    </li>
                    <li>
                        <a href="venda.html"><i class="fa fa-fw fa-shopping-cart"></i> Venda</a>
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
                            Cliente
                        </h1>
                    </div>
                </div>
                <!-- /.row -->

       
                  <div class="col-lg-6">
                      <form role="form" action="${pageContext.request.contextPath}/teste" method="post">
                        <div class="page-header">
                            <h2>Cadastrar</h2>
                        </div>
                          <div class="form-group">
                              <label>Nome</label>
                              <input class="form-control" name="nome" placeholder="Digite o nome...">
                          </div>
                          <div class="form-group">
                              <label>CPF</label>
                              <input class="form-control" name="cpf" placeholder="Digite o CPF...">
                          </div>
                          <div class="form-group">
                              <label>Endereço</label>
                              <input class="form-control" name="endereco" placeholder="Digite seu endereço...">
                          </div>
                          <div class="form-group">
                              <label>Bairro</label>
                              <input class="form-control" name="bairro" placeholder="Digite o bairro...">
                          </div>
	                  <div class="form-group">
                              <label>CEP</label>
                              <input class="form-control" name="cep" placeholder="Digite o CEP...">
                          </div>
                          <div class="form-group">
                              <label>Estado</label>
                              <select class="form-control" name="estado">
                                  <option>Selecione...</option>
                                <option value="AC">Acre</option>
	                               <option value="AL">Alagoas</option>
	                                <option value="AP">Amapá</option>
	                                 <option value="AM">Amazonas</option>
	                                  <option value="BA">Bahia</option>
	                                   <option value="CE">Ceará</option>
	                                    <option value="DF">Distrito Federal</option>
	                                     <option value="ES">Espírito Santo</option>
	                                      <option value="GO">Goiás</option>
	                                       <option value="MA">Maranhão</option>
	                                        <option value="MT">Mato Grosso</option>
	                                         <option value="MS">Mato Grosso do Sul</option>
	                                          <option value="MG">Minas Gerais</option>
	                                           <option value="PA">Pará</option>
	                                            <option value="PB">Paraíba</option>
	                                             <option value="PR">Paraná</option>
	                                              <option value="PE">Pernambuco</option>
	                                               <option value="PI">Piauí</option>
	                                                <option value="RJ">Rio de Janeiro</option>
	                                                 <option value="RN">Rio Grande do Norte</option>
	                                                  <option value="RS">Rio Grande do Sul</option>
	                                                   <option value="RO">Rondônia</option>
	                                                    <option value="RR">Roraima</option>
	                                                     <option value="SC">Santa Catarina</option>
	                                                      <option value="SP">São Paulo</option>
	                                                       <option value="SE">Sergipe</option>
	                                                        <option value="TO">Tocantins</option>
                              </select>
                          </div>
                          <div class="form-group">
                              <label>Celular</label>
                              <input class="form-control" name="cel" placeholder="Digite o Celular...">
                          </div>
                          <div class="form-group">
                              <label>Email</label>
                              <input class="form-control" name="email" placeholder="Email...">
                          </div>
                          <button type="button" class="btn btn-lg btn-default">Novo</button>
                          <button type="submit" class="btn btn-lg btn-default">Cadastrar</button>
                      </form>      
                  </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    
    </body>
    
</html>

