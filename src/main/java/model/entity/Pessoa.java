package model.entity;

import java.time.LocalDate;
import java.util.List;

import model.entity.enums.Categoria;

public class Pessoa {

	private int id;
	private String nome;
	private LocalDate dataNascimento;
	private String sexo;
	private String cpf;
	private Pais pais;
	private Categoria tipo;
	private List<Aplicacao> aplicacaoVacina;

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pessoa(int id, String nome, LocalDate dataNascimento, String sexo, String cpf, Pais pais, Categoria tipo,
			List<Aplicacao> aplicacaoVacina) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.pais = pais;
		this.tipo = tipo;
		this.aplicacaoVacina = aplicacaoVacina;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Categoria getTipo() {
		return tipo;
	}

	public void setTipo(Categoria tipo) {
		this.tipo = tipo;
	}

	public List<Aplicacao> getAplicacaoVacina() {
		return aplicacaoVacina;
	}

	public void setAplicacaoVacina(List<Aplicacao> aplicacaoVacina) {
		this.aplicacaoVacina = aplicacaoVacina;
	}

}