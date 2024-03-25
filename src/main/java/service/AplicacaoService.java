package service;

import java.util.ArrayList;
import model.entity.Aplicacao;
import model.repository.AplicacaoRepository;

public class AplicacaoService {

	private AplicacaoRepository repository = new AplicacaoRepository();

	public Aplicacao cadastrarAplicacao(Aplicacao novaAplicacao) {

		return repository.salvar(novaAplicacao);
	}

	public boolean excluir(int id) {

		return repository.excluir(id);
	}

	public boolean alterar(Aplicacao AplicacaoEditada) {
		return repository.alterar(AplicacaoEditada);
	}

	public ArrayList<Aplicacao> consultarTodasAplicacoes() {
		return repository.consultarTodos();
	}

	public Aplicacao consultarPorId(int id) {
		return repository.consultarPorId(id);

	}
	public ArrayList<Aplicacao> consultarPorIdPessoa(int id) {
		return repository.consultarPorIdPessoa(id);
	}
	
}
