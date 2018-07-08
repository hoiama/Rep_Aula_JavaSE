package br.com.hoiama.curriculos.java.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Java8 {

	public void getListaOrdenada() {

		List<String> lista = new ArrayList<>();

		lista.add("aluno100");
		lista.add("aluno1");
		lista.add("aluno20");

		
		
		// COMPARACAO DE OBJETOS
		
		ComparatorLength comparatorLength = new ComparatorLength();// comparador específico
		lista.sort(comparatorLength); // passando o comparador
		System.out.println("Ordenando lista class comparator:" + lista); // ordenação com base no comparador

		
		
		//criando 'comparator' anonimo direto para 'lista.sort'
		lista.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() < s2.length())
					return -1;
				if (s1.length() > s2.length())
					return 1;
				return 0;
			}
		});
		
		System.out.println("Comparador local anonimo: " + lista);

		
		
		//substituiçao 1: lambda para criar o 'comparator'
		lista.sort((s1, s2) -> {
			if (s1.length() < s2.length())	return -1;
			if (s1.length() > s2.length())	return 1;
			return 0;
		});
		
		System.out.println("Lambada na ordenação de listas: " + lista);
		
		
		
		//substituição 2: lambda + 'Integer.compare' com os retornos '+1, -1'
		lista.sort((s1, s2) ->  Integer.compare(s1.length(), s2.length()));
		System.out.println("Lambada na ordenação de listas: " + lista);

		
		
		// usando metodo estatico 'comparing' de Comparator
		lista.sort(Comparator.comparing(s -> s.length()));
		System.out.println(" Metodos estatico de Comparator : "+ lista);
		
		
		
		//Usando 'method reerence' ao invés de lambda (é um resumo de lambda)
		lista.sort(Comparator.comparing(String::length));
		System.out.println("Usando 'method reerence' : " + lista);
		
		
//		//Usando 'method reerence' ao invés de lambda (omitindo 'Comparator')
//		lista.sort(comparing(String::length));
//		System.out.println("Usando 'method reerence' : " + lista);
//		
		
		
		
		
		// USO DE FOREACH COM CONSUMER
		
		//Criado class Consumer externa
		forEachConsumer consumer = new forEachConsumer(); 
		lista.forEach(consumer); // iterando com base no consumer

		
		
		//Substituiao 1: Criando 'consumer' local anônimo
		Consumer consumer2 = new Consumer<String>() { // consumer local de classe anonima
			@Override
			public void accept(String t) {
				System.out.println("consumer Local anonimo: " + t);
			}
		};
		
		lista.forEach(consumer2); // usando consumer local anonimo
		

		
		// Substituiao 2: iterando e criando consumer anonimo ao mesmo tempo
		lista.forEach(new Consumer<String>() { 
			@Override
			public void accept(String t) {
				System.out.println("Consumer anonimo dentro do forEach: " + t);
			}
		});

		
		
		//Substituiao 3: Lambda: Criando consumer usando lambda
		Consumer<String> consumer3 = aluno1 -> System.out.println("consumer com lambda: " + aluno1);
		lista.forEach(consumer3); // usando consumer local com lambda
		
		
		
		
		//Substituiao 4: Lambda: iterando e criando consumer com lambdas
		lista.forEach((String s) -> { // Lambda apenas com parametro 'String s' do método 'accept'
			System.out.println("lambda: " + s);
		});

		
		
		//Substituiao 5: Lambda enxugado apenas com parametro 'aluno' do método 'accept'
		lista.forEach(aluno -> System.out.println("lambda enxugado: " + aluno));

	}
}
