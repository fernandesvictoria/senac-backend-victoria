package model.entity;

import java.time.LocalDate;

public class Aplicacao {
	private int id;
	private Pessoa pessoa;
	private Vacina vacina;
	private LocalDate data;
	private int avaliacao;

	public Aplicacao(int id, Pessoa pessoa, Vacina vacina, LocalDate data, int avaliacao) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.vacina = vacina;
		this.data = data;
		this.avaliacao = avaliacao;
	}

	public Aplicacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

}