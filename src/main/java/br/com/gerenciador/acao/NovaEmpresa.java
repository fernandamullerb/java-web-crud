package br.com.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeEmpresa = request.getParameter("nome"); //pegando o parâmetro e atribuindo a uma String.
		String dataEmpresa = request.getParameter("data"); //pegando o parâmetro e atribuindo a uma String.
		
		Date dataAbertura = null; //inicializando a variável para poder utilizar abaixo do try-catch.
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //formatando a data.
			dataAbertura = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e); //bloqueando a continuidade caso a data não seja informada.
		}
		
		Empresa empresa = new Empresa(); //criando o objeto empresa.
		empresa.setNome(nomeEmpresa); //passando o parâmetro para o objeto empresa.
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa); //adicionando a empresa criada do banco.
		
		request.setAttribute("empresa", empresa.getNome()); 
		return "redirect:entrada?acao=ListaEmpresas"; //redirecionamento client side.
		
	}	
}
