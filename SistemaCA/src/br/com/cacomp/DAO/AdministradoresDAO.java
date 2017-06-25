package br.com.cacomp.DAO;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.midi.Soundbank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.cacomp.conexao.Conexao;
import br.com.cacomp.domain.Administradores;

public class AdministradoresDAO {
	public void salvar(Administradores adm) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Administradores ");
		sql.append("(nome)");
		sql.append("VALUES (?)");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, adm.getNome());
		comando.executeUpdate();
	}

	public void excluir(Administradores adm) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM Administradores ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, adm.getCodigo());
		comando.executeUpdate();
	}

	public void editar(Administradores adm) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE Administradores ");
		sql.append("SET nome = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, adm.getNome());
		comando.setInt(2, adm.getCodigo());
		comando.executeUpdate();
	}

	public ArrayList<Administradores> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome ");
		sql.append("FROM Administradores ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		ArrayList<Administradores> retorno = new ArrayList<Administradores>();

		while (resultado.next()) {
			Administradores adm = new Administradores();
			adm.setCodigo(resultado.getInt("codigo"));
			adm.setNome(resultado.getString("nome"));

			retorno.add(adm);
		}

		return retorno;
	}

	public Administradores buscaPorCodigo(Administradores adm) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome ");
		sql.append("FROM Administradores ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, adm.getCodigo());

		ResultSet resultado = comando.executeQuery();
		Administradores retorno = null;

		if (resultado.next()) {
			retorno = new Administradores();
			retorno.setCodigo(resultado.getInt("codigo"));
			retorno.setNome(resultado.getString("nome"));
		}

		return retorno;
	}

	public static void main(String[] args) {
		Administradores adm1 = new Administradores();
		Administradores adm2 = new Administradores();
		adm1.setNome("Raquel Batista de Melo");
		adm2.setNome("Abdias Viana dos Santos");
		adm1.setCodigo(3);
		adm2.setCodigo(4);

		AdministradoresDAO admDAO = new AdministradoresDAO();
		try {
			ArrayList<Administradores> lista = admDAO.listar();
			for (Administradores adm : lista) {
				System.out.println("Resultado: " + adm.getNome());
			}
		} catch (Exception e) {
			System.out.println("erro");
		}

	}
}
