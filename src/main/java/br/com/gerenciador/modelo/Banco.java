package br.com.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe que simula um DB e inicializa o cadastro de duas empresas pr?-definidas.
 **/
public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(chaveSequencial++);
		empresa1.setNome("Udemy");
		lista.add(empresa1);
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Alura");
		lista.add(empresa2);
		
		Usuario usuario1 = new Usuario();
		usuario1.setLogin("fernanda");
		usuario1.setSenha("1234");
		listaUsuarios.add(usuario1);
		
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("chiquinha");
		usuario2.setSenha("4321");
		listaUsuarios.add(usuario2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> iterator = lista.iterator();
		
		while (iterator.hasNext()) {
			Empresa empresa = iterator.next();
				if(empresa.getId() == id) {
					iterator.remove();
			}
		}
	}

	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.confere(login,  senha)) {
				return usuario;
			}
		}
		return null;
	}
}
