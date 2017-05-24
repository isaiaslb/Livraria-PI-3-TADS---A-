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
<html lang="PT">

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
                                        <h5 class="media-heading"><strong>Astec</strong>
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
                                        <h5 class="media-heading"><strong>Astec</strong>
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
                                        <h5 class="media-heading"><strong>Astec</strong>
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
                           Cadastrar cliente
                        </h1>
                    </div>
                </div>
                  <div class="col-lg-6">
                      <form role="form" action="${pageContext.request.contextPath}/clienteServlet" method="post">
                          <div class="form-group">
                              <label>Nome</label>
                              <input class="form-control" maxlength="150" name="nome" placeholder="Digite o nome..." required />
                          </div>
                          <div class="form-group">
                              <label>CPF</label>
                              <input type="text" OnKeyPress="formatar('###.###.###-##', this)" class="form-control" name="cpf" maxlength="14" id="cpf" placeholder="Digite o CPF..." required />
                              
                          </div>
                          <div class="form-group">
                              <label>Endereço</label>
                              <input class="form-control" name="endereco" maxlength="100" placeholder="Digite seu endereço..." />
                          </div>
                          <div class="form-group">
                              <label>Bairro</label>
                              <input class="form-control" name="bairro" maxlength="100" placeholder="Digite o bairro..." />
                          </div>
	                  <div class="form-group">
                              <label>CEP</label>
                              <input class="form-control" name="cep" maxlength="9" type="text" id="cep" placeholder="Digite o CEP..." required/>
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
                              <input type="tel" class="form-control" maxlength="11" name="cel" placeholder="Digite o Celular...">
                          </div>
                          <div class="form-group">
                              <label>Email</label>
                              <input class="form-control" type="email" maxlength="100" name="email" placeholder="Email..." required>
                          </div>
                          <button type="reset" class="btn btn-lg btn-default">Limpar</button>
                          <button type="submit" class="btn btn-lg btn-default">Cadastrar</button>
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

