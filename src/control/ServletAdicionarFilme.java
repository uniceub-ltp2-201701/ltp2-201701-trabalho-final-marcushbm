package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdicionarDiretorDAO;
import dao.AdicionarFilmeDAO;
import dao.Conexao;
import dao.ListarFilmesDAO;

@WebServlet("/adicionarFilme")
public class ServletAdicionarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAdicionarFilme() {
    	super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = Conexao.getConexao();

		AdicionarFilmeDAO afd = new AdicionarFilmeDAO(conexao);
		
		String titulo = request.getParameter("titulo");
		int ano = 0;
		String categoria = request.getParameter("categoria");
		String faixaetaria = request.getParameter("faixaetaria");
		int f = Integer.parseInt(faixaetaria);
		String a = request.getParameter("pontuacao");
		double pontuacao = Double.parseDouble(a);
		String b = request.getParameter("duracao");
		int duracao = Integer.parseInt(b);
		String sinopse = request.getParameter("sinopse");
		String datalancamento = request.getParameter("datalancamento");
		java.sql.Date sqlDate = java.sql.Date.valueOf(datalancamento);		
		
		boolean resultado = afd.adicionarFilme(titulo,ano,categoria,f,pontuacao,duracao,sinopse,sqlDate);
				
		if(resultado){
			RequestDispatcher rd = request.getRequestDispatcher("/listarFilmes");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "ERRO, FILME NÃO ADICIONADO!");
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaAdicionarFilme.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = Conexao.getConexao();

		AdicionarDiretorDAO atd = new AdicionarDiretorDAO(conexao);
		
		String nome = request.getParameter("nome");
		String biografia = request.getParameter("biografia");
		String nasc = request.getParameter("nascimento");
		String idfilme = request.getParameter("idfilme");

		java.sql.Date sqlDate = java.sql.Date.valueOf(nasc);		
			
		boolean resultado = atd.adicionarDiretor(idfilme, nome, biografia, sqlDate);
		
		
		if(resultado){
			RequestDispatcher rd = request.getRequestDispatcher("/listarDiretores");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "ERRO, DIRETOR NÃO INCLUIDO!");
			RequestDispatcher rd = request.getRequestDispatcher("/respostaPaginaAdicionarDiretor.jsp");
			rd.forward(request, response);
		}
	}

}
