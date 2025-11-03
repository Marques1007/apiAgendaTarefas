package br.com.cotiinformatica.controllers;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.requests.TarefaPostRequest;
import br.com.cotiinformatica.dtos.requests.TarefaPutRequest;
import br.com.cotiinformatica.entities.Categoria;
import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.enums.Prioridade;
import br.com.cotiinformatica.repositories.TarefaRepository;

@RestController
@RequestMapping("/api/v1/tarefas")
public class TarefaController {
	
	//atributo
//	private TarefaRepository tarefaRepository = new TarefaRepository();
	@Autowired
	private TarefaRepository tarefaRepository;
	 
	
	/*
	 * metodo para cadastrar uma tarefa na API
	 */
	@PostMapping
	public ResponseEntity<?> post(@RequestBody TarefaPostRequest request) {
		
		//capturar os dados da requisição
		var tarefa = new Tarefa();
		
		tarefa.setId(UUID.randomUUID()); //gerando um ID	
		tarefa.setNome(request.getNomeTarefa()); // capturando o nome da tarefa no angular
		tarefa.setData(LocalDate.parse(request.getDataTarefa())); // capturando a data da tarefa
		tarefa.setPrioridade(Prioridade.valueOf(request.getPrioridadeTarefa())); //prioridade
		tarefa.setFinalizado(false); // definindo o campo fainalizado como 'false'
		
		tarefa.setCategoria(new Categoria());	// instanciando a categoria da tarefa
		tarefa.getCategoria().setId(UUID.fromString(request.getIdCategoria())); //
		
		//salvar a tarefa no banco de dados
		tarefaRepository.insert(tarefa);
		
		return ResponseEntity.ok ("Tarefa cadastrada com sucesso!");
	}
	
	/*
	 * metodo para atualizar uma tarefa na API.
	 */
	@PutMapping
	public ResponseEntity<?> put (@RequestBody TarefaPutRequest request) {
		
		//capturar os dados da requisição
		var tarefa = new Tarefa();
		
		tarefa.setId(UUID.fromString(request.getIdTarefa())); //capturando o id da tarefa	
		tarefa.setNome(request.getNomeTarefa()); // capturando o nome da tarefa no angular
		tarefa.setData(LocalDate.parse(request.getDataTarefa())); // capturando a data da tarefa
		tarefa.setPrioridade(Prioridade.valueOf(request.getPrioridadeTarefa())); //prioridade
		tarefa.setFinalizado(request.getFinalizado()); // definindo o campo fainalizado como 'false'
		
		tarefa.setCategoria(new Categoria());	// instanciando a categoria da tarefa
		tarefa.getCategoria().setId(UUID.fromString(request.getIdCategoria())); //

		//atualizar a rafefa no banco de dados
		tarefaRepository.update(tarefa);
		
		
		
		
		return ResponseEntity.ok("sucesso!!!");
	}
	/*
	 * metodo para excluir uma tarefa na API
	 */
	@DeleteMapping  ("{id}")
	public ResponseEntity<?> delete(@PathVariable UUID id){
		
		//excluindo a tarefa no banco de dados
		if(tarefaRepository.delete(id)) {
			return ResponseEntity.ok("Tarefa excluida com sucesso!");
			
		}
		else {
            //HTTP 404 (nao encontrado)
			return ResponseEntity.notFound().build(); 
  		}
	}
	
	/*
	 * metodo para consultar as categorias
	 */
	@GetMapping
	public ResponseEntity<?> getAll() {
		
		//consultar todas as tarefas no banco de dados
		var tarefas = tarefaRepository.findAll();
		
		//retornar os dados obtidos no banco
		return ResponseEntity.ok(tarefas);
	}
	

/*
 * metodo para consultar 1 tarefa atraves do ID
 */
@GetMapping ("{id}")
public ResponseEntity<?> getById(@PathVariable UUID id) {
	
	//consultar 1 tarefa no banco de dados atraves do ID
	var tarefa = tarefaRepository.findById(id);
	
	//verificar se alguma tarefa foi encontrada
	if (tarefa != null) {
		//retornar os dados da tarefa
		return ResponseEntity.ok(tarefa);
	}
	else {
        //HTTP 404 (nao encontrado)
		return ResponseEntity.notFound().build(); 
	}
	
	
								  }
}
