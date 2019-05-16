package br.com.marcio.model.pojo;

import java.io.Serializable;

import br.com.marcio.model.enums.TypeContactEnum;

public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String number;
	private TypeContactEnum tipoContato;
	
	public String getNumero() {
		return number;
	}
	public void setNumero(String numero) {
		this.number = numero;
	}
	public TypeContactEnum getTipoContato() {
		return tipoContato;
	}
	public void setTipoContato(TypeContactEnum tipoContato) {
		this.tipoContato = tipoContato;
	}
}
