package control;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdicionarAtorDAO;
import dao.Conexao;
import dao.ListarAtoresDAO;
import model.Ator;

@WebServlet("/adicionarAtor")
public class ServletAdicionarAtor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletAdicionarAtor() {
    	super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();

		AdicionarAtorDAO atd = new AdicionarAtorDAO(conexao);
		
		String nome = request.getParameter("nome");
		String biografia = request.getParameter("biografia");
		String nasc = request.getParameter("nascimento");
		String idfilme = request.getParameter("idfilme");

		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");

		java.sql.Date sqlDate = java.sql.Date.valueOf(nasc);		
			
		boolean resultado = atd.adicionarAtor(idfilme, nome, biografia, sqlDate);
		
		
		if(resultado){
			RequestDispatcher rd = request.getRequestDispatcher("/listarAtores");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "ERRO, ATOR NÃO ADICIONADO!");
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaAdicionarAtor.jsp");
			rd.forward(request, response);
		}
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			Connection conexao = Conexao.getConexao();

			AdicionarAtorDAO atd = new AdicionarAtorDAO(conexao);
			
			String nome = request.getParameter("nome");
			String biografia = request.getParameter("biografia");
			String nasc = request.getParameter("nascimento");
			String idfilme = request.getParameter("idfilme");

			SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");

			java.sql.Date sqlDate = java.sql.Date.valueOf(nasc);		
				
			boolean resultado = atd.adicionarAtor(idfilme, nome, biografia, sqlDate);
			
			
			if(resultado){
				RequestDispatcher rd = request.getRequestDispatcher("/listarAtores");
				rd.forward(request, response);
			}else{
				request.setAttribute("mensagem", "ERRO, ATOR NÃO ADICIONADO!");
				RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaAdicionarAtor.jsp");
				rd.forward(request, response);
			}
		
	}

}
