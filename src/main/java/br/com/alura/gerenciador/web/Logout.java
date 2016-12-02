package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet{

	private static final long serialVersionUID = 7763927224856106937L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String mensagem = "";
		Cookie cookie =  new Cookies(req.getCookies()).buscaUsuarioLogado();
        if(cookie != null) {
        	//destruindo um cookie
        	cookie.setMaxAge(0);
        	resp.addCookie(cookie);
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
