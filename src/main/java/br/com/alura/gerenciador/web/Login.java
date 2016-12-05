package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

public class Login implements IController{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		if(usuario == null) {
			return "/WEB-INF/pages/loginFail.jsp";
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			//session.setMaxInactiveInterval(xxx); determina o tempo que um sessão pode ficar inativa antes de ser destruida
			return "/WEB-INF/pages/loginSuccess.jsp";
		}
	}

}
