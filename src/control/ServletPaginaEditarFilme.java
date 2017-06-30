package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.ConsultarFilmeDAO;
import model.Filme;

/**
 * Servlet implementation class ServletPaginaEditarFilme
 */
@WebServlet("/paginaEditarFilme")
public class ServletPaginaEditarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaginaEditarFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		String idfilme = request.getParameter("idfilme");
		
		ConsultarFilmeDAO cfd = new ConsultarFilmeDAO(conexao);
		
		Filme f = cfd.getFilme(idfilme);
	
		request.setAttribute("filme", f);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaEditarFilme.jsp");
		rd.forward(request, response);
		
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		String idfilme = request.getParameter("idfilme");
		
		ConsultarFilmeDAO cfd = new ConsultarFilmeDAO(conexao);
		
		Filme f = cfd.getFilme(idfilme);
		
		request.setAttribute("filme", f);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaEditarFilme.jsp");
		rd.forward(request, response);
		
	}

}
