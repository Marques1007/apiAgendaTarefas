package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class ConnectionFactory {
	
	@Value ("${spring.datasource.url}")
	private String url;
	
	@Value ("${spring.datasource.username}")
	private String username;
	
	@Value ("${spring.datasource.password}")
	private String password;
		
	
	/*
	 * metodo apra realizar a conexao com o banco de dadados
	 * do PostgreSQL e retornar esta conexao para as 
	 * classes de repositorios do sistema
	 */
	public Connection getConnection() {
		try {
			//abrindo e retornado a conexao com o banco de dados
			return DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			e.printStackTrace(); //imprimri um log de erro
			return null;
		}
	}

}
