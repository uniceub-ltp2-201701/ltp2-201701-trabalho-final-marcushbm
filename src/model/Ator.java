package model;

import java.sql.Date;

public class Ator {

	private int id_ator;
	private int id_filme;
	private String nome_ator;
	private String bio_ator;
	private Date data_nasc;

	public Ator(int id_ator, int id_filme, String nome_ator, String bio_ator ,Date data_nasc) {
		this.id_ator = id_ator;
		this.id_filme = id_filme;
		this.nome_ator = nome_ator;
		this.bio_ator = bio_ator;
		this.data_nasc = data_nasc;
	}

	public int getId_ator() {
		return id_ator;
	}

	public void setId_ator(int id_ator) {
		this.id_ator = id_ator;
	}

	public int getId_filme() {
		return id_filme;
	}

	public void setId_filme(int id_filme) {
		this.id_filme = id_filme;
	}

	public String getNome_ator() {
		return nome_ator;
	}

	public void setNome_ator(String nome_ator) {
		this.nome_ator = nome_ator;
	}

	public String getBio_ator() {
		return bio_ator;
	}

	public void setBio_ator(String bio_ator) {
		this.bio_ator = bio_ator;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}



}
