package br.edu.iff.PackNow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.iff.PackNow.model.Endereco;
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	@Query("SELECT e FROM Endereco e WHERE e.numero = :numero AND e.bloco = :bloco")
	Endereco buscarPeloNumeroEBloco(@Param("numero") String numero, @Param("bloco") String bloco);
	@Query("SELECT e FROM Endereco e WHERE e.id = :id")
	Endereco buscarPeloId(@Param("id") Long id);

	/*
	@Query(value="SELECT * FROM ENDERECO WHERE NUMERO = ?1 AND BLOCO = ?2", nativeQuery = true)
	Endereco buscarPeloNumeroEBloco(String numero, String bloco);
	
	@Query(value="SELECT * FROM ENDERECO WHERE ID = ?1", nativeQuery = true)
	Endereco BuscarPeloId(Long id);*/
}
