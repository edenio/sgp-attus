package br.com.attus.sgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attus.sgp.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
