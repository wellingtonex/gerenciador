package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;

public class Logout implements IController{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if(usuario != null) {
			req.getSession().removeAttribute("usuarioLogado"); //apenas removo esse atribulto da sessão
			return "/WEB-INF/pages/logoutSuccesss.html";
			//resp.sendRedirect("WEB-INF/paginas/logoutSuccesss.html"); //solicitando que o cliente seja redirecionado
		} else {
			//resp.sendRedirect("WEB-INF/paginas/logoutError.html");
			return "/WEB-INF/pages/logoutError.html";
		}
	}

}
