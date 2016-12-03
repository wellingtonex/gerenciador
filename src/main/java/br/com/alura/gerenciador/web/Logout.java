package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet{

	private static final long serialVersionUID = 7763927224856106937L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario.logado");
        if(usuario != null) {
        	req.getSession().removeAttribute("usuario.logado"); //apenas removo esse atribulto da sessão
        	req.getRequestDispatcher("/WEB-INF/pages/logoutSuccesss.html").forward(req, resp); // redirecionando a partir do servidor
        	//resp.sendRedirect("WEB-INF/paginas/logoutSuccesss.html"); //solicitando que o cliente seja redirecionado
        } else {
        	//resp.sendRedirect("WEB-INF/paginas/logoutError.html");
        	req.getRequestDispatcher("/WEB-INF/pages/logoutError.html").forward(req, resp);
        }
	}

}
