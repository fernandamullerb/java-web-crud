package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		
		chain.doFilter(request, response); //executando a ação.
		
		long depois = System.currentTimeMillis();

        System.out.println("Tempo de execução da ação " + acao + " -> " + (depois - antes));
		
	}	
}
