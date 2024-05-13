package br.com.attus.sgp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attus.sgp.entity.Pessoa;
import br.com.attus.sgp.repository.PessoaRepository;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {
	
	
	public class UsuarioController {
	    
	    @Autowired
	    private PessoaRepository repository;
	    
	    @GetMapping(value = "/{id}")
	    public ResponseEntity<Pessoa> consultaPorId(@PathVariable Long id){
	        return ResponseEntity.ok(repository.findById(id).get());
	    }
	}

}
