package model.entity;

import java.time.LocalDate;

import model.entity.enums.Categoria;

public class Pessoa {

	private int id;
	private String nome;
	private LocalDate dataNascimento;
	private String sexo;
	private String cpf;
	private Categoria tipo;

	public Pessoa(int id, String nome, LocalDate dataNascimento, String sexo, String cpf, Categoria tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.tipo = tipo;
	}

	public Pessoa() {
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

	public Categoria getTipo() {
		return tipo;
	}

	public void setTipo(Categoria tipo) {
		this.tipo = tipo;
	}

}