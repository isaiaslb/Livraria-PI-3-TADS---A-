<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
        <title>Livraria Astec</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" type="text/css" />
        <script type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <section id="content">
                <H1>Livraria Astec</H1>
                <form action="Autenticador" method="post">
                    <div class="wrapper">
                        <i class="fa fa-user"></i>
                        <input type="text" placeholder="Login" name="nome" required/>
                    </div>
                    <div class="wrapper">
                        <i class="fa fa-lock"></i>
                        <input type="password" placeholder="Senha" name="senha" required/>
                    </div>
                    <div>
                        <input type="submit" value="Entrar"/>
                    </div>
                </form>
            </section>
        </div>

    </body>
</html>
