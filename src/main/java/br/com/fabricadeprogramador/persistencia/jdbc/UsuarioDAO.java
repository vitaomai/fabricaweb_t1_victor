package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;


public class UsuarioDAO {
	
	private Connection con = ConexaoFactory.getConnection();
	
	public void cadastrar(Usuario usu) {

		String sql = "Insert into usuario (nome, username, senha) values (?,?,?)";
		
		try{ 
			//criando um preparador
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome()); // substitui na query o valor 1
			preparador.setString(2, usu.getUsername());
			preparador.setString(3, usu.getSenha());
			//executando o comando SQL
			preparador.execute();
			//fechando o objeto preparador
			preparador.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public void alterar(Usuario usu) {

		String sql = "update usuario set nome=? , username=? , senha=? where id=?";
		
		try{ 
			//criando um preparador
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome()); // substitui na query o valor 1
			preparador.setString(2, usu.getUsername());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			//executando o comando SQL
			preparador.execute();
			//fechando o objeto preparador
			preparador.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Usuario usu) {

		String sql = "delete from usuario where id=?";
		
		try{ 
			//criando um preparador
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usu.getId());
	
			//executando o comando SQL
			preparador.execute();
			//fechando o objeto preparador
			preparador.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Usuario usuario){
		if(usuario.getId()!=null){
			alterar(usuario);
			System.out.println("usuarioDAO - salvar");
		}else{
			cadastrar(usuario);
		}
	}
	
	/**
	 * Busca de um registro no banco de dados por ID do Usuário.
	 * 
	 * @param id -> é um inteiro que representa o numero do ID do usuário a ser buscado.
	 * 
	 * @return -> retorna um objeto usuário, ou NULO quando nao encontra o registro
	 */
	public Usuario buscarPorID(Integer id){
		String sql = "Select * from usuario where id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setInt(1, id);
			
			ResultSet resultado = preparador.executeQuery();
			//Posicionando o Cursor no primeiro (proximo) registor 
						
			if(resultado.next()){
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setUsername(resultado.getString("username"));
				usuario.setSenha(resultado.getString("senha"));
				return usuario;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Realiza a busca de todos registros da tabela Usuarios. 
	 * @return -> uma lista de objeto usuários, com 0 elementos quando não encontrar registros ou 'n' elementos quando encontrar resultados.
	 */
	public List<Usuario> buscarPorTodos(){
		String sql = "Select * from usuario"; 
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
						
			ResultSet resultado = preparador.executeQuery();
			//Posicionando o Cursor no primeiro (proximo) registor 
						
			while(resultado.next()){
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setUsername(resultado.getString("username"));
				usuario.setSenha(resultado.getString("senha"));
				//Adicionando o usuario na lista
				lista.add(usuario);
				
			}
		} catch (SQLException e){
			e.printStackTrace();
		}

		return lista;
		
	}
	
	/**
	 * 
	 * @param usuConsulta Recebe usuario 9consulta nome de usuario e senha)
	 * @return ->Retorno usuario
	 */
	public Usuario autenticar(Usuario usuConsulta){
		String sql = "Select * from usuario where username=? and senha=?";
		
		try(PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usuConsulta.getUsername()); //salva no primeiro ? do sql o que recebeu do useConsulta
			preparador.setString(2, usuConsulta.getSenha());//salva no segundo ? do sql o que recebeu do useConsulta
			ResultSet resultado = preparador.executeQuery();  // executa a query e salva o resultado no ResultSet
			
			if(resultado.next()){ //vai para o próximo registo do ResultSet se verdade - no caso para o registro 1.
				Usuario usu = new Usuario(); //cria um novo objeto usuário
				usu.setId(resultado.getInt("id"));  //
				usu.setNome(resultado.getString("nome"));
				usu.setUsername(resultado.getString( "username"));
				usu.setSenha(resultado.getString("senha"));
				return usu;
			}
			

		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return null;
	}
}
