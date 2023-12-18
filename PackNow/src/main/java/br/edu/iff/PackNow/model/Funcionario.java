package br.edu.iff.PackNow.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Funcionario extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;


	private String cargo;
		
	public Funcionario(String nome, String telefone, String cpf, String cargo) {
		super(nome, telefone, cpf);

		this.setCargo(cargo);	
	}
	public Funcionario(){
		super();
	};
	/**
	 * @param the cargo to set
	 */
	public void setCargo(String cargo) {
		if(cargo.trim().isEmpty() || cargo == null) {
			throw new IllegalArgumentException("Cargo inválido.");
		}
		this.cargo = cargo;
	}
	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	
}
