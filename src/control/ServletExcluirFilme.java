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
import dao.ExcluirFilmeDAO;
import dao.ListarFilmesDAO;
import model.Filme;

@WebServlet("/excluirFilme")
public class ServletExcluirFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletExcluirFilme() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conexao = Conexao.getConexao();
		
		String idfilme = request.getParameter("idfilme");
		
		ExcluirFilmeDAO efd = new ExcluirFilmeDAO(conexao);
		
		boolean resultado = efd.excluirFilme(idfilme);
		
		ListarFilmesDAO dfd = new ListarFilmesDAO(conexao);
		
		ArrayList<Filme> f = dfd.getFilmes();
		
		if(resultado){
			request.setAttribute("filmes", f);
			RequestDispatcher rd = request.getRequestDispatcher("/listarFilmes");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "ERRO AO DELETAR FILME!");
			request.setAttribute("filme", f);
			RequestDispatcher rd = request.getRequestDispatcher("/respostaEditarFilme.jsp");
			rd.forward(request, response);
		}
		
	}


}
