package br.com.marcio.model.pojo;

import java.io.Serializable;
import java.util.List;

import br.com.marcio.model.enums.SexoEnum;

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private int idade;
	private String profissao;
	private Endereco endereco;
	private List<Telefone> telefoneContato;
	private SexoEnum sexo;

	public Pessoa(String nome, int idade, SexoEnum sexo) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}

	public Pessoa(String nome, int idade, String profissao) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.profissao = profissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Telefone> getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(List<Telefone> telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}
}
