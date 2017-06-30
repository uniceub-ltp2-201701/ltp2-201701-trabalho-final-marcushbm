package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;


@WebServlet("/paginaPrincipal")
public class ServletPaginaPrincipal extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    public ServletPaginaPrincipal() {
        super();
       
    }

	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession s = (HttpSession) request.getSession(true);
		Usuario u = (Usuario)s.getAttribute("admin");
		
		if(!(u==null)){
			RequestDispatcher rd = request.getRequestDispatcher("/respostaUsuario.jsp");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaPrincipal.jsp");
			rd.forward(request, response);
		}
	}

}
