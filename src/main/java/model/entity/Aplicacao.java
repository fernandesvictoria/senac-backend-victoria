package model.entity;

import java.time.LocalDate;

public class Aplicacao {
	private int id;
	private int idpessoa;
	private Vacina vacina;
	private LocalDate data;
	private int avaliacao;

	public Aplicacao(int id, int idpessoa, Vacina vacina, LocalDate data, int avaliacao) {
		super();
		this.id = id;
		this.idpessoa = idpessoa;
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

	public int getIdpessoa() {
		return idpessoa;
	}

	public void setIdpessoa(int idpessoa) {
		this.idpessoa = idpessoa;
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