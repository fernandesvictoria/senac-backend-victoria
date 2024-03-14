package service;

import java.util.ArrayList;

import model.entity.Pessoa;
import model.repository.PessoaRepository;

public class PessoaService {

	private PessoaRepository repository = new PessoaRepository();

	public Pessoa cadastrarPessoa(Pessoa novaPessoa) {
		return repository.cadastrarPessoa(novaPessoa);
	}

	public boolean excluirPessoa(int id) {

		return repository.excluirPessoa(id);
	}

	public ArrayList<Pessoa> consultarTodasPessoas() {
		return repository.consultarTodasPessoas();
	}

}
