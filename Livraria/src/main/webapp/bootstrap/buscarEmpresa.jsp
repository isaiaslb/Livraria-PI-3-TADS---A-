<%-- 
    Document   : buscarEmpresa
    Created on : 09/05/2017, 10:26:07
    Author     : Antonio
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

        <script type="text/javascript">
            function habilita_a() {
                document.getElementById('rz_social').disabled = false;
                document.getElementById('ins_estad').disabled = false;
                document.getElementById('tel').disabled = false;
                document.getElementById('endereco').disabled = false;
                document.getElementById('numero').disabled = false;
                document.getElementById('complemento').disabled = false;
                document.getElementById('cep').disabled = false;
                document.getElementById('bairro').disabled = false;
                document.getElementById('cidade').disabled = false;
                document.getElementById('estado').disabled = false;
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
                                   <a href="${pageContext.request.contextPath}/bootstrap/empresa.jsp">Cadastro</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/bootstrap/buscarEmpresa.jsp">Buscar</a>
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
                                Buscar Empresa
                            </h1>
                        </div>
                    </div>
                    <!-- /.row -->


                    <div class="col-lg-6">
                        <form role="form" action="${pageContext.request.contextPath}/buscarEmpresa" method="get">
                            <div>
                                <label>Pesquisa CNPJ</label>
                                <input class="form-control" name="buscarCnpj" var="testaBusca" placeholder="Digite o CNPJ para buscar..."></br>
                                <button type="submit" class="btn btn-lg btn-default">Pesquisa</button></br></br>
                            </div>
                        </form>
                        <form role="form" action="${pageContext.request.contextPath}/buscarEmpresa" method="post">
                            <div class="form-group">
                              <label>Razão Social</label>
                              <input  class="form-control" name="razaoBusca" id="rz_social" value="${listaEmpresa.razao}" disabled />
                          </div>
                            
                            <div class="form-group">
                                <label>CNPJ</label>

                                <input  class="form-control"name="cnpjBusca"  id="cnpj" value="${listaEmpresa.cnpj}" disabled />

                            </div>
                            
                          
                                                                                    
                            <div class="form-group">
                              <label>Insc. Estadual</label>
                              <input  class="form-control" name="ieBusca" id="ins_estad" value="${listaEmpresa.ie}"disabled="">
                          </div>
                            <div class="form-group">
                              <label>Telefone Fixo</label>
                              <input class="form-control" name="telefoneBusca" id="tel" value="${listaEmpresa.telefone}"disabled="">
                          </div>
                            <div class="form-group">
                              <label>Endereço</label>
                              <input  class="form-control" name="enderecoBusca" id="endereco" value="${listaEmpresa.endereco}"disabled="">
                          </div>
                            <div class="form-group">
                              <label>Numero</label>
                              <input class="form-control" name="numeroBusca" id="numero" value="${listaEmpresa.numero}" disabled="">
                          </div>
                            <div class="form-group">
                              <label>Complemento</label>
                              <input class="form-control" name="complementoBusca" id="complemento" value="${listaEmpresa.complemento}" disabled="">
                          </div>
                            <div class="form-group">
                              <label>CEP</label>
                              <input class="form-control" name="cepBusca" id="cep" value="${listaEmpresa.cep}" disabled="">
                          </div>
                            <div class="form-group">
                              <label>Bairro</label>
                              <input class="form-control" name="bairroBusca" id="bairro" value="${listaEmpresa.bairro}" disabled="">
                          </div>
                            <div class="form-group">
                              <label>Cidade</label>
                              <input class="form-control" name="cidadeBusca" id="cidade" value="${listaEmpresa.cidade}" disabled="">
                          </div>
                             <div class="form-group">
                              <label>Estado</label>
                              <select class="form-control" name="estadoBusca" id="estado"  value="${listaEmpresa.estado}" disabled="">
                                  <option>Selecione...</option>
                                <option>Acre</option>
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
                            <button type="submit" class="btn btn-lg btn-default">Salvar</button>                    
                            <button type="button" class="btn btn-lg btn-default" onclick="javascript:habilita_a();">Editar</button>
                            <button type="submit" class="btn btn-lg btn-default">Excluir</button>
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
