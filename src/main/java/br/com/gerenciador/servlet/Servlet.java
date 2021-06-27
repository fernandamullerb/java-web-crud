package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.acao.Acao;
import br.com.gerenciador.acao.AlteraEmpresa;
import br.com.gerenciador.acao.ListaEmpresas;
import br.com.gerenciador.acao.MostraEmpresa;
import br.com.gerenciador.acao.NovaEmpresa;
import br.com.gerenciador.acao.NovaEmpresaForm;
import br.com.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

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
