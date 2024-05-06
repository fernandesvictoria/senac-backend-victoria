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
import model.entity.Pessoa;
import service.PessoaService;

@Path("/pessoa")
public class PessoaController {

	private PessoaService service = new PessoaService();

	@POST
	@Path("/salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa cadastrar(Pessoa novaPessoa) throws ControleVacinasException {
		return service.cadastrarPessoa(novaPessoa) ;
	}

	@DELETE
	@Path("/{id}")
	public boolean excluir(@PathParam("id") int id) throws ControleVacinasException {
		return service.excluirPessoa(id);
	}
	
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean alterar(Pessoa PessoaEditada) throws ControleVacinasException {
		return service.alterar(PessoaEditada);
	}

	@GET
	@Path("/todas")
	public List<Pessoa> consultarTodasPessoas() {
		return service.consultarTodasPessoas();
	}
	
	@GET
	@Path("/pesquisadores")
	public List<Pessoa> consultarPesquisadores() {
		return service.consultarPesquisadores();
	}
	
	@GET
	@Path("/{id}")
	public Pessoa consultarPorId(@PathParam("id") int id){
		 return service.consultarPorId(id);
	}
}
