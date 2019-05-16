package br.com.marcio.model.principal;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import br.com.marcio.model.enums.SexoEnum;
import br.com.marcio.model.pojo.Pessoa;

public class Java8 {
	
	public static void main(String[] args) {
		impressaoListPessoas();
		validaInterfaceFuncional();
		composicaoConsumer();
		removeIf();
		ordenandoComComparator();
		ordenandoComComparatorAutoBoxing();
	}

	public static void impressaoListPessoas() {
		System.out.println("Imprime todos os nomes com suas idades respectivas.");
		List<Pessoa> listPessoa = FactoryPessoa.getListPessoas();
		listPessoa.forEach(u -> {System.out.println("Nome: " + u.getNome() +" e possui idade de " + u.getIdade());});
	}
	
	public static void validaInterfaceFuncional() {
		System.out.println("Valida se o campo nome foi preenchido em todas as pessoas.");
		List<Pessoa> listPessoa = FactoryPessoa.getListPessoas();
		listPessoa.add(new Pessoa(null, 56, SexoEnum.MASCULINO));
		IValidaPessoa valida = new ValidaPessoa();
		listPessoa.forEach(p -> valida.valida(p));
	}
	
	public static void composicaoConsumer() {
		System.out.println("Consumer compostos");
		List<Pessoa> listPessoa = FactoryPessoa.getListPessoas();
		listPessoa.add(new Pessoa(null, 56, SexoEnum.MASCULINO));
		IValidaPessoa valida = new ValidaPessoa();
		listPessoa.forEach(p -> valida.valida(p));
		Consumer<Pessoa> consumerInsertNome = p ->  {
			if(p.getNome() == null || p.getNome().isEmpty()) {
				p.setNome("Pessoa sem nome, inserido nome dinamicamente.");
			}
		};
		Consumer<Pessoa> consumerValida = p -> valida.valida(p);
		listPessoa.forEach(consumerInsertNome.andThen(consumerValida));
		listPessoa.forEach(u -> {System.out.println("Nome: " + u.getNome() +" e possui idade de " + u.getIdade());});
	}
	
	public static void removeIf() {
		System.out.println("Remove pessoas sem nome");
		List<Pessoa> listPessoa = FactoryPessoa.getListPessoas();
		listPessoa.add(new Pessoa(null, 56, SexoEnum.MASCULINO));
		listPessoa.removeIf(p -> p.getNome() == null || p.getNome().isEmpty());
		listPessoa.forEach(u -> {System.out.println("Nome: " + u.getNome() +" e possui idade de " + u.getIdade());});
	}	
	
	public static void ordenandoComComparator() {
		System.out.println("Ordenação comparator");
		List<Pessoa> listPessoa = FactoryPessoa.getListPessoas();
		listPessoa.sort(Comparator.comparing(p -> p.getNome()));
		listPessoa.forEach(u -> {System.out.println("Nome: " + u.getNome() +" e possui idade de " + u.getIdade());});
	}
	
	public static void ordenandoComComparatorAutoBoxing() {
		System.out.println("Ordenação comparator autoboxing com idade.");
		List<Pessoa> listPessoa = FactoryPessoa.getListPessoas();
		Function<Pessoa, Integer> idades = p -> p.getIdade();
		listPessoa.sort(Comparator.comparing(idades));
		listPessoa.forEach(u -> {System.out.println("Nome: " + u.getNome() +" e possui idade de " + u.getIdade());});
	}
}
