package controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.Pessoa;
import service.PessoaService;

@Path("/pessoa")
public class PessoaController {

	private PessoaService service = new PessoaService();

	@POST
	@Path("/salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa cadastrar(Pessoa novaPessoa) {
		return service.cadastrarPessoa(novaPessoa);
	}

	@DELETE
	@Path("/{id}")
	public boolean excluir(@PathParam("id") int id) {
		return service.excluirPessoa(id);
	}

	@GET
	@Path("/todas")
	public List<Pessoa> consultarTodasPessoas() {
		return service.consultarTodasPessoas();
	}
}
