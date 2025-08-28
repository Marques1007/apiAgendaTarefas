package br.com.cotiinformatica.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tarefas")
public class TarefaController {
	
	/*
	 * metodo para cadastrar uma tarefa na API
	 */
	@PostMapping
	public ResponseEntity<?> post() {
		return ResponseEntity.ok ("Sucesso!!");
	}
	
	/*
	 * metodo para atualizar uma tarefa na API.
	 */
	@PutMapping
	public ResponseEntity<?> put () {
		return ResponseEntity.ok("sucesso!!!");
	}
	/*
	 * metodo para excluir uma tarefa na API
	 */
	@DeleteMapping
	public ResponseEntity<?> delete(){
		return ResponseEntity.ok("Sucesso!!!!");
	}
	
	/*
	 * metodo para consultar as categorias
	 */
	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok("Sucesso!!!!!");
	}
	
}
