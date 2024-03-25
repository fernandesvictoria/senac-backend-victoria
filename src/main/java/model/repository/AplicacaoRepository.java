package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.entity.Aplicacao;
import model.entity.Vacina;

public class AplicacaoRepository {

	public Aplicacao salvar(Aplicacao novaVacinacao) {
		String sql = " INSERT INTO aplicacao_vacina (idpessoa, idvacina, data_aplicacao, avaliacao) "
				+ " VALUES(?, ?, ?, ?) ";
		Connection conexao = Banco.getConnection();
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);

		try {
			stmt.setInt(1, novaVacinacao.getIdpessoa());
			stmt.setInt(2, novaVacinacao.getVacina().getId());
			stmt.setDate(3, Date.valueOf(novaVacinacao.getData()));
			stmt.setInt(4, novaVacinacao.getAvaliacao());
			
			stmt.execute();

			ResultSet resultado = stmt.getGeneratedKeys();
			if (resultado.next()) {
				novaVacinacao.setId(resultado.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar nova aplicação");
			System.out.println("Erro: " + e.getMessage());
		}

		return novaVacinacao;
	}

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean excluiu = false;
		String query = "DELETE FROM aplicacao_vacina WHERE IDAPLICACAO_VACINA = " + id;
		try {
			if (stmt.executeUpdate(query) == 1) {
				excluiu = true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao excluir aplicação");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return excluiu;
	}

	public boolean alterar(Aplicacao aplicacaoEditada) {
		boolean alterou = false;
		String query = "UPDATE APLICACAO_VACINA SET idpessoa=?, idvacina=?, DATA_APLICACAO=?, avaliacao=? WHERE IDAPLICACAO_VACINA=?";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatement(conn, query);
		try {
			
			pstmt.setInt(1, aplicacaoEditada.getIdpessoa());
			pstmt.setInt(2, aplicacaoEditada.getVacina().getId());
			pstmt.setDate(3, Date.valueOf(aplicacaoEditada.getData()));
			pstmt.setInt(4, aplicacaoEditada.getAvaliacao());
			pstmt.setInt(5, aplicacaoEditada.getId());
 
			alterou = pstmt.executeUpdate() > 0;
		} catch (SQLException erro) {
			System.out.println("Erro ao atualizar aplicação.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return alterou;
	}

	public Aplicacao consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = null;
		ResultSet resultado = null;
		Aplicacao aplicacao = null;

		String query = "SELECT * FROM aplicacao_vacina WHERE IDAPLICACAO_VACINA = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			resultado = pstmt.executeQuery();

			if (resultado.next()) {
				aplicacao = new Aplicacao();
				aplicacao.setId(resultado.getInt("IDAPLICACAO_VACINA"));
				aplicacao.setIdpessoa(resultado.getInt("idpessoa"));

				// instância de VacinaRepository pq método não é static
				VacinaRepository vacinaRepository = new VacinaRepository();

				// Consultar a vacina pelo ID
				int idVacina = resultado.getInt("idvacina");
				Vacina vacina = vacinaRepository.consultarPorId(idVacina);
				aplicacao.setVacina(vacina);
				aplicacao.setData(resultado.getDate("DATA_APLICACAO").toLocalDate());
				aplicacao.setAvaliacao(resultado.getInt("avaliacao"));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao consultar aplicação por id (" + id + ").");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return aplicacao;
	}

	public ArrayList<Aplicacao> consultarTodos() {
		ArrayList<Aplicacao> aplicacoes = new ArrayList<>();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;
		String query = " SELECT * FROM aplicacao_vacina";

		try {
			resultado = stmt.executeQuery(query);
			VacinaRepository vacinaRepository = new VacinaRepository();
			while (resultado.next()) {
				Aplicacao vacinacao = new Aplicacao();
				vacinacao.setId(resultado.getInt("IDAPLICACAO_VACINA"));
				vacinacao.setId(resultado.getInt("IDPESSOA"));

				Vacina vacinaAplicada = vacinaRepository.consultarPorId(resultado.getInt("IDVACINA"));

				vacinacao.setVacina(vacinaAplicada);
				vacinacao.setData(resultado.getDate("DATA_APLICACAO").toLocalDate());
				vacinacao.setAvaliacao(resultado.getInt("AVALIACAO"));

				aplicacoes.add(vacinacao);
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar consultar todas as Aplicacoes");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return aplicacoes;
	}

	public ArrayList<Aplicacao> consultarPorIdPessoa(int idPessoa) {
		ArrayList<Aplicacao> aplicacoes = new ArrayList<>();
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = null;
		ResultSet resultado = null;
 
		String query = "SELECT * FROM APLICACAO_VACINA WHERE idpessoa = ?";
 
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idPessoa);
			resultado = pstmt.executeQuery();
 
			while (resultado.next()) {
				Aplicacao aplicacao = new Aplicacao();
				aplicacao.setId(resultado.getInt("IDAPLICACAO_VACINA"));
				aplicacao.setIdpessoa(resultado.getInt("idpessoa"));
 
				VacinaRepository vacinaRepository = new VacinaRepository();
 
				int idVacina = resultado.getInt("idvacina");
				Vacina vacina = vacinaRepository.consultarPorId(idVacina);
				aplicacao.setVacina(vacina);
				aplicacao.setData(resultado.getDate("DATA_APLICACAO").toLocalDate());
				aplicacao.setAvaliacao(resultado.getInt("avaliacao"));
 
				aplicacoes.add(aplicacao);
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao consultar aplicações por id de pessoa (" + idPessoa + ").");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return aplicacoes;
	}

}
