package br.com.cacomp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.cacomp.conexao.Conexao;
import br.com.cacomp.domain.Administradores;
import br.com.cacomp.domain.Alunos;

public class AlunosDAO {
	
	public void salvar(Alunos aln) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Alunos ");
		sql.append("(matricula, nome)");
		sql.append("VALUES (?,?)");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setInt(1, aln.getMatricula());
		comando.setString(2, aln.getNome());
		comando.executeUpdate();
	}
	
	public void excluir(Alunos aln) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM Alunos ");
		sql.append("WHERE matricula = ? ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, aln.getMatricula());
		comando.executeUpdate();
	}

	public void editar(Alunos aln) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE Alunos ");
		sql.append("SET nome = ? ");
		sql.append("WHERE matricula = ? ");

		Connection conexao = Conexao.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, aln.getMatricula());
		comando.setString(2, aln.getNome());
		comando.executeUpdate();
	}
	
	public ArrayList<Alunos> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT matricula, nome ");
		sql.append("FROM Alunos ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		ArrayList<Alunos> retorno = new ArrayList<Alunos>();

		while (resultado.next()) {
			Alunos aln = new Alunos();
			aln.setMatricula(resultado.getInt("matricula"));
			aln.setNome(resultado.getString("nome"));

			retorno.add(aln);
		}

		return retorno;
	}

	public Alunos buscaPorCodigo(Alunos aln) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT matricula, nome ");
		sql.append("FROM Alunos ");
		sql.append("WHERE matricula = ? ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, aln.getMatricula());

		ResultSet resultado = comando.executeQuery();
		Alunos retorno = null;

		if (resultado.next()) {
			retorno = new Alunos();
			retorno.setMatricula(resultado.getInt("matricula"));
			retorno.setNome(resultado.getString("nome"));
		}

		return retorno;
	}
	
	public Alunos buscaADMS(Administradores adm) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT matricula");
		sql.append("FROM Alunos ");
		sql.append("WHERE nome = ? ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, adm.getNome());

		ResultSet resultado = comando.executeQuery();
		Alunos retorno = new Alunos();
		
			retorno.setMatricula(resultado.getInt("matricula"));
			retorno.setNome(resultado.getString("nome"));

		return retorno;
	}
}