package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class EditarDiretorDAO {

private Connection conexao;
	
	public EditarDiretorDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean editarDiretor(String nome, String biografia, Date nascimento, int iddiretor, int idfilme){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try{

			ps = conexao.prepareStatement("update filmemania.diretor set idfilme=?, nome=?, biografia=?,datanasc=? where iddiretor = ?");
			
			ps.setInt(1, idfilme);
			ps.setString(2, nome);
			ps.setString(3, biografia);
			ps.setDate(4, nascimento);
			ps.setInt(5, iddiretor);
			
			ps.executeUpdate();
			
			ps.close();
			resultado = true;
			
		}catch(Exception e){
			
		}
		
		return resultado;
		
	}
	
}
