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
import dao.ConsultarDiretorDAO;
import model.Diretor;

@WebServlet("/paginaEditarDiretor")
public class ServletPaginaEditarDiretor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletPaginaEditarDiretor() {
        super();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		String iddiretor = request.getParameter("iddiretor");
		
		ConsultarDiretorDAO cdd = new ConsultarDiretorDAO(conexao);
		
		Diretor d = cdd.getDiretor(iddiretor);
		request.setAttribute("diretor", d);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaEditarDiretor.jsp");
		rd.forward(request, response);
		
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Connection conexao = Conexao.getConexao();
	
	String iddiretor = request.getParameter("iddiretor");
	
	ConsultarDiretorDAO cdd = new ConsultarDiretorDAO(conexao);
	
	Diretor d = cdd.getDiretor(iddiretor);
	request.setAttribute("diretor", d);
	
	RequestDispatcher rd = request.getRequestDispatcher("/respostaEditarDiretor.jsp");
	rd.forward(request, response);
	
}


}
