package service;

import java.util.ArrayList;

import exception.ControleVacinasException;
import model.entity.Pessoa;
import model.repository.PessoaRepository;

public class PessoaService {

	private PessoaRepository repository = new PessoaRepository();

	public Pessoa cadastrarPessoa(Pessoa novaPessoa) throws ControleVacinasException {
		validarCamposObrigatorios(novaPessoa);
		validarCpf(novaPessoa);

		return repository.salvar(novaPessoa);
	}

	private void validarCpf(Pessoa novaPessoa) throws ControleVacinasException {
		if (repository.cpfExiste(novaPessoa.getCpf())) {
			throw new ControleVacinasException("CPF " + novaPessoa.getCpf() + " já cadastrado ");
		}
	}

	private void validarCamposObrigatorios(Pessoa p) throws ControleVacinasException {
		String mensagemValidacao = "";
		if (p.getNome() == null || p.getNome().isEmpty()) {
			mensagemValidacao += " - informe o nome \n";
		}
		if (p.getDataNascimento() == null) {
			mensagemValidacao += " - informe a data de nascimento \n";
		}
		if (p.getCpf() == null || p.getCpf().isEmpty() || p.getCpf().length() != 11) {
			mensagemValidacao += " - informe o CPF";
		}
		if (p.getSexo() == null) {
			mensagemValidacao += " - informe o sexo";
		}

		if (!mensagemValidacao.isEmpty()) {
			throw new ControleVacinasException("Preencha o(s) seguinte(s) campo(s) \n " + mensagemValidacao);
		}

	}

	public boolean excluirPessoa(int id) throws ControleVacinasException {
		if (repository.pessoaRecebeuVacina(id)) {
			throw new ControleVacinasException("Não é possível excluir pessoa pois já recebeu uma dose de vacina.");
	        
	    }
		
		return repository.excluir(id);
	}

	public boolean alterar(Pessoa PessoaEditada) throws ControleVacinasException {
		validarCamposObrigatorios(PessoaEditada);
		return repository.alterar(PessoaEditada);
	}

	public ArrayList<Pessoa> consultarTodasPessoas() {
		return repository.consultarTodos();
	}

	public Pessoa consultarPorId(int id) {
		return repository.consultarPorId(id);
	}

}
