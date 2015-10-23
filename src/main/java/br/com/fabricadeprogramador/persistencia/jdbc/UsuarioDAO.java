package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
	
}
