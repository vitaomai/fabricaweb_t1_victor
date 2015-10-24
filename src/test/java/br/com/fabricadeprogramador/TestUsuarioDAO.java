package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

import java.util.List;
//import java.util.Scanner;


public class TestUsuarioDAO {

	public static void main(String[] args) {
		//testExcluir();
		//testeSalvar();
		//testBuscarPorId();
		//testBuscartodos();
		testAutenticar();
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
	
	public static void testeSalvar(){
		//Criar novo usuário
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("jhones");
		usuario.setSenha("senha");
		usuario.setUsername("Jhon");
		//Cadastrar usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usuario);
		
		System.out.println("Usuario salvo com sucesso");
		
	}
	
	private static void testBuscarPorId(){
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usuario = usuDAO.buscarPorID(2);
		System.out.println(usuario);
	}

	private static void testBuscartodos(){
		UsuarioDAO usuDAO = new UsuarioDAO();
		List<Usuario> lista = usuDAO.buscarPorTodos();
		
		for (Usuario u: lista){
			System.out.println(u);
		}
	}
	
	private static void testAutenticar(){
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usu = new Usuario();
		usu.setUsername("dada");
		usu.setSenha("111");
		Usuario usuRetorno = usuDAO.autenticar(usu);
		System.out.println(usuRetorno);
		
		
	}
}
