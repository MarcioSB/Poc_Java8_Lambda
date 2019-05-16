package br.com.marcio.model.principal;

import java.util.ArrayList;
import java.util.List;

import br.com.marcio.model.enums.SexoEnum;
import br.com.marcio.model.pojo.Pessoa;

public class FactoryPessoa {

	public static List<Pessoa> getListPessoas(){
		List<Pessoa> pessoas = new ArrayList<>();
		
		pessoas.add(new Pessoa("Marcio", 38, SexoEnum.MASCULINO));
		pessoas.add(new Pessoa("Patricia", 39, SexoEnum.FEMININO));
		pessoas.add(new Pessoa("Gabriel Henrique", 7, SexoEnum.MASCULINO));
		pessoas.add(new Pessoa("Maria Clara ", 5, SexoEnum.FEMININO));
		
		return pessoas;
	}
}
