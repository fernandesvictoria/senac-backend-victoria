package service;




import java.util.ArrayList;

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

	public boolean excluirVacina(int id) {

		return repository.excluir(id);
	}
//	
//	public boolean atualizar(Vacina vacinaEditada) {
//		return repository.alterar(vacinaEditada);
//	}

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
