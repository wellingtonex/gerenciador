package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/executar")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = -8329075524629672293L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String controller = req.getParameter("tarefa");
		if (controller == null) {
			throw new IllegalArgumentException(
					"Parametro tarefa é obrigatorio.");
		}
		controller = "br.com.alura.gerenciador.web." + controller;

		try {
			Class<?> tipo = Class.forName(controller);
			IControllerTarefa controllerInstance = (IControllerTarefa) tipo.newInstance();
			String pagina = controllerInstance.executa(req, res);
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, res);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			throw new ServletException(e);
		}
	}
}
