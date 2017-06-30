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
import dao.ConsultarDiretorDAO;
import model.Diretor;
import model.Filme;

/**
 * Servlet implementation class ServletDetalhaDiretor
 */
@WebServlet("/detalhaDiretor")
public class ServletDetalhaDiretor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalhaDiretor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Connection conexao = Conexao.getConexao();
		
		String idDiretor = request.getParameter("iddiretor");
		
		ConsultarDiretorDAO cdd = new ConsultarDiretorDAO(conexao);
		
		Diretor d = cdd.getDiretor(idDiretor);
		ArrayList<Filme> f = cdd.getFilmesPorDiretor(idDiretor);

		request.setAttribute("diretor", d);
		request.setAttribute("filmes", f);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalhaDiretor.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = Conexao.getConexao();
				
				String idDiretor = request.getParameter("iddiretor");
				
				ConsultarDiretorDAO cdd = new ConsultarDiretorDAO(conexao);
				
				Diretor d = cdd.getDiretor(idDiretor);
				ArrayList<Filme> f = cdd.getFilmesPorDiretor(idDiretor);

				request.setAttribute("diretor", d);
				request.setAttribute("filmes", f);
				
				RequestDispatcher rd = request.getRequestDispatcher("/respostaDetalhaDiretor.jsp");
				rd.forward(request, response);
			}

}
