<%-- 
    Document   : buscarClienteUsuario
    Created on : 08/05/2017, 13:10:07
    Author     : Isaias
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

                document.getElementById('nome').disabled = false;
                document.getElementById('senha').disabled = false;
                document.getElementById('dtnasc').disabled = false;
                document.getElementById('sexo').disabled = false;
                document.getElementById('email').disabled = false;
                document.getElementById('fixo').disabled = false;
                document.getElementById('cel').disabled = false;
                document.getElementById('setor').disabled = false;
                document.getElementById('tp_acesso').disabled = false;
                document.getElementById('alt').disabled = false;
                document.getElementById('exc').disabled = false;

            }
        </script>

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
                                <input  OnKeyPress="formatar('###.###.###-##', this)" onkeyup="somenteNumeros(this);"maxlength="14" class="form-control" name="buscarCpf" var="testaBusca" placeholder="Digite o CPF para buscar..."required/></br>
                                <button type="submit" class="btn btn-lg btn-default">Pesquisa</button></br></br>
                            </div>
                        </form>
                        <form role="form" action="${pageContext.request.contextPath}/buscarUsuario" method="post">
                            <input type="hidden" name="cpfBusca" value="${listaUsuario.cpf}">
                            <div class="form-group">
                                <label>Nome</label>
                                <input onKeypress="return teste(event)" maxlength="150"  class="form-control" name="nomeBusca" id="nome" value="${listaUsuario.nome}" disabled="" required/>
                            </div>
                            <div class="form-group">
                                <label>Data de Nascimento</label>
                                <input OnKeyPress="formatar('##/##/####', this)" onkeyup="somenteNumeros(this);" maxlength="10" class="form-control" id="dtnasc" name="dataNascBusca" id="dataNasc" value="${listaUsuario.dataNasc}" type="date" disabled="" required/>
                            </div>
                            <div class="form-group">
                                <label>Sexo</label>
                                <select class="form-control" id="sexo" name="sexoBusca" id="sexo" value="${listaUsuario.sexo}" disabled="">
                                    <option>Selecione...</option>
                                    <option value="m" >Masculino</option>
                                    <option value="f">Feminino</option>     
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" maxlength="30" class="form-control" id="email" name="emailBusca" id="email" value="${listaUsuario.email}" disabled="">
                            </div>
                            <div class="form-group">
                                <label>Telefone</label>
                                <input OnKeyPress="formatar('##-#####-####', this)" onkeyup="somenteNumeros(this);" maxlength="13" class="form-control" id="fixo" name="telefoneBusca" id="telefone" value="${listaUsuario.telefone}" disabled="">
                            </div>
                            <div class="form-group">
                                <label>Celular</label>
                                <input OnKeyPress="formatar('##-#####-####', this)"onkeyup="somenteNumeros(this);" maxlength="13" class="form-control" id="cel" name="celularBusca" id="celular" value="${listaUsuario.celular}" disabled="">
                            </div>
                            <div class="form-group">
                                <label>Setor</label>
                                <input onKeypress="return teste(event)" maxlength="150"  class="form-control" id="setor" name="setorBusca" id="setor" value="${listaUsuario.setor}" disabled="">
                            </div>
                            <div class="form-group">
                                <label>Senha</label>
                                <input class="form-control"  maxlength="15" name="senhaBusca" id="senha" value="${listaUsuario.senha}" type="password" disabled="">
                            </div>
                            <div class="form-group">
                                <label>Tipo de acesso</label>
                                <select class="form-control" id="tp_acesso" name="tipoAcessoBusca" id="tipoAcesso" value="${listaUsuario.tipoAcesso}" disabled="">
                                    <option>Selecione...</option>
                                    <option value="adm">Administrador</option>
                                    <option value="comum">Comum</option>     
                                </select>
                            </div>
                            <button type="submit" id="alt" name="btAlterar" value="Alterar"  class="btn btn-lg btn-default" disabled >Salvar</button>                    
                            <button type="button" class="btn btn-lg btn-default" onclick="javascript:habilita_a();">Editar</button>
                            <button type="submit" id="exc" name="btExcluir" value="Excluir" class="btn btn-lg btn-default" disabled >Excluir</button>
                        </form>

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- /#page-wrapper -->

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
                function teste(e)
	{
		var expressao;

		expressao = /[a-zA-Z ]/;

		if(expressao.test(String.fromCharCode(e.keyCode)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
                
            </script>

 <script>
		function formatar(mascara, documento){
			var i = documento.value.length;
			var saida = mascara.substring(0,1);
			var texto = mascara.substring(i)
			
			if (texto.substring(0,1) != saida){
				documento.value += texto.substring(0,1);
			}
			
		}
                
                
            </script>  
            <!-- jQuery -->
            <script src="${pageContext.request.contextPath}/bootstrap/js/jquery.js"></script>

            <!-- Bootstrap Core JavaScript -->
            <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>

    </body>

</html>
