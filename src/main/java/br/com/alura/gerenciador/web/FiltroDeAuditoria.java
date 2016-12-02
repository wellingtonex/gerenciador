package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        
        String usuario = getUsuario(req);

        System.out.println("Usuario " + usuario + " acessando a URI " + req.getRequestURI());
        chain.doFilter(request, response);
    }

	private String getUsuario(HttpServletRequest req) {
        Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
        String usuario = "desconhecido";
		if(cookie != null) {
        	usuario  = cookie.getValue();
        }
		return usuario;
	}

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}