package br.com.attus.sgp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attus.sgp.entity.Endereco;
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
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Pessoa> atualizarPessoaEEndereco(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {
	        Optional<Pessoa> pessoaOptional = repository.findById(id);
	        
	        if (pessoaOptional.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }
	        
	        Pessoa pessoaExistente = pessoaOptional.get();
	        pessoaExistente.setNomeCompleto(pessoaAtualizada.getNomeCompleto());
	        pessoaExistente.setDataNascimento(pessoaAtualizada.getDataNascimento());
	        
	        // Atualizar endereço principal
	        Endereco enderecoAtualizado = pessoaAtualizada.getEnderecoPrincipal();
	        if (enderecoAtualizado != null) {
	            Endereco enderecoExistente = pessoaExistente.getEnderecoPrincipal();
	            enderecoExistente.setLogradouro(enderecoAtualizado.getLogradouro());
	            enderecoExistente.setCep(enderecoAtualizado.getCep());
	            enderecoExistente.setNumero(enderecoAtualizado.getNumero());
	            enderecoExistente.setCidade(enderecoAtualizado.getCidade());
	            enderecoExistente.setEstado(enderecoAtualizado.getEstado());
	            
	            // Adicionar endereço antigo na lista de endereços se existir
	            if (enderecoExistente != null) {
	                pessoaExistente.getEnderecos().add(enderecoExistente);
	            }
	        }
	        
	        Pessoa pessoaAtualizadaSalva = repository.save(pessoaExistente);
	        
	        return ResponseEntity.ok(pessoaAtualizadaSalva);
	    }
	    
	    @PutMapping("/{id}/endereco-principal/{enderecoId}")
	    public ResponseEntity<Pessoa> definirEnderecoPrincipal(@PathVariable Long id, @PathVariable Long enderecoId) {
	        Optional<Pessoa> pessoaOptional = repository.findById(id);
	        
	        if (pessoaOptional.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }
	        
	        Pessoa pessoa = pessoaOptional.get();
	        
	        // Procurar o endereço pelo ID na lista de endereços da pessoa
	        Optional<Endereco> enderecoOptional = pessoa.getEnderecos().stream()
	                .filter(endereco -> endereco.getId().equals(enderecoId))
	                .findFirst();
	        
	        if (enderecoOptional.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }
	        
	        Endereco endereco = enderecoOptional.get();
	        
	        // Definir o endereço como endereço principal da pessoa
	        pessoa.setEnderecoPrincipal(endereco);
	        
	        repository.save(pessoa);
	        
	        return ResponseEntity.ok(pessoa);
	    }


	    
	}
