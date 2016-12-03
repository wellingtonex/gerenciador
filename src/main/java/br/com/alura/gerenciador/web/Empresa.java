package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/empresa")
public class Empresa extends HttpServlet {

	private static final long serialVersionUID = -8329075524629672293L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String tarefa = req.getParameter("tarefa");
		if (tarefa == null) {
			throw new IllegalArgumentException(
					"Parametro tarefa é obrigatorio.");
		}
		tarefa = "br.com.alura.gerenciador.web." + tarefa;

		try {
			Class<?> tipo = Class.forName(tarefa);
			Tarefa tarefaInstance = (Tarefa) tipo.newInstance();
			String pagina = tarefaInstance.executa(req, res);
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, res);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			throw new ServletException(e);
		}
	}
}
