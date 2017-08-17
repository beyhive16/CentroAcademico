package br.com.cacomp.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import br.com.cacomp.conexao.Conexao;
import br.com.cacomp.domain.Alunos;

public class InscricaoDAO {
	
	
	public void addInscricao(Alunos aluno, String selecao) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Inscritos ");
		sql.append("(idInscrito), (Curso)");
		sql.append("VALUES (?), (?)");
		Alunos aln = new Alunos();
		AlunosDAO alnDAO = new AlunosDAO();
		Connection conexao = Conexao.conectar();
		aln = alnDAO.buscaPorCodigo(aluno);
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setInt(1, aln.getMatricula());
		comando.setInt(2, Integer.parseInt(selecao));
		comando.executeUpdate();
	}	
}
