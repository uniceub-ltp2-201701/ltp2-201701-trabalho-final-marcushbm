package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Diretor;
import model.Filme;

public class ConsultarDiretorDAO {

	private Connection conexao;

	public ConsultarDiretorDAO(Connection conexao){
		this.conexao = conexao;
	}

	//Metódo que detalha os dados do Diretor
	public Diretor getDiretor(String iddiretor){
		Diretor d = null;

		PreparedStatement ps = null;

		try{
			ps = conexao.prepareStatement("select * from diretor where iddiretor = ?");
			ps.setInt(1, Integer.parseInt(iddiretor));


			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				d = new Diretor(rs.getInt("iddiretor"), rs.getInt("idfilme"),rs.getString("nome"), rs.getString("biografia"),rs.getDate("datanasc"));
			}

			rs.close();
			ps.close();

		}catch(Exception e){

		}

		return d;
	}

	public ArrayList<Filme> getFilmesPorDiretor(String iddiretor){

		PreparedStatement ps = null;
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		ResultSet rs = null;

		try{

			ps = conexao.prepareStatement("select filme.idfilme, filme.titulo, filme.ano, filme.categoria, filme.sinopse, filme.faixaetaria, filme.pontuacao, filme.duracao, filme.datalancamento from filme, diretor where diretor.iddiretor = ? and filme.idfilme = diretor.idfilme");
			ps.setInt(1, Integer.parseInt(iddiretor));

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


