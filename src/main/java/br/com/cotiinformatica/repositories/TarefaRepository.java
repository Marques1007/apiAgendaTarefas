package br.com.cotiinformatica.repositories;

import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.entities.Tarefa;

public class TarefaRepository {
	
	/*
	 * metodo para inserir uma tarefa no banco de dados
	 */
	public void insert(Tarefa tarefa) {
		//TODO implementar o cadastro da tarefa no banco de dados
		
	}
	/*
	 * metodo para atualizar uma tarefa no banco de dados
	 */
	public boolean update(Tarefa tarefa) {
		//TODO implementar a atualizacao da tarefa no banco de dados
			return false;
	}
	/* 
	 * metodo para excluir uma tarefa do banco de dados
	 */
	public boolean delete(UUID id) {
		//TODO implementar a exclusao da tarefa no banco de dados
		return false;
	}
	/*
	 * metodo para consultar todas as tarefas no banco de dados
	 */
	public List<Tarefa> findAll() {
		//TODO implementar a consulta das tarefas no banco de dados
		return null;
	}
}
	