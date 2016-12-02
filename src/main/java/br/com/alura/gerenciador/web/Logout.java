package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

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
		String mensagem = "";
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario.logado");
        if(usuario != null) {
        	req.getSession().removeAttribute("usuario.logado"); //apenas removo esse atribulto da sessão
        	//req.getSession().invalidate(); limpa, invalida toda a sessao
        	mensagem = "Deslogado com sucesso.";
        } else {
        	mensagem = "Nenhum usuario logado.";
        }
        
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
		writer.println("<body>");
		writer.println(mensagem);		
		writer.println("</body>");
		writer.println("</html>");
	}

}
