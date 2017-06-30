package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.ConsultarFilmeDAO;
import model.Filme;

@WebServlet("/listarFilmes")
public class ServletListarFilmes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListarFilmes() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Connection conexao = Conexao.getConexao();
		
		ConsultarFilmeDAO cfd = new ConsultarFilmeDAO(conexao);
		
		ArrayList<Filme> filmes = cfd.getFilmes();
		request.setAttribute("filmes", filmes);
		RequestDispatcher rd = request.getRequestDispatcher("/respostaListarFilmes.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Connection conexao = Conexao.getConexao();
		
		ConsultarFilmeDAO cfd = new ConsultarFilmeDAO(conexao);
		
		ArrayList<Filme> filmes = cfd.getFilmes();
		request.setAttribute("filmes", filmes);
		RequestDispatcher rd = request.getRequestDispatcher("/respostaListarFilmes.jsp");
		rd.forward(request, response);
		
	}

}