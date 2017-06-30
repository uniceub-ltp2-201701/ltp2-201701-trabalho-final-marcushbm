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
import model.Ator;
import model.Diretor;
import model.Filme;

@WebServlet("/detalhaFilme")
public class ServletDetalhaFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletDetalhaFilme() {
 
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conexao = Conexao.getConexao();
		
		String idFilme = request.getParameter("idfilme");
		
		ConsultarFilmeDAO cfd = new ConsultarFilmeDAO(conexao);
		
		Filme f = cfd.getFilme(idFilme);	
		ArrayList<Ator> atores = cfd.getAtorPorFilme(idFilme);
		ArrayList<Diretor> diretores = cfd.getDiretorPorFilme(idFilme);
		
		request.setAttribute("filme", f);
		request.setAttribute("atores", atores);
		request.setAttribute("diretores", diretores);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalhaFilme.jsp");
		rd.forward(request, response);
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  		Connection conexao = Conexao.getConexao();
  		
  		String idFilme = request.getParameter("idfilme");
  		
  		ConsultarFilmeDAO cfd = new ConsultarFilmeDAO(conexao);
  		
  		Filme f = cfd.getFilme(idFilme);	
  		ArrayList<Ator> atores = cfd.getAtorPorFilme(idFilme);
  		ArrayList<Diretor> diretores = cfd.getDiretorPorFilme(idFilme);
  		
  		request.setAttribute("filme", f);
  		request.setAttribute("atores", atores);
  		request.setAttribute("diretores", diretores);
  		
  		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalhaFilme.jsp");
  		rd.forward(request, response);
  	}

}
