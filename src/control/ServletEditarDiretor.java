package control;

import static java.lang.System.out;
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
import dao.EditarDiretorDAO;
import model.Diretor;

@WebServlet("/editarDiretor")
public class ServletEditarDiretor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletEditarDiretor() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conexao = Conexao.getConexao();

		EditarDiretorDAO edd = new EditarDiretorDAO(conexao);

		String iddiretor = request.getParameter("iddiretor");
	
		ConsultarDiretorDAO cdd = new ConsultarDiretorDAO(conexao);

		Diretor d = cdd.getDiretor(iddiretor);

		out.println(d.getNome_diretor());

		//MODIFICAR O NOME DO DIRETOR

		String nome = request.getParameter("nome");

		if(nome.equals("")){
			nome = d.getNome_diretor();
		}

		//MODIFICAR A BIOGRAFIA DO DIRETOR

		String biografia = request.getParameter("biografia");

		if(biografia.equals("")){
			biografia = d.getBiografia();
		}


		//MODIFICAR A DATA DE NASCIMENTO DO DIRETOR

		String datanasc = request.getParameter("datanasc");

		java.sql.Date sqlDate = null;

		if(datanasc.equals("")){
			sqlDate = d.getData_nasc();
		}else{
			sqlDate = java.sql.Date.valueOf(datanasc);
		}

		//MODIFICAR O FILME DO DIRETOR
		String idfilme = request.getParameter("idfilme");
		
		boolean resultado = edd.editarDiretor(nome, biografia, sqlDate, d.getId_diretor(), d.getId_filme());

		if(resultado){
			request.setAttribute("iddiretor", iddiretor);
			request.setAttribute("diretor", d);
			RequestDispatcher rd = request.getRequestDispatcher("/detalhaDiretor");
			rd.forward(request, response);

		}else{
			request.setAttribute("mensagem", "ERRO AO MODIFICAR DIRETOR");
			request.setAttribute("diretor", d);
			RequestDispatcher rd = request.getRequestDispatcher("/respostaEditarDiretor.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conexao = Conexao.getConexao();

		EditarDiretorDAO edd = new EditarDiretorDAO(conexao);

		String iddiretor = request.getParameter("iddiretor");
	
		ConsultarDiretorDAO cdd = new ConsultarDiretorDAO(conexao);

		Diretor d = cdd.getDiretor(iddiretor);

		out.println(d.getNome_diretor());

		//MODIFICAR O NOME DO DIRETOR

		String nome = request.getParameter("nome");

		if(nome.equals("")){
			nome = d.getNome_diretor();
		}

		//MODIFICAR A BIOGRAFIA DO DIRETOR

		String biografia = request.getParameter("biografia");

		if(biografia.equals("")){
			biografia = d.getBiografia();
		}


		//MODIFICAR A DATA DE NASCIMENTO DO DIRETOR

		String datanasc = request.getParameter("datanasc");

		java.sql.Date sqlDate = null;

		if(datanasc.equals("")){
			sqlDate = d.getData_nasc();
		}else{
			sqlDate = java.sql.Date.valueOf(datanasc);
		}

		//MODIFICAR O FILME DO DIRETOR
		String idfilme = request.getParameter("idfilme");
		
		boolean resultado = edd.editarDiretor(nome, biografia, sqlDate, d.getId_diretor(), d.getId_filme());

		if(resultado){
			request.setAttribute("iddiretor", iddiretor);
			request.setAttribute("diretor", d);
			RequestDispatcher rd = request.getRequestDispatcher("/detalhaDiretor");
			rd.forward(request, response);

		}else{
			request.setAttribute("mensagem", "ERRO AO MODIFICAR DIRETOR");
			request.setAttribute("diretor", d);
			RequestDispatcher rd = request.getRequestDispatcher("/respostaEditarDiretor.jsp");
			rd.forward(request, response);
		}
	}
}

