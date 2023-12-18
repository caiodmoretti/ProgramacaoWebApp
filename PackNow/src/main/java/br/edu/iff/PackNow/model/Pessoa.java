package br.edu.iff.PackNow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String telefone;
	private String cpf;

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
		if(nome.trim().isEmpty() || nome == null) {
			throw new IllegalArgumentException("Nome inválido.");
		}
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if(telefone.trim().isEmpty() || telefone == null) {
			throw new IllegalArgumentException("Telefone inválido.");
		}
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf.trim().isEmpty() || cpf == null) {
			throw new IllegalArgumentException("CPF inválido.");
		}
		this.cpf = cpf;
	}
}
