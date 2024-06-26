package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Pais;

public class PaisRepository {

	public Pais salvar(Pais novoPais) {

		String query = "INSERT INTO pais (nome, sigla) VALUES (?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			pstmt.setString(1, novoPais.getNome());
			pstmt.setString(2, novoPais.getSigla());
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();
			if (resultado.next()) {
				novoPais.setId(resultado.getInt(1));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método salvar Pais!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return novoPais;
	}

	public Pais consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;
		Pais pais = new Pais();
		String query = " SELECT * FROM pais WHERE idpais = " + id;

		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				pais.setId(id);
				pais.setNome(resultado.getString("NOME"));
				pais.setSigla(resultado.getString("SIGLA"));

			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar consultar PAIS com id (" + id + ")");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pais;
	}

	public ArrayList<Pais> consultarTodosPais() {

		ArrayList<Pais> paises = new ArrayList<>();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;
		String query = " SELECT * FROM pais";

		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				Pais pais = new Pais();

				pais.setId(resultado.getInt("idpais"));
				pais.setNome(resultado.getString("NOME"));
				pais.setSigla(resultado.getString("sigla"));
				paises.add(pais);
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar consultar todos PAISES");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return paises;
	}
}
