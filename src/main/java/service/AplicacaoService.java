package service;

import java.time.LocalDate;
import java.util.ArrayList;
import exception.ControleVacinasException;
import model.entity.Aplicacao;
import model.repository.AplicacaoRepository;
import model.repository.VacinaRepository;

public class AplicacaoService {

	private AplicacaoRepository repository = new AplicacaoRepository();
	private VacinaRepository repositoryVacina = new VacinaRepository();
	private static final int NOTA_MAXIMA = 5;

	public Aplicacao cadastrarAplicacao(Aplicacao novaAplicacao) throws ControleVacinasException {

		if (novaAplicacao.getPessoa()== null || novaAplicacao.getVacina() == null
				|| novaAplicacao.getVacina().getId() == 0) {
			throw new ControleVacinasException(
			"É necessário informar o ID da pessoa e a vacina para realizar a aplicação.");
		}

		novaAplicacao.setData(LocalDate.now());

		if (novaAplicacao.getAvaliacao() == 0) {
			novaAplicacao.setAvaliacao(NOTA_MAXIMA);
		}

		double mediaAvaliacoes = repository.calcularMediaAvaliacoesPorVacina(novaAplicacao.getVacina().getId());
		repositoryVacina.atualizarMediaAvaliacoes(novaAplicacao.getVacina().getId(), mediaAvaliacoes);
		System.out.println("media service" + mediaAvaliacoes);
		System.out.println("idvacina" + novaAplicacao.getVacina().getId());

		return repository.salvar(novaAplicacao);
	}

	public boolean alterar(Aplicacao aplicacaoEditada) throws ControleVacinasException {
		System.out.println(aplicacaoEditada.getVacina().getId());
		double mediaAvaliacoes = repository.calcularMediaAvaliacoesPorVacina(aplicacaoEditada.getVacina().getId());
		repositoryVacina.atualizarMediaAvaliacoes(aplicacaoEditada.getVacina().getId(), mediaAvaliacoes);

		return repository.alterar(aplicacaoEditada);
	}

	public boolean excluir(int id) {

		return repository.excluir(id);
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
