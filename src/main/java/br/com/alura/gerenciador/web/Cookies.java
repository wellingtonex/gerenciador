package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {

	final private Cookie[] cookies;

	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}

	public Cookie buscaUsuarioLogado() {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")) {
				return cookie;
			}
		}
		return null;
	}

}
