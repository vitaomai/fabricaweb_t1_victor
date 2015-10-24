package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;




//http://localhost:8080/fabricaweb/usucontroller.do
@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	
	public UsuarioController(){
		System.out.println("Construtor... ");
	}
	
	@Override
	public void init() throws ServletException{
		System.out.println("Init... ");
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		System.out.println("Sucesso.... ");
		//super.doGet(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		String nome = req.getParameter("nome");
		String username = req.getParameter("username");
		String senha = req.getParameter("senha");

		Usuario usu = new Usuario();
		usu.setNome(nome);
		usu.setUsername(username);
		usu.setSenha(senha);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);
		resp.getWriter().print("<h1>Inserido usuário com sucesso</h1>");
		
		System.out.println("Post com sucesso");
			
		}
	
	@Override
	public void destroy(){

		System.out.println("Destroi... ");
		super.destroy();
		
	}
	
	
}
