package br.com.marcio.model.pojo;

import java.io.Serializable;

import br.com.marcio.model.enums.TipoContatoEnum;

public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String numero;
	private TipoContatoEnum tipoContato;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public TipoContatoEnum getTipoContato() {
		return tipoContato;
	}
	public void setTipoContato(TipoContatoEnum tipoContato) {
		this.tipoContato = tipoContato;
	}
}
