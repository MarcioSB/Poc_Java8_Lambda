package br.com.marcio.model.principal;

import br.com.marcio.model.pojo.Person;

public class ValidPerson implements IValidPerson {

	@Override
	public void valid(Person person) {
		this.validPersonUnnamed(person);
	}
	
	public void validPersonUnnamed(Person person){
		if(person.getName() == null || person.getName().isEmpty()) {
			System.out.println("A lista possui uma Pessoa sem nome informado.");
		}
	}
}
