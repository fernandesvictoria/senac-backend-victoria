package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.entity.Pessoa;

public class PessoaRepository {

	public Pessoa cadastrarPessoa(Pessoa pessoa) {
		if (pessoa.getCpf() == null) {
			System.out.println("Erro: CPF não pode ser nulo.");
			return null;
		} else if (cpfExiste(pessoa.getCpf())) {
			System.out.println("Erro: CPF duplicado.");
			return null;
		}

		String query = "INSERT INTO pessoa (nome, data_nascimento, sexo, cpf, tipo_pessoa) VALUES (?, ?, ?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			pstmt.setString(1, pessoa.getNome());
			pstmt.setDate(2, Date.valueOf(pessoa.getDataNascimento()));
			pstmt.setString(3, pessoa.getSexo());
			pstmt.setString(4, pessoa.getCpf());
			pstmt.setString(5, pessoa.getTipo());
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();
			if (resultado.next()) {
				pessoa.setId(resultado.getInt(1));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método cadastrarPessoa!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return pessoa;
	}

	private boolean cpfExiste(String cpf) {
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = null;
		ResultSet resultado = null;

		try {
			String query = "SELECT COUNT(*) AS total FROM pessoa WHERE cpf = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cpf);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				int total = resultado.getInt("total");
				return total > 0;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao verificar a duplicidade do CPF: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public boolean excluirPessoa(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean excluiu = false;
		String query = "DELETE FROM pessoa WHERE idpessoa = " + id;
		try {
			if (stmt.executeUpdate(query) == 1) {
				excluiu = true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao excluir pessoa");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return excluiu;
	}

	public ArrayList<Pessoa> consultarTodasPessoas() {

		ArrayList<Pessoa> pessoas = new ArrayList<>();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;
		String query = " SELECT * FROM pessoa";

		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				Pessoa pessoa = new Pessoa();

				pessoa.setNome(resultado.getString("NOME"));
				pessoa.setDataNascimento(resultado.getDate("DATA_NASCIMENTO").toLocalDate());
				pessoa.setSexo(resultado.getString("SEXO"));
				pessoa.setTipo(resultado.getString("tipo_pessoa"));
				pessoas.add(pessoa);
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar consultar todas as Pessoas");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pessoas;
	}

}
