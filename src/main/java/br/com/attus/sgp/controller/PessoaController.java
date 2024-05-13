package br.com.attus.sgp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attus.sgp.entity.Pessoa;
import br.com.attus.sgp.repository.PessoaRepository;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {
	
	    
	    @Autowired
	    private PessoaRepository repository;
	    
	    @GetMapping(value = "/{id}")
	    public ResponseEntity<Pessoa> consultaPorId(@PathVariable Long id){
	        return ResponseEntity.ok(repository.findById(id).get());
	    }
	    
	    @PostMapping("/salvar")
	    public ResponseEntity<Pessoa> salvarPessoa(@RequestBody Pessoa pessoa) {
	        Pessoa pessoaSalva = repository.save(pessoa);
	        return ResponseEntity.ok(pessoaSalva);
	    }
	}
