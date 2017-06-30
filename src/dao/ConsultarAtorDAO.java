package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Ator;
import model.Filme;

public class ConsultarAtorDAO {

	private Connection conexao;

	public ConsultarAtorDAO(Connection conexao){
		this.conexao = conexao;
	}

	//Metódo que detalha os dados do Ator
	public Ator getAtor(String idAtor){
		Ator a = null;

		PreparedStatement ps = null;


		try{
			ps = conexao.prepareStatement("select * from ator where idator = ?");
			ps.setInt(1, Integer.parseInt(idAtor));

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				a = new Ator(rs.getInt("idator"), rs.getInt("idfilme"),rs.getString("nome"), rs.getString("biografia"),rs.getDate("datanasc"));
			}

			rs.close();
			ps.close();

		}catch(Exception e){

		}

		return a;
	}

	public ArrayList<Filme> getFilmesPorAtor(String idAtor){

		PreparedStatement ps = null;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		ResultSet rs = null;

		try{

			ps = conexao.prepareStatement("select filme.idfilme, filme.titulo, filme.ano, filme.categoria, filme.faixaetaria, filme.pontuacao, filme.duracao, filme.sinopse, filme.datalancamento from filme, ator where ator.idator = ? and filme.idfilme = ator.idfilme");
			ps.setInt(1, Integer.parseInt(idAtor));

			rs = ps.executeQuery();

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
