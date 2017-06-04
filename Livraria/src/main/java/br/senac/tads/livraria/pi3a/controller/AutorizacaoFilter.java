package br.senac.tads.livraria.pi3a.controller;

import br.senac.tads.livraria.pi3a.model.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fernanda
 */

@WebFilter(filterName = "AutorizacaoFilter",urlPatterns = "/bootstrap/*")
public class AutorizacaoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //pegando url para navegar entre paginas
        String url = httpServletRequest.getRequestURI();
        HttpSession session = httpServletRequest.getSession();

        if (session.getAttribute("usuAutenticado") != null || url.lastIndexOf("login.jsp") > -1
                || url.lastIndexOf("Autenticador") > -1) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect(httpServletRequest.getContextPath() + "/login.jsp");
        }
    }
    private static boolean verificarAcesso(Usuario usuario, HttpServletRequest request, HttpServletResponse response) {
        String paginaAcessada = request.getRequestURI();
        String pagina
                = paginaAcessada.replace(request.getContextPath(), "");
                if(pagina.endsWith("") && usuario.temPapel("Admin")){
                    return true;
                }else if(pagina.endsWith("venda") && pagina.endsWith("produto") && pagina.endsWith("cliente")
                        && usuario.temPapel("Com")){
                    return true;
                }
        return false;
    }

    @Override
    public void destroy() {

    }

}