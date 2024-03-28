package service;

import java.time.LocalDate;
import java.util.ArrayList;

import exception.ControleVacinasException;
import model.entity.Aplicacao;
import model.entity.Pessoa;
import model.entity.Vacina;
import model.entity.enums.Categoria;
import model.entity.enums.Estagio;
import model.repository.AplicacaoRepository;
import model.repository.PessoaRepository;
import model.repository.VacinaRepository;

public class AplicacaoService {

	private AplicacaoRepository repository = new AplicacaoRepository();
	private VacinaRepository repositoryVacina = new VacinaRepository();
	private static final int NOTA_MAXIMA = 5;

	public Aplicacao cadastrarAplicacao(Aplicacao novaAplicacao) throws ControleVacinasException {

		if (novaAplicacao.getIdpessoa() == 0 || novaAplicacao.getVacina() == null
				|| novaAplicacao.getVacina().getId() == 0) {
			throw new ControleVacinasException(
					"É necessário informar o ID da pessoa e a vacina para realizar a aplicação.");

		}

		novaAplicacao.setData(LocalDate.now());

		if (novaAplicacao.getAvaliacao() == 0) {
			novaAplicacao.setAvaliacao(NOTA_MAXIMA);
		}

		if (!podeReceberVacina(novaAplicacao)) {
			throw new ControleVacinasException("A pessoa não pode receber esta vacina no estágio atual.");
		}

		double mediaAvaliacoes = repository.calcularMediaAvaliacoesPorVacina(novaAplicacao.getVacina().getId());
		repositoryVacina.atualizarMediaAvaliacoes(novaAplicacao.getVacina().getId(), mediaAvaliacoes);

		return repository.salvar(novaAplicacao);
	}

	public boolean excluir(int id) {

		return repository.excluir(id);
	}

	public boolean alterar(Aplicacao aplicacaoEditada) throws ControleVacinasException {

		double mediaAvaliacoes = repository.calcularMediaAvaliacoesPorVacina(aplicacaoEditada.getVacina().getId());
		repositoryVacina.atualizarMediaAvaliacoes(aplicacaoEditada.getVacina().getId(), mediaAvaliacoes);
		if (!podeReceberVacina(aplicacaoEditada)) {
			throw new ControleVacinasException("A pessoa não pode receber esta vacina no estágio atual.");
		}

		return repository.alterar(aplicacaoEditada);
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

	private boolean podeReceberVacina(Aplicacao novaAplicacao) {
		Vacina vacina = novaAplicacao.getVacina();
		PessoaRepository repository = new PessoaRepository();
		Pessoa pessoa = repository.consultarPorId(novaAplicacao.getId());

		if (vacina.getEstagio() == Estagio.INICIAL && pessoa.getTipo() != Categoria.PESQUISADOR) {
			return false;
		}
		if (vacina.getEstagio() == Estagio.TESTE && pessoa.getTipo() != Categoria.PESQUISADOR
				&& pessoa.getTipo() != Categoria.VOLUNTARIO) {
			return false;
		}
		return true;
	}
}
