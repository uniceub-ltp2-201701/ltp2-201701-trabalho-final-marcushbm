package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Filme;

public class ListarFilmesDAO {

	private Connection conexao;
	
	public ListarFilmesDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Filme> getFilmes(){
		
		PreparedStatement ps = null;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		try{
			
			ps = conexao.prepareStatement("select * from filme");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				filmes.add(new Filme(rs.getInt("idfilme"), rs.getString("titulo"), rs.getInt("ano"), rs.getString("categoria"),rs.getInt("faixaetaria"),rs.getDouble("pontuacao"),rs.getInt("duracao"),rs.getString("sinopse"), rs.getDate("datalancamento")));
			}
			
			rs.close();
			ps.close();
			
		}catch(Exception e){
			
		}
		
		return filmes;
		
	}
	
	
}
