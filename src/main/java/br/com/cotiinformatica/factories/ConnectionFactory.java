package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	/*
	 * metodo apra realizar a conexao com o banco de dadados
	 * do PostgreSQL e retornar esta conexao para as 
	 * classes de repositorios do sistema
	 */
	public Connection getConnection() {
		try {
			
			//variaveis para conexao com o MySQL
			var host = "jdbc:postgresql://localhost:5432/bd_agendatarefas";
			var user = "postgres";
			var pass = "coti";
			
			//abrindo e retornado a conexao com o banco de dados
			return DriverManager.getConnection(host, user, pass);
			
			
		}
		catch(Exception e) {
			e.printStackTrace(); //imprimri um log de erro
			return null;
		}
	}

}
