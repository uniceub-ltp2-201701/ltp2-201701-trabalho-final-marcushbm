package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Ator;
import model.Diretor;
import model.Filme;

public class DetalhaFilmeDAO {

	private Connection conexao;

	public DetalhaFilmeDAO(Connection conexao){
		this.conexao = conexao;

	}

	public Filme getFilme(String idFilme){

		PreparedStatement ps = null;

		Filme f = null;

		try{ 
			ps = conexao.prepareStatement("select * from filme where idfilme = ?");
			ps.setInt(1, Integer.parseInt(idFilme));

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				f = new Filme(rs.getInt("idfilme"), rs.getString("titulo"), rs.getInt("ano"), rs.getString("categoria"),rs.getInt("faixaetaria"),rs.getDouble("pontuacao"),rs.getInt("duracao"),rs.getString("sinopse"), rs.getDate("datalancamento"));
			}
			ps.close();
			rs.close();

		}catch (Exception e){

		}
		return f;

	}


	public ArrayList<Ator> getAtorPorFilme(String idFilme){
		ArrayList<Ator> atores = new ArrayList<Ator>();

		PreparedStatement ps = null;

		try{

			ps = conexao.prepareStatement("select * from ator where ator.idfilme = ?");
			ps.setInt(1, Integer.parseInt(idFilme));

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				atores.add(new Ator(rs.getInt("idator"), rs.getInt("idfilme"), rs.getString("nome"), rs.getString("biografia"),rs.getDate("datanasc")));

			}

			ps.close();
			rs.close();

		}catch(Exception e){
		}
		return atores;
	}

	public ArrayList<Diretor> getDiretorPorFilme(String idFilme){
		ArrayList<Diretor> diretores = new ArrayList<Diretor>();

		PreparedStatement ps = null;

		try{

			ps = conexao.prepareStatement("select * from diretor where diretor.idfilme = ?");
			ps.setInt(1, Integer.parseInt(idFilme));

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				diretores.add(new Diretor(rs.getInt("iddiretor"), rs.getInt("idfilme"), rs.getString("nome"), rs.getString("biografia"),rs.getDate("datanasc")));

			}

			ps.close();
			rs.close();

		}catch(Exception e){

		}

		return diretores;

	}

}

