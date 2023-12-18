package br.edu.iff.PackNow.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Encomenda implements EncomendaInterface {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Funcionario funcionarioEntrada;
	private Morador moradorRetirada;
	private Endereco enderecoEntrega;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private String nomeEntregador;
	private String telefoneEntregador;
	
	public Encomenda(Funcionario funcionario, Endereco enderecoEntrega, LocalDate dataEntrada, String nomeEntregador, String telefoneEntregador) {
		this.setFuncionario(funcionario);
		this.setEndereco(enderecoEntrega);
		this.dataEntrada = LocalDate.now();
		this.setNomeEntregador(nomeEntregador);
		this.setTelefoneEntregador(telefoneEntregador);
	}
	/**
	 * @param the funcionarioEntrada to set
	 */
	public final void setFuncionario(Funcionario funcionario) {
		if(funcionario == null) {
			throw new IllegalArgumentException("Funcionário não pode ser nulo.");
		}
		this.funcionarioEntrada = funcionario;
	}
	/**
	 * @param the enderecoEntrega to set
	 */
	public final void setEndereco(Endereco endereco) {
		if(endereco == null) {
			throw new IllegalArgumentException("Endereço não pode ser nulo.");
		}
		this.enderecoEntrega = endereco;
	}
	/**
	 * @param the nomeEntregador to set
	 */
	public final void setNomeEntregador(String nomeEntregador) {
		if(nomeEntregador.trim().isEmpty() || nomeEntregador == null) {
			throw new IllegalArgumentException("Nome de entregador inválido.");
		}
		this.nomeEntregador = nomeEntregador;		
	}
	/**
	 * @param the telefoneEntregador to set
	 */
	public final void setTelefoneEntregador(String telefoneEntregador) {
		if(telefoneEntregador.trim().isEmpty() || telefoneEntregador == null) {
			throw new IllegalArgumentException("Telefone de entregador inválido.");
		}
		this.telefoneEntregador = telefoneEntregador;		
	}
	/**
	 * @param the dataSaida to set
	 */
	public void registrarRetirada() {
		this.dataSaida = LocalDate.now();
	}
	/**
	 * @return the funcionarioEntrada
	 */
	public Funcionario getFuncionarioEntrada() {
		return this.funcionarioEntrada;
	}
	/**
	 * @return the moradorRetirada
	 */
	public Morador getMoradorRetirada() {
		return this.moradorRetirada;
	}
	/**
	 * @return the enderecoRetirada
	 */
	public Endereco getEnderecoEntrega() {
		return this.enderecoEntrega;
	}
	/**
	 * @return the dataEntrada
	 */
	public LocalDate getDataEntrada() {

		return this.dataEntrada;
	}
	/**
	 * @return the dataSaida
	 */
	public LocalDate getDataSaida() {
		if(this.dataEntrada == null) {
			throw new IllegalStateException("Encomenda ainda não foi retirada");
		}
		return this.dataSaida;
	}
	/**
	 * @return the nomeEntregador
	 */
	public String getNomeEntregador() {
		return this.nomeEntregador;
	}
	/**
	 * @return the telefoneEntregador
	 */
	public String getTelefoneEntregador() {
		return this.telefoneEntregador;
	}

	
}
