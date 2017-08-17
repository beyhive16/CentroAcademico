package br.com.cacomp.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import br.com.cacomp.DAO.AlunosDAO;
import br.com.cacomp.conexao.Conexao;
import br.com.cacomp.domain.Administradores;
import br.com.cacomp.domain.Alunos;

public class AdmsDAOteste {
	
	@Test
	public void salvar() throws SQLException {
		Administradores adm = new Administradores();
		adm.setCodigo(1046996);
		adm.setNome("Tamburete");
	StringBuilder sql = new StringBuilder();
	sql.append("INSERT INTO Administradores ");
	sql.append("(nome)");
	sql.append("VALUES (?)");

	Connection conexao = Conexao.conectar();
	PreparedStatement comando = conexao.prepareStatement(sql.toString());
	comando.setString(1, adm.getNome());
	salvarADMS(adm);
	comando.executeUpdate();
}
	@Test
public void salvarADMS(Administradores adm) throws SQLException {
	StringBuilder sql = new StringBuilder();
	sql.append("INSERT INTO usuarios ");
	sql.append("(login), (senha)");
	sql.append("VALUES (?), (?)");
	Alunos aln = new Alunos();
	//AlunosDAO alnDAO = new AlunosDAO();
	Connection conexao = Conexao.conectar();
	aln = buscaADMS(adm);
	PreparedStatement comando = conexao.prepareStatement(sql.toString());
	
	comando.setInt(1, aln.getMatricula());
	System.out.println("mat: "+aln.getMatricula());
	comando.setInt(2, aln.getMatricula());
	comando.executeUpdate();
}
@Test
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
		System.out.println("nome: "+retorno.getNome());
	return retorno;
}
}
