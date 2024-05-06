package controller;

import java.util.List;
import exception.ControleVacinasException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.Vacina;
import model.seletor.VacinaSeletor;
import service.VacinaService;

@Path("/vacina")
public class VacinaController {

	private VacinaService service = new VacinaService();

	@POST
	@Path("/salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Vacina salvar(Vacina novaVacina) {
		return service.salvarVacina(novaVacina);
	}

	@DELETE
	@Path("/{id}")
	public boolean excluir(@PathParam("id") int id) throws ControleVacinasException {
		return service.excluirVacina(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean atualizar(Vacina vacinaEditada) {
		return service.alterar(vacinaEditada);
	}

	@GET
	@Path("/todas")
	public List<Vacina> consultarTodasPessoas() {
		return service.consultarTodasVacinas();
	}

	@GET
	@Path("/{id}")
	public Vacina consultarPorId(@PathParam("id") int id) {
		return service.consultarPorId(id);
	}

	@POST
	@Path("/filtrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vacina> consultarComFiltro(VacinaSeletor seletor) {
		return service.consultarComFiltro(seletor);
	}
}
