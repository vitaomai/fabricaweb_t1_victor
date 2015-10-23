package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		
		
		testExcluir();
			
		

	}
	
	public static void testAlterar(){
		//alterando usuario
		Usuario usu = new Usuario();
		usu.setId(4);
		usu.setNome("manuel");
		usu.setUsername("mane");
		usu.setSenha("444");
		
		// Alterar usuario em banco
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);
			
		System.out.println("Alterado com sucesso");
	}	
	
	public static void testCadastrar(){
		//criando usuario
		Usuario usu = new Usuario();
		usu.setNome("dad");
		usu.setUsername("dada");
		usu.setSenha("111");
		
		// cadastrar usuario em banco
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
			
		System.out.println("Cadastrado com sucesso");
	}
	
	public static void testExcluir(){
		//criando usuario
		Usuario usu = new Usuario();
		usu.setId(4);
		
		// cadastrar usuario em banco
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
			
		System.out.println("excluido com sucesso");
	}

}
