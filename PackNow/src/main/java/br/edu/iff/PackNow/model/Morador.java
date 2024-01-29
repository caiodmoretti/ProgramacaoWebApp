package br.edu.iff.PackNow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Morador extends Pessoa {
	@ManyToOne
	@JoinColumn(name = "endereco_id")	
	private Endereco endereco;
	
	public Morador(String nome, String telefone, String cpf) {
		super(nome, telefone, cpf);	
	}
	public Morador() {}
	
	
	
	

}
