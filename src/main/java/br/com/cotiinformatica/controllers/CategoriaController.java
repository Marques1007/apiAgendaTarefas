package br.com.cotiinformatica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.repositories.CategoriaRepository;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

	// atributo
//	private CategoriaRepository categoriaRepository = new CategoriaRepository();
	@Autowired
	private CategoriaRepository categoriaRepository;

	/*
	 * metodo para consultar as categorias
	 */
	@GetMapping
	public ResponseEntity<?> getAll() {

		try {

			// executar a consulta de categorias e obter a lista
			var lista = categoriaRepository.findAll();

			// HTTP 200 - ok
			return ResponseEntity.status(200).body(lista);
		} catch (Exception e) {
			// HTTP 500 - Internal server error
			return ResponseEntity.status(500).body(e.getMessage());

		}
	}

}
