package br.com.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que simula um DB e inicializa o cadastro de duas empresas pré-definidas.
 **/
public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Itaú");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Alura");
		lista.add(empresa1);
		lista.add(empresa2);
	}
	
	
	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

}
