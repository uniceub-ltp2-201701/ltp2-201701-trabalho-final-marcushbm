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
import dao.ExcluirAtorDAO;
import dao.ListarAtoresDAO;
import model.Ator;

@WebServlet("/excluirAtor")
public class ServletExcluirAtor extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public ServletExcluirAtor() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conexao = Conexao.getConexao();
		
		String idator = request.getParameter("idator");
		
		ExcluirAtorDAO ead = new ExcluirAtorDAO(conexao);
		
		boolean resultado = ead.excluirAtor(idator);
		
		ListarAtoresDAO dfd = new ListarAtoresDAO(conexao);
		
		ArrayList<Ator> a = dfd.getTodosAtores();
		
		if(resultado){
			request.setAttribute("atores", a);
			RequestDispatcher rd = request.getRequestDispatcher("/listarAtores");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "ERRO AO DELETAR ATOR!");
			request.setAttribute("atores", a);
			RequestDispatcher rd = request.getRequestDispatcher("/respostaEditarAtor.jsp");
			rd.forward(request, response);
		}
		
	}

}
