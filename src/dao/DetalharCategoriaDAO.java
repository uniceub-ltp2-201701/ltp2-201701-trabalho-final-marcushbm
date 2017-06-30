package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Filme;
import static java.lang.System.out;
public class DetalharCategoriaDAO {
	
	private Connection conexao;
	public String categoria;

	public DetalharCategoriaDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Filme> getTodosFilmesPorCategoria(String categoria){
		
		PreparedStatement ps = null;
		ArrayList<Filme> filmes = new ArrayList<Filme>();

		this.categoria = categoria;
	
		try{
			
			ps = conexao.prepareStatement("select * from filme where filme.categoria like ?");
			ps.setString(1, "%" + categoria + "%");
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				
				filmes.add(new Filme(rs.getInt("idfilme"), rs.getString("titulo"), rs.getInt("ano"), rs.getString("categoria"),rs.getInt("faixaetaria"),rs.getDouble("pontuacao"),rs.getInt("duracao"),rs.getString("sinopse"), rs.getDate("datalancamento")));
			}
			
			ps.close();
			rs.close();
			
		}catch(Exception e){
			
		}
		

		
		return filmes;
		
	}
	
}
