package model.entity;

import java.time.LocalDate;

import model.entity.enums.Estagio;

public class Vacina {

	private int id;
	private String nome;
	private String paisOrigem;
	private Pessoa pesquisadorResponsavel;
	private Estagio estagio;
	private LocalDate dataInicioPesquisa;
	public Vacina(int id, String nome, String paisOrigem, Pessoa pesquisadorResponsavel, Estagio estagio,
			LocalDate dataInicioPesquisa) {
		super();
		this.id = id;
		this.nome = nome;
		this.paisOrigem = paisOrigem;
		this.pesquisadorResponsavel = pesquisadorResponsavel;
		this.estagio = estagio;
		this.dataInicioPesquisa = dataInicioPesquisa;
	}
	public Vacina() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPaisOrigem() {
		return paisOrigem;
	}
	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}
	public Pessoa getPesquisadorResponsavel() {
		return pesquisadorResponsavel;
	}
	public void setPesquisadorResponsavel(Pessoa pesquisadorResponsavel) {
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}
	public Estagio getEstagio() {
		return estagio;
	}
	public void setEstagio(Estagio estagio) {
		this.estagio = estagio;
	}
	public LocalDate getDataInicioPesquisa() {
		return dataInicioPesquisa;
	}
	public void setDataInicioPesquisa(LocalDate dataInicioPesquisa) {
		this.dataInicioPesquisa = dataInicioPesquisa;
	}

	

	
}
