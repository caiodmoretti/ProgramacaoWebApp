package br.edu.iff.PackNow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iff.PackNow.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
