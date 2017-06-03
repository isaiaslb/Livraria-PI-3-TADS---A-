<%-- 
    Document   : empresa
    Created on : 09/05/2017, 10:28:51
    Author     : Antonio Carlos
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

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

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
                                Cadastro Empresa
                            </h1>
                        </div>
                    </div>
                    <!-- /.row -->

                    <!-- /.row -->
                    <div class="col-lg-6">
                        <form action="${pageContext.request.contextPath}/EmpresaServlet" method="post">
                            <div class="form-group">
                                <label>Razão Social</label>
                                <input onKeypress="return teste(event)" maxlength="50" name="RZ_SOCIAL" class="form-control" placeholder="Informe a Razão...">
                            </div>

                            <div class="form-group">
                                <label>CNPJ</label>

                                <input name="cnpj" onkeypress="formatar('##.###.###/####-##', this)" onKeyDown='return SomenteNumero(event)' class="form-control" maxlength="18" id="cnpj" placeholder="Informe o CNPJ...">

                            </div>

                            <div class="form-group">
                                <label>Insc. Estadual</label>
                                <input name="INS_ESTAD" OnKeyPress="formatar('###.###.###.###', this)" onKeyDown='return SomenteNumero(event)' maxlength="15" class="form-control" placeholder="Informe Inscrição Estadual...">
                            </div>
                            <div class="form-group">
                                <label>Telefone Fixo</label>
                                <input name="tel" class="form-control" OnKeyPress="formatar('##-#####-####', this)" onKeyDown='return SomenteNumero(event)' type="tel" maxlength="13" placeholder="Informe Telefone...">
                            </div>
                            <div class="form-group">
                                <label>Endereço</label>
                                <input name="endereco"  onKeypress="return teste(event)" maxlength="100" class="form-control" placeholder="Informe Endereço...">
                            </div>
                            <div class="form-group">
                                <label>Numero</label>
                                <input name="numero" maxlength="9" onKeyDown='return SomenteNumero(event)'  class="form-control" placeholder="Informe Número...">
                            </div>
                            <div class="form-group">
                                <label>Complemento</label>
                                <input name="complemento" maxlength="50" class="form-control" placeholder="Informe Complemento...">
                            </div>
                            <div class="form-group">
                                <label>CEP</label>
                                <input name="cep" OnKeyPress="formatar('#####-###', this)"onKeyDown='return SomenteNumero(event)' class="form-control" name="cep" maxlength="9" type="text" id="cep"placeholder="Informe CEP...">
                            </div>
                            <div class="form-group">
                                <label>Bairro</label>
                                <input name="bairro" onKeypress="return teste(event)" class="form-control" placeholder="Informe Bairro...">
                            </div>
                            <div class="form-group">
                                <label>Cidade</label>
                                <input name="cidade" onKeypress="return teste(event)" class="form-control" placeholder="Informe Cidade...">
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

                            <button type="submit" class="btn btn-lg btn-default">Salvar</button>


                            <!---row row-->

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- /#page-wrapper -->

            </div>
            <!-- /#wrapper -->

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

            <script>
                function SomenteNumero(e) {
                    var tecla = (window.event) ? event.keyCode : e.which;
                    if ((tecla > 47 && tecla < 58))
                        return true;
                    else {
                        if (tecla == 8 || tecla == 0)
                            return true;
                        else
                            return false;
                    }
                }

            </script>

            <script>
                function teste(e)
                {
                    var expressao;

                    expressao = /[a-zA-Z]/;

                    if (expressao.test(String.fromCharCode(e.keyCode)))
                    {
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            </script>

            <script src="${pageContext.request.contextPath}/bootstrap/js/jquery.js"></script>

            <!-- Bootstrap Core JavaScript -->
            <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    </body>

</html>
