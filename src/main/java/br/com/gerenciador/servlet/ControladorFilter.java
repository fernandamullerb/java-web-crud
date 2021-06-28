package br.com.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.acao.Acao;

@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String parametroAcao = request.getParameter("acao");
		
		String nomeDaClasse = "br.com.gerenciador.acao." + parametroAcao;

		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse); // carregando a classe.
			Acao acao = (Acao) classe.newInstance(); // instanciando o objeto da classe genérica.
			nome = acao.executa(request, response); // fazendo o cast da interface para conseguir chamar o método executa().
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}

		String[] tipoEEndereco = nome.split(":");

		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]); // chamando o jsp.
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);	
		}
	}
}
