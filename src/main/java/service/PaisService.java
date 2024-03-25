package service;

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

}
