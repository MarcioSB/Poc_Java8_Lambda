package br.com.marcio.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import br.com.marcio.enums.SexoEnum;
import br.com.marcio.pojo.Pessoa;
import br.com.marcio.pojo.Usuario;

public class Java8 {
	
	public static void main(String[] args) {
		impressaoListPessoas();
		validaInterfaceFuncional();
		composicaoConsumer();
		removeIf();
		ordenandoComComparator();
		ordenandoComComparatorCrescente();
		ordenandoComComparatorAutoBoxing();
		ordenandoComComparatorIdadeNome();
		referenciaMetodoInstancia();
		referenciaMetodoArgumentos();
		referenciaConstrutoresUmArgumento();
		referenciaConstrutoresDoisArgumentos();
	}

	public static void impressaoListPessoas() {
		System.out.println("Imprime todos os nomes com suas idades respectivas.");
		List<Pessoa> listPessoa = FactoryPessoa.getListPessoas();
		listPessoa.forEach(u -> System.out.println("Nome: " + u.getNome() +" e possui idade de " + u.getIdade()));
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
	
	public static void ordenandoComComparatorCrescente() {
		System.out.println("Ordenação comparator");
		List<Pessoa> listPessoa = FactoryPessoa.getListPessoas();
		listPessoa.sort(Comparator.comparing(Pessoa::getNome).reversed());
		listPessoa.forEach(u -> {System.out.println("Nome: " + u.getNome() +" e possui idade de " + u.getIdade());});
	}
	
	public static void ordenandoComComparatorAutoBoxing() {
		System.out.println("Ordenação comparator autoboxing com idade.");
		List<Pessoa> listPessoa = FactoryPessoa.getListPessoas();
		Function<Pessoa, Integer> idades = p -> p.getIdade();
		listPessoa.sort(Comparator.comparing(idades));
		listPessoa.forEach(u -> {System.out.println("Nome: " + u.getNome() +" e possui idade de " + u.getIdade());});
	}
	
	public static void ordenandoComComparatorIdadeNome() {
		System.out.println("Ordenação comparator composto por idade e caso não haja idade nome.");
		List<Pessoa> listPessoa = FactoryPessoa.getListPessoas();
		listPessoa.sort(Comparator.comparingInt(Pessoa::getIdade).thenComparing(Pessoa::getNome));
		listPessoa.forEach(u -> {System.out.println("Nome: " + u.getNome() +" e possui idade de " + u.getIdade());});
	}
	
	public static void referenciaMetodoInstancia() {
		Pessoa pessoa = new Pessoa("Mauro Silva", 30, SexoEnum.MASCULINO);
		Runnable runable = pessoa::ativaCadastro; 
		runable.run();
		System.out.println("Pessoa " + pessoa.getNome() + " com o cadastro em situação " + (pessoa.isCadastroAtivo() ? "ativa" : "desativada") + ".");
	}
	
	public static void referenciaMetodoArgumentos() {
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("Mauro Silva", 30, SexoEnum.MASCULINO));
		pessoas.add(new Pessoa("Daniela Silva", 35, SexoEnum.FEMININO));
		pessoas.forEach(System.out::println);		
	}
	
	public static void referenciaConstrutoresUmArgumento() {
		Function<String, Usuario> criaUsuario = Usuario::new;
		Usuario user = criaUsuario.apply("Administrador");
		System.out.println("Usuario de nome " + user.getNome());
	}
	
	public static void referenciaConstrutoresDoisArgumentos() {
		BiFunction<String, String, Usuario> criaUsuario = Usuario::new;
		Usuario user = criaUsuario.apply("Administrador", "#1234567");
		System.out.println("Usuario de nome " + user.getNome() + " e sua senha é " + user.getSenha());
	}
}
