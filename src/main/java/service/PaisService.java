package service;

import java.util.ArrayList;

import model.entity.Pais;
import model.repository.PaisRepository;

public class PaisService {

	private PaisRepository repository = new PaisRepository();

	public Pais cadastrarPais(Pais novoPais) {

		return repository.salvar(novoPais);
	}

	public Pais consultarPorId(int id) {
		return repository.consultarPorId(id);
	}

	public ArrayList<Pais> consultarPaises() {
		return repository.consultarTodosPais();
	}
}
