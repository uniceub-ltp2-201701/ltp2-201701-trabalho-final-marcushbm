package model;

import java.sql.Date;

public class Filme {

	private int id_filme;
	private String titulo;
	private int ano;
	private String categoria;
	private int faixa_etaria;
	private double pontuacao;
	private int duracao;
	private String sinopse;
	private Date data_lancamento;


	public Filme(int id_filme, String titulo, int ano, String categoria, int faixa_etaria, double pontuacao, int duracao, String sinopse, Date data_lancamento) {
		this.id_filme = id_filme;
		this.titulo = titulo;
		this.ano = ano;
		this.categoria = categoria;
		this.faixa_etaria = faixa_etaria;
		this.pontuacao = pontuacao;
		this.duracao = duracao;
		this.sinopse = sinopse;
		this.data_lancamento = data_lancamento;
	}

	public int getId_filme() {
		return id_filme;
	}

	public void setId_filme(int id_filme) {
		this.id_filme = id_filme;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getFaixa_etaria() {
		return faixa_etaria;
	}

	public void setFaixa_etaria(int faixa_etaria) {
		this.faixa_etaria = faixa_etaria;
	}

	public double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Date getData_lancamento() {
		return data_lancamento;
	}

	public void setData_lancamento(Date data_lancamento) {
		this.data_lancamento = data_lancamento;
	}

}
