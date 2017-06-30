package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class AdicionarFilmeDAO {
	
	private Connection conexao;
	
	public AdicionarFilmeDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean adicionarFilme(String titulo,int ano,String categoria,int faixaetaria, double pontuacao,int duracao, String sinopse, Date datalancamento){
		
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try{
			
			ps = conexao.prepareStatement("insert into filme (titulo,ano,categoria,faixaetaria,pontuacao,duracao,sinopse,datalancamento)"
					+ "values (?, 0, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, titulo);
			ps.setString(2, categoria);
			ps.setInt(3, faixaetaria);
			ps.setDouble(4, pontuacao);
			ps.setInt(5, duracao);
			ps.setString(6, sinopse);
			ps.setDate(7, datalancamento);
			
			ps.executeUpdate();
			
			ps.close();
			resultado = true;
			
		}catch(Exception e){
			
		}
		
		return resultado;
	}

}
