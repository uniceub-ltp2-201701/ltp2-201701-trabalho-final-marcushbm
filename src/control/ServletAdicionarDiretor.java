package control;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdicionarDiretorDAO;
import dao.Conexao;
import dao.ListarAtoresDAO;

@WebServlet("/adicionarDiretor")
public class ServletAdicionarDiretor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletAdicionarDiretor() {
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = Conexao.getConexao();

		AdicionarDiretorDAO atd = new AdicionarDiretorDAO(conexao);
		
		String nome = request.getParameter("nome");
		String biografia = request.getParameter("biografia");
		String nasc = request.getParameter("nascimento");
		String idfilme = request.getParameter("idfilme");

		java.sql.Date sqlDate = java.sql.Date.valueOf(nasc);		
			
		boolean resultado = atd.adicionarDiretor(idfilme, nome, biografia, sqlDate);
		
		
		if(resultado){
			RequestDispatcher rd = request.getRequestDispatcher("/listarDiretores");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "ERRO, DIRETOR NÃO INCLUIDO!");
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaAdicionarDiretor.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = Conexao.getConexao();

		AdicionarDiretorDAO atd = new AdicionarDiretorDAO(conexao);
		
		String nome = request.getParameter("nome");
		String biografia = request.getParameter("biografia");
		String nasc = request.getParameter("nascimento");
		String idfilme = request.getParameter("idfilme");

		java.sql.Date sqlDate = java.sql.Date.valueOf(nasc);		
			
		boolean resultado = atd.adicionarDiretor(idfilme, nome, biografia, sqlDate);
		
		
		if(resultado){
			RequestDispatcher rd = request.getRequestDispatcher("/listarDiretores");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "ERRO, DIRETOR NÃO INCLUIDO!");
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaAdicionarDiretor.jsp");
			rd.forward(request, response);
		}
	}

}
