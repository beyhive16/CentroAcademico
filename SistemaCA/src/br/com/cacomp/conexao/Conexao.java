package br.com.cacomp.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String USUARIO = "root";
	private static final String SENHA = "12345";
	private static final String URL = "jdbc:mysql://localhost:3306/sistemaCA";

	public static Connection conectar() throws SQLException{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	public static void main(String[] args) {
		try {
			Connection conexao = Conexao.conectar();
			System.out.println("conectado com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("conexao falhou");
		}
	}
}
