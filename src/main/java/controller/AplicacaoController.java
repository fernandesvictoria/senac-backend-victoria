package controller;

import java.util.ArrayList;
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
import model.entity.Aplicacao;
import service.AplicacaoService;

@Path("/aplicacao")
public class AplicacaoController {

	private AplicacaoService service = new AplicacaoService();

	@POST
	@Path("/salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Aplicacao cadastrar(Aplicacao novaAplicacao) throws ControleVacinasException {
		return service.cadastrarAplicacao(novaAplicacao);
	}

	@DELETE
	@Path("/{id}")
	public boolean excluir(@PathParam("id") int id) {
		return service.excluir(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean alterar(Aplicacao AplicacaoEditada) throws ControleVacinasException {
		return service.alterar(AplicacaoEditada);
	}

	@GET
	@Path("/todas")
	public List<Aplicacao> consultarTodasAplicacoes() {
		return service.consultarTodasAplicacoes();
	}

	@GET
	@Path("/{id}")
	public Aplicacao consultarPorId(@PathParam("id") int id) {
		return service.consultarPorId(id);
	}
	
	@GET
	@Path("/pessoas/{id}")
	public ArrayList<Aplicacao> consultarPorIdPessoa(@PathParam("id") int id) {
		return service.consultarPorIdPessoa(id);
	}
	

}
