package service;

import java.util.ArrayList;

import model.entity.Pessoa;
import model.repository.PessoaRepository;

public class PessoaService {

	private PessoaRepository repository = new PessoaRepository();

	public Pessoa cadastrarPessoa(Pessoa novaPessoa) {
		
		return repository.salvar(novaPessoa);
	}

	public boolean excluirPessoa(int id) {

		return repository.excluir(id);
	}
	
	public boolean alterar(Pessoa PessoaEditada) {
		return repository.alterar(PessoaEditada);
	}

	public ArrayList<Pessoa> consultarTodasPessoas() {
		return repository.consultarTodos();
	}
	
	public Pessoa consultarPorId(int id) {
		return repository.consultarPorId(id);
	}

}
