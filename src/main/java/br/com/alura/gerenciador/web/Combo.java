package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class Combo implements IController {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		Long idEmpesa = Long.valueOf(req.getParameter("empresa"));

		EmpresaDAO empresaDAO = new EmpresaDAO();

		Empresa empresa = empresaDAO.find(idEmpesa);
		req.setAttribute("empresaSelecionada", empresa);
		req.setAttribute("empresas", empresaDAO.buscaPorSimilaridade(null));
		return "/WEB-INF/pages/empresaSelecionada.jsp";
	}

}
