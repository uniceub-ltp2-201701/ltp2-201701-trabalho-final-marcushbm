package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Conexao;
import dao.ProcurarLoginDAO;
import model.Usuario;

@WebServlet("/usuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ServletUsuario() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("loginUsuario");
		String senha = request.getParameter("loginSenha");
		
		Connection conexao = Conexao.getConexao();
		
		ProcurarLoginDAO pld = new ProcurarLoginDAO(conexao);
		boolean logado = true;
		Usuario u = pld.getUsuario(nome, senha);
		
		if(u==null)
			logado = false;
		
		HttpSession session = request.getSession();
		session.setAttribute("admin", u);
		session.setMaxInactiveInterval(1 * 60 * 60);
		request.setAttribute("usuario", u);
		request.setAttribute("logado", logado);
		
		RequestDispatcher rd = request.getRequestDispatcher("/respostaUsuario.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
