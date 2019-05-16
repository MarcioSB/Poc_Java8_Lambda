package br.com.marcio.model.principal;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import br.com.marcio.model.enums.GenreEnum;
import br.com.marcio.model.pojo.Person;

public class Main {
	
	public static void main(String[] args) {
		printListPerson();
		validInterfaceFuncional();
		composicaoConsumer();
		removeIf();
		ordenandoComComparator();
		ordenandoComComparatorAutoBoxing();
	}

	public static void printListPerson() {
		printDescription("Imprime todos os nomes com suas idades respectivas.");
		List<Person> listPessoa = FactoryPerson.getListPessoas();
		listPessoa.forEach(u -> {System.out.println("Nome: " + u.getName() +" e possui idade de " + u.getAge());});
	}
	
	public static void validInterfaceFuncional() {
		printDescription("Valida se o campo nome foi preenchido em todas as pessoas.");
		List<Person> listPessoa = FactoryPerson.getListPessoas();
		listPessoa.add(new Person(null, 56, GenreEnum.MASCULINO));
		IValidPerson valida = new ValidPerson();
		listPessoa.forEach(p -> valida.valid(p));
	}
	
	public static void composicaoConsumer() {
		printDescription("Consumer compostos");
		List<Person> listPessoa = FactoryPerson.getListPessoas();
		listPessoa.add(new Person(null, 56, GenreEnum.MASCULINO));
		IValidPerson valida = new ValidPerson();
		listPessoa.forEach(p -> valida.valid(p));
		Consumer<Person> consumerInsertNome = p ->  {
			if(p.getName() == null || p.getName().isEmpty()) {
				p.setName("Pessoa sem nome, inserido nome dinamicamente.");
			}
		};
		Consumer<Person> consumerValida = p -> valida.valid(p);
		listPessoa.forEach(consumerInsertNome.andThen(consumerValida));
		listPessoa.forEach(u -> {System.out.println("Nome: " + u.getName() +" e possui idade de " + u.getAge());});
	}
	
	public static void removeIf() {
		printDescription("Remove pessoas sem nome");
		List<Person> listPessoa = FactoryPerson.getListPessoas();
		listPessoa.add(new Person(null, 56, GenreEnum.MASCULINO));
		listPessoa.removeIf(p -> p.getName() == null || p.getName().isEmpty());
		listPessoa.forEach(u -> {System.out.println("Nome: " + u.getName() +" e possui idade de " + u.getAge());});
	}	
	
	public static void ordenandoComComparator() {
		printDescription("Ordenação comparator");
		List<Person> listPessoa = FactoryPerson.getListPessoas();
		listPessoa.sort(Comparator.comparing(p -> p.getName()));
		listPessoa.forEach(u -> {System.out.println("Nome: " + u.getName() +" e possui idade de " + u.getAge());});
	}
	
	public static void ordenandoComComparatorAutoBoxing() {
		printDescription("Ordenação comparator autoboxing com idade.");
		List<Person> listPessoa = FactoryPerson.getListPessoas();
		Function<Person, Integer> idades = p -> p.getAge();
		listPessoa.sort(Comparator.comparing(idades));
		listPessoa.forEach(u -> {System.out.println("Nome: " + u.getName() +" e possui idade de " + u.getAge());});
	}
	
	private static void printDescription(String msg) {
		System.out.println(" ");
		System.out.println(msg);
	}
}
