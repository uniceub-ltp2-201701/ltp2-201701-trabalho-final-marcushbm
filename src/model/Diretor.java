package model;

import java.sql.Date;

public class Diretor {
	
	private int id_diretor;
	private int id_filme;
	private String nome_diretor;
	private String biografia;
	private Date data_nasc;
	
	
	public Diretor(int id_diretor, int id_filme, String nome_diretor, String biografia, Date data_nasc) {
		this.id_diretor = id_diretor;
		this.id_filme = id_filme;
		this.nome_diretor = nome_diretor;
		this.biografia = biografia;
		this.data_nasc = data_nasc;
	}

	public int getId_diretor() {
		return id_diretor;
	}


	public void setId_diretor(int id_diretor) {
		this.id_diretor = id_diretor;
	}

	public int getId_filme() {
		return id_filme;
	}

	public void setId_filme(int id_filme) {
		this.id_filme = id_filme;
	}

	public String getNome_diretor() {
		return nome_diretor;
	}

	public void setNome_diretor(String nome_diretor) {
		this.nome_diretor = nome_diretor;
	}
	
	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

}
