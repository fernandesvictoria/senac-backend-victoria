package model.seletor;

public class VacinaSeletor extends BaseSeletor {

	private String nome;
	private String nomePais;
	private String pesquisadorResponsavel;
	private String estagio;

	public boolean temFiltro() {
		return (this.nome != null && this.nome.trim().length() > 0) 
				|| (this.getNomePais() != null)
				|| (this.getPesquisadorResponsavel() != null) 
				|| (this.estagio != null);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomePais() {
		return nomePais;
	}

	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}

	public String getPesquisadorResponsavel() {
		return pesquisadorResponsavel;
	}

	public void setPesquisadorResponsavel(String pesquisadorResponsavel) {
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}

	public String getEstagio() {
		return estagio;
	}

	public void setEstagio(String estagio) {
		this.estagio = estagio;
	}

	

}
