package br.com.fecaf.biblioteca.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySql {
	
	public Connection getConnection () throws ClassNotFoundException, SQLException {
		//Apontamento para o Driver de conexão para o MYSQL
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Estabelece a conexão com o MYSQL, passando referencias do banco, usuário e senha de autenticação
		Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_biblioteca_fecaf_ads4na?userTimezone=true&serverTimezone=UTC", "aluno", "toor");
	
		//retornando a conexao com o MYSQL
		return conex;
	}

}
