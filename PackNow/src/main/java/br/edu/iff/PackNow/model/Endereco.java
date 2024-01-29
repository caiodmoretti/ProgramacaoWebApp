package br.edu.iff.PackNow.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Endereco implements  Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Não pode ser em branco ou nulo")
	private String numero;
	
	@NotBlank(message = "Não pode ser em branco ou nulo")
	private String bloco;

	@OneToMany(mappedBy = "endereco")
	private Set<Morador> moradores;
	
	public Endereco(String numero, String bloco) {
		this.setNumero(numero);
		this.setBloco(bloco);
		this.moradores = new HashSet<Morador>();
	};
	public Endereco() {
	}
	
	/**
	 * @param the numero to set
	 */
	public  void setNumero(String numero) {
		if(numero.trim().isEmpty() || numero == null) {
			throw new IllegalArgumentException("Numero inválido.");
		}
		this.numero = numero;
	};
	/**
	 * @param the bloco to set
	 */
	public  void setBloco(String bloco) {
		if(bloco.trim().isEmpty() || bloco == null) {
			throw new IllegalArgumentException("Numero inválido.");
		}
		this.bloco = bloco;
	};
	/**
	 * @param the morador to moradores
	 */
	public void adicionarMorador(Morador morador) {
		if(morador == null) {
			throw new IllegalArgumentException("Morador não pode ser nulo.");
		}
		this.moradores.add(morador);
		
	}
	/**
	 * @param remove the morador
	 */
	public void removerMorador(Morador morador) {
		if(morador == null) {
			throw new IllegalArgumentException("Morador não pode ser nulo.");
		}
		if(this.moradores.contains(morador)) {
			this.moradores.remove(morador);
		}
		else{
			throw new IllegalStateException("Morador não está associado a este endereço.");
		}
	}
	/**
	 * @return the iterator for moradores
	 */
	public Iterator<Morador> getMoradores(){
		return Collections.unmodifiableSet(this.moradores).iterator();
	}
	public String getNumero() {
		return numero;
	}
	public String getBloco() {
		return bloco;
	}
	public Long getId() {
		return id;
	}



}
