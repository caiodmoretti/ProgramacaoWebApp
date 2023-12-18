package br.edu.iff.PackNow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iff.PackNow.model.Morador;
@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {

}
