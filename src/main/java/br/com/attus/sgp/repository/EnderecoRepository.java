package br.com.attus.sgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attus.sgp.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
