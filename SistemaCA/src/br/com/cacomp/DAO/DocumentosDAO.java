package br.com.cacomp.DAO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.cacomp.conexao.Conexao;
import br.com.cacomp.domain.Documentos;
import br.com.cacomp.domain.Alunos;

public class DocumentosDAO {

	public void salvar(Documentos doc) throws SQLException, IOException {
		System.out.println("entrou em salvar");
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO Documentos ");
		sql.append("(identidade) , (requisicao) , (comprovante)");
		sql.append("VALUES (?) , (?) , (?)");
		Connection conexao = Conexao.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		/*FileInputStream io1 = new FileInputStream(doc.getIdentidade());
		FileInputStream io2 = new FileInputStream(doc.getRequisicao());
		FileInputStream io3 = new FileInputStream(doc.getComprovante());
		
		System.out.println("identidade: "+ );
		System.out.println("requisicao: "+ f2.getAbsolutePath());
		System.out.println("comprovante: "+ f3.getAbsolutePath());*/
		
		/*comando.setBinaryStream(2, (InputStream)io1);
		comando.setBinaryStream(3, (InputStream)io2);
		comando.setBinaryStream(4, (InputStream)io3);*/
		comando.executeUpdate();
	}

	public void excluir(Documentos doc) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM Documentos ");
		sql.append("WHERE idDocumentos = ? ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, doc.getIdDocumentos());
		comando.executeUpdate();
	}
	public static byte[] getBytesFromInputStream(InputStream is) throws IOException
	{
	    try (ByteArrayOutputStream os = new ByteArrayOutputStream();)
	    {
	        byte[] buffer = new byte[0xFFFF];

	        for (int len; (len = is.read(buffer)) != -1;)
	            os.write(buffer, 0, len);

	        os.flush();

	        return os.toByteArray();
	    }
	}
}
