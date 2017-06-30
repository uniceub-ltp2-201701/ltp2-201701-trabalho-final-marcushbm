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
import dao.DetalhaFilmeDAO;
import dao.EditarFilmeDAO;
import model.Filme;
import static java.lang.System.out;

@WebServlet("/editarFilme")
public class ServletEditarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletEditarFilme() {
        super();
      
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		Connection conexao = Conexao.getConexao();

		EditarFilmeDAO efd = new EditarFilmeDAO(conexao);
		
		String idfilme = request.getParameter("idfilme");
		
		DetalhaFilmeDAO dfd = new DetalhaFilmeDAO(conexao);
		
		Filme f = dfd.getFilme(idfilme);
		
		out.println(f.getTitulo());
		
		String titulo = request.getParameter("titulo");
		
		if(titulo.equals("")){
			titulo = f.getTitulo();
		}
		
		String sinopse = request.getParameter("sinopse");
		
		if(sinopse.equals("")){
			sinopse = f.getSinopse();
		}
		
		String categoria = request.getParameter("categoria");
		
		if(categoria.equals("")){
			categoria = f.getCategoria();
		}
		
		String c = request.getParameter("faixaetaria");

		int faixaetaria = 0;
		
		
		if(c.equals("")){
			faixaetaria = f.getFaixa_etaria();
		}else{
			faixaetaria = Integer.parseInt(c);
		}
		
		String a = request.getParameter("pontuacao");
		double pontuacao = 0;
		
		if(a.equals("")){
			pontuacao = f.getPontuacao();
		}else{
			pontuacao = Double.parseDouble(a);
		}
		
		String b = request.getParameter("duracao");
		int duracao = 0;
		
		if(b.equals("")){
			duracao = f.getDuracao();
		}else{
			duracao = Integer.parseInt(b);
		}
		
		String lancamento = request.getParameter("datalancamento");
		
		java.sql.Date sqlDate = null;
		
		if(lancamento.equals("")){
			sqlDate = f.getData_lancamento();
		}else{
			sqlDate = java.sql.Date.valueOf(lancamento);
		}

		boolean resultado = efd.editarFilme(titulo, sinopse, categoria, faixaetaria, pontuacao, duracao, sqlDate, f.getId_filme());
		
		if(resultado){
			request.setAttribute("idfilme", idfilme);
			request.setAttribute("filme", f);
			RequestDispatcher rd = request.getRequestDispatcher("/detalhaFilme");
			rd.forward(request, response);
		}else{
			request.setAttribute("mensagem", "ERRO AO MODIFICAR FILME");
			request.setAttribute("filme", f);
			RequestDispatcher rd = request.getRequestDispatcher("/respostaEditarFilme.jsp");
			rd.forward(request, response);
		}
		
	}

}
