package br.edu.iff.PackNow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iff.PackNow.model.Encomenda;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, Long> {

}
