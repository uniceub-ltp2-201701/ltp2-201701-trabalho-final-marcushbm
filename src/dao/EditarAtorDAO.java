package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import static java.lang.System.out;
public class EditarAtorDAO {
	
	private Connection conexao;
	
	public EditarAtorDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean editarAtor(String nome, String biografia, Date nascimento, int idator, int idfilme){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try{

			ps = conexao.prepareStatement("update filmemania.ator set idfilme=?, nome=?, biografia=?,datanasc=? where idator = ?");
			
			ps.setInt(1, idfilme);
			ps.setString(2, nome);
			ps.setString(3, biografia);
			ps.setDate(4, nascimento);
			ps.setInt(5, idator);
			
			ps.executeUpdate();
			
			ps.close();
			resultado = true;
			
		}catch(Exception e){
			
		}
		
		return resultado;
		
	}

}
