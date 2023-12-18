package br.edu.iff.PackNow.model;

import java.io.Serializable;

public abstract class UsuarioAbstract implements UsuarioInterface {
	
	private String nome;
	private String telefone;
	private String cpf;
	
	public UsuarioAbstract(String nome, String telefone, String cpf) {
		this.setNome(nome);
		this.setTelefone(telefone);
		this.setCpf(cpf);
	}
	
	public final void setNome(String nome) {
		if(nome.trim().isEmpty() || nome == null) {
			throw new IllegalArgumentException("Nome inválido.");
		}
		this.nome = nome;
	}
	public final void setTelefone(String telefone) {
		if(telefone.trim().isEmpty() || telefone == null) {
			throw new IllegalArgumentException("Telefone inválido.");
		}
		this.telefone = telefone;		
	}
	
	public final void setCpf(String cpf) {
		if(cpf.trim().isEmpty() || cpf == null) {
			throw new IllegalArgumentException("CPFinválido.");
		}
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCpf() {
		return cpf;
	}
	
	

}
