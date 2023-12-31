package br.edu.iff.PackNow.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Morador extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_morador")
	private Long id;


	public Morador(String nome, String telefone, String cpf) {
		super(nome, telefone, cpf);	
	}
	public Morador() {};
	

}
