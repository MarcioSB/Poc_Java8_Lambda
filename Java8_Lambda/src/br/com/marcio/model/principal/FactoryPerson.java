package br.com.marcio.model.principal;

import java.util.ArrayList;
import java.util.List;

import br.com.marcio.model.enums.GenreEnum;
import br.com.marcio.model.pojo.Person;

public class FactoryPerson {

	public static List<Person> getListPessoas(){
		List<Person> pessoas = new ArrayList<>();
		
		pessoas.add(new Person("Marcos Souza", 29, GenreEnum.MASCULINO));
		pessoas.add(new Person("Luiza Clara", 25, GenreEnum.FEMININO));
		pessoas.add(new Person("Henrique", 7, GenreEnum.MASCULINO));
		pessoas.add(new Person("Daniela Alves", 5, GenreEnum.FEMININO));
		
		return pessoas;
	}
}
