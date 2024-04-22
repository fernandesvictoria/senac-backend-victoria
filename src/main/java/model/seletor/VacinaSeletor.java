package model.seletor;

import model.entity.Pais;
import model.entity.Pessoa;
import model.entity.enums.Estagio;

public class VacinaSeletor extends BaseSeletor {

	private String nome;
	private Pais pais;
	private Pessoa pesquisadorResponsavel;
	private Estagio estagio;

	public boolean temFiltro() {
		return (this.nome != null && this.nome.trim().length() > 0) 
				|| (this.pais.getNome() != null)
				|| (this.pesquisadorResponsavel.getNome() != null) 
				|| (this.estagio != null);
	}

	public VacinaSeletor(String nome, Pais pais, Pessoa pesquisadorResponsavel, Estagio estagio) {
		super();
		this.nome = nome;
		this.pais = pais;
		this.pesquisadorResponsavel = pesquisadorResponsavel;
		this.estagio = estagio;
	}

	public VacinaSeletor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
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

}
