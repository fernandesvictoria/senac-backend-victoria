package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Pessoa;
import model.entity.Vacina;
import model.entity.enums.Categoria;
import model.entity.enums.Estagio;

public class VacinaRepository {

	public Vacina salvar(Vacina novaVacina) {

		String query = "INSERT INTO vacina (NOME, PAIS_ORIGEM, IDPESQUISADOR, ESTAGIO, DATA_INICIO_PESQUISA) VALUES (?, ?, ?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			pstmt.setString(1, novaVacina.getNome());
			pstmt.setString(2, novaVacina.getPaisOrigem());
			pstmt.setInt(3, novaVacina.getPesquisadorResponsavel().getId());
			pstmt.setString(4, novaVacina.getEstagio().toString());
			pstmt.setDate(5, Date.valueOf(novaVacina.getDataInicioPesquisa()));
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();

			if (resultado.next()) {
				novaVacina.setId(resultado.getInt(1));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método salvar Vacina!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}

		return novaVacina;
	}

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean excluiu = false;
		String query = "DELETE FROM vacina WHERE idvacina = " + id;
		try {
			if (stmt.executeUpdate(query) == 1) {
				excluiu = true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao excluir vacina");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return excluiu;
	}

	public ArrayList<Vacina> consultarTodos() {
		ArrayList<Vacina> vacinas = new ArrayList<>();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;
		String query = "SELECT * FROM vacina;";

		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				Vacina vacina = new Vacina();
				VacinaRepository vacinaRepository = new VacinaRepository();
				int idPesquisador = Integer.parseInt(resultado.getString("IDVACINA"));

				vacina.setId(idPesquisador);
				vacina.setNome(resultado.getString("NOME"));
				vacina.setPaisOrigem(resultado.getString("PAIS_ORIGEM"));
				vacina.setPesquisadorResponsavel(vacinaRepository.buscarPesquisadorPorID(idPesquisador));
				vacina.setEstagio(Estagio.valueOf(resultado.getString("estagio").toUpperCase()));
				vacina.setDataInicioPesquisa(resultado.getDate("DATA_INICIO_PESQUISA").toLocalDate());
				vacinas.add(vacina);
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar consultar todas as vacinas");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return vacinas;
	}

	public Pessoa buscarPesquisadorPorID(int idPesquisador) {
		Pessoa pesquisador = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultado = null;

		try {
			conn = Banco.getConnection();
			String query = "SELECT * FROM pessoa WHERE id = ?";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, idPesquisador);
			resultado = stmt.executeQuery();

			if (resultado.next()) {
				pesquisador = new Pessoa();
				pesquisador.setId(resultado.getInt("IDVACINA"));
				pesquisador.setNome(resultado.getString("NOME"));
				pesquisador.setDataNascimento(resultado.getDate("DATA_NASCIMENTO").toLocalDate());
				pesquisador.setSexo(resultado.getString("SEXO"));
				pesquisador.setCpf(resultado.getString("cpf"));
				pesquisador.setTipo(Categoria.valueOf(resultado.getString("tipo_pessoa").toUpperCase()));

			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar pesquisador por ID: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return pesquisador;
	}

	public Vacina consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;
		Vacina vacina = new Vacina();
		String query = " SELECT * FROM vacina WHERE idvacina = " + id;

		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				vacina.setNome(resultado.getString("NOME"));
				vacina.setDataInicioPesquisa(resultado.getDate("DATA_INICIO_PESQUISA").toLocalDate());
				vacina.setPaisOrigem(resultado.getString("PAIS_ORIGEM"));

				PessoaRepository pessoaRepository = new PessoaRepository();

				int idPesquisador = resultado.getInt("idpesquisador");
				Pessoa pesquisador = pessoaRepository.consultarPorId(idPesquisador);
				vacina.setPesquisadorResponsavel(pesquisador);

				vacina.setEstagio(Estagio.valueOf(resultado.getString("ESTAGIO").toUpperCase()));

			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar consultar PESSOA com id (" + id + ")");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return vacina;
	}

}




