package br.edu.iff.PackNow.repository;

import org.springframework.stereotype.Repository;

import br.edu.iff.PackNow.model.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
