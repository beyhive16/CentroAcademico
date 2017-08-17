package br.com.cacomp.teste;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.cacomp.conexao.Conexao;
import br.com.cacomp.domain.Alunos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import br.com.cacomp.conexao.Conexao;
import br.com.cacomp.DAO.AlunosDAO;
import br.com.cacomp.conexao.Conexao;
import br.com.cacomp.domain.Alunos;

public class AlunosDAOteste {
	
	public void salvar() throws SQLException{
		Alunos aln1 = new Alunos();
		
		aln1.setMatricula(1041112);
		aln1.setNome("Sidiney Araújo");
		AlunosDAO alnDAO = new AlunosDAO();
		try {
			alnDAO.salvar(aln1);
		} catch (SQLException e) {
			System.out.println("falha na inserção");
			e.printStackTrace();
		}
	}
	@Test
	public void listar() throws SQLException{
		
		AlunosDAO alnDAO = new AlunosDAO();
		try {
			ArrayList<Alunos> lista = alnDAO.listar();
			
			for (Alunos a : lista){
				System.out.println("Resultado: "+a.getNome());
			}
		} catch (SQLException e) {
			System.out.println("falha na listagem");
			e.printStackTrace();
		}

	}
	
	public void excluir() throws SQLException {
		Alunos aln = new Alunos();
		AlunosDAO alnDAO = new AlunosDAO();
		
		aln.setMatricula(1053255);
		alnDAO.excluir(aln);
	}
	@Test
	public void editar() throws SQLException {
		Alunos aln = new Alunos();
		aln.setMatricula(1058382);
		aln.setNome("Jhon Wilker");
		try{
			AlunosDAO alnDAO = new AlunosDAO();
		    alnDAO.editar(aln);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
