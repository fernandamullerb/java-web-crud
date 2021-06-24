package br.com.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	//doPost s� aceita m�todo post, doGet s� get e service() aceita ambos.
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws IOException, ServletException {
		
		String nomeEmpresa = request.getParameter("nome"); //pegando o par�metro e atribuindo a uma String.
		String dataEmpresa = request.getParameter("data"); //pegando o par�metro e atribuindo a uma String.
		
		Date dataAbertura = null; //inicializando a vari�vel para poder utilizar abaixo do try-catch.
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //formatando a data.
			dataAbertura = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e); //bloqueando a continuidade caso a data n�o seja informada.
		}
		
		Empresa empresa = new Empresa(); //criando o objeto empresa.
		empresa.setNome(nomeEmpresa); //passando o par�metro para o objeto empresa.
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa); //adicionando a empresa criada do banco.
		
		request.setAttribute("empresa", empresa.getNome()); 
		response.sendRedirect("listaEmpresas"); //redirecionamento client side.
	}
}
