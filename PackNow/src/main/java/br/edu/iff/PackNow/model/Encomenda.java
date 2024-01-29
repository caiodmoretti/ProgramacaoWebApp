package br.edu.iff.PackNow.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Encomenda  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@NotBlank(message = "Não pode ser branco ou nulo")
	@JoinColumn(name="fk_funcionarioEntrada")
	private Funcionario funcionarioEntrada;
	
	@ManyToOne
	@JoinColumn(name="fk_moradorRetirada")
	private Morador moradorRetirada;
	
	@ManyToOne
	@JoinColumn(name="fk_endereco")
	private Endereco enderecoEntrega;
	
	@Temporal(TemporalType.DATE)
	@NotBlank(message = "Não pode ser em branco ou nulo")
	private LocalDate dataEntrada;
	
	@Temporal(TemporalType.DATE)
	private LocalDate dataSaida;
	
	private String nomeEntregador;
	
	private String telefoneEntregador;
	
	public Encomenda(Funcionario funcionario, Endereco enderecoEntrega, String nomeEntregador, String telefoneEntregador) {
		this.setFuncionario(funcionario);
		this.setEndereco(enderecoEntrega);
		this.dataEntrada = LocalDate.now();
		this.setNomeEntregador(nomeEntregador);
		this.setTelefoneEntregador(telefoneEntregador);
	}
	public Encomenda() {};
	/**
	 * @param the funcionarioEntrada to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		if(funcionario == null) {
			throw new IllegalArgumentException("Funcionário não pode ser nulo.");
		}
		this.funcionarioEntrada = funcionario;
	}
	/**
	 * @param the enderecoEntrega to set
	 */
	public void setEndereco(Endereco endereco) {
		if(endereco == null) {
			throw new IllegalArgumentException("Endereço não pode ser nulo.");
		}
		this.enderecoEntrega = endereco;
	}
	/**
	 * @param the nomeEntregador to set
	 */
	public void setNomeEntregador(String nomeEntregador) {
		if(nomeEntregador.trim().isEmpty() || nomeEntregador == null) {
			throw new IllegalArgumentException("Nome de entregador inválido.");
		}
		this.nomeEntregador = nomeEntregador;		
	}
	/**
	 * @param the telefoneEntregador to set
	 */
	public  void setTelefoneEntregador(String telefoneEntregador) {
		if(telefoneEntregador.trim().isEmpty() || telefoneEntregador == null) {
			throw new IllegalArgumentException("Telefone de entregador inválido.");
		}
		this.telefoneEntregador = telefoneEntregador;		
	}
	/**
	 * @param the dataSaida to set
	 */
	public void registrarRetirada(Morador morador) {
		this.dataSaida = LocalDate.now();
		this.moradorRetirada = morador;
	}
	/**
	 * @return the funcionarioEntrada
	 */
	public Funcionario getFuncionarioEntrada() {
		return this.funcionarioEntrada;
	}
	public void setMoradorRetirada(Morador moradorRetirada) {
		this.moradorRetirada = moradorRetirada;
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
	public Long getId() {
		return this.id;
	}
	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	
}
