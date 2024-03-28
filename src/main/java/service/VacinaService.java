package service;




import java.util.ArrayList;

import exception.ControleVacinasException;
import model.entity.Pessoa;
import model.entity.Vacina;
import model.entity.enums.Categoria;
import model.repository.VacinaRepository;

public class VacinaService {

	private VacinaRepository repository = new VacinaRepository();

	public Vacina salvarVacina(Vacina novaVacina) {
	    if (verificarPesquisador(novaVacina.getPesquisadorResponsavel())) {
	        return repository.salvar(novaVacina);
	    } else {
	        System.out.println("Pessoa informada não é PESQUISADOR");
	    }
	    return null;
	}

	public boolean excluirVacina(int id) throws ControleVacinasException {
		if (repository.pessoaRecebeuVacina(id)) {
			throw new ControleVacinasException("Não é possível excluir vacina pois esta já foi aplicada a uma pessoa.");
		}
		return repository.excluir(id);
	}
	
	public boolean alterar(Vacina vacinaEditada) {
		return repository.alterar(vacinaEditada);
	}

	public ArrayList<Vacina> consultarTodasVacinas() {
		return repository.consultarTodos();
	}

	public Vacina consultarPorId(int id) {
		return repository.consultarPorId(id);
	}
	
	private boolean verificarPesquisador(Pessoa pessoa) {
	    return pessoa.getTipo() == Categoria.PESQUISADOR;
	}
}
