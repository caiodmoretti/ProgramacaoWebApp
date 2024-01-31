package br.edu.iff.PackNow.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class Pessoa implements Serializable {
	protected static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Não pode ser em branco ou nulo")
	@Column(name = "CPF", unique = true, length = 11)
	private String cpf;
	
	@Size(min = 1, max = 60, message = "Tem que ter entre 1 e 60 caractéres")
	@Column(length = 60)
	private String nome;

	@Column(length = 11)	
	private String telefone;


	public Pessoa(String nome, String telefone, String cpf) {
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setCpf(cpf);
		
	}

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		/*if(nome.trim().isEmpty() || nome == null) {
			throw new IllegalArgumentException("Nome inválido.");
		}*/
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		/*
		if(telefone.trim().isEmpty() || telefone == null) {
			throw new IllegalArgumentException("Telefone inválido.");
		}*/
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		/*
		if(cpf.trim().isEmpty() || cpf == null) {
			throw new IllegalArgumentException("CPF inválido.");
		}*/
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
