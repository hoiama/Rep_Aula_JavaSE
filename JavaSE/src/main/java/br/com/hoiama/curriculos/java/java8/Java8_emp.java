package br.com.hoiama.curriculos.java.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.prefs.Preferences;

public class Java8_emp {

	private List<String> lista = new ArrayList<>();

	Java8_emp(){
		List<String> lista = new ArrayList<>();
		lista.add("tamanho02");
		lista.add("tamanho003");
		lista.add("tamanho0004");
		lista.add("tamanho00005");
		lista.add("tamanho000006");
		this.lista = lista;
	}

	////////////////////////// COMPARACAO / ORDENAÇÂO DE OBJETOS ///////////////////////////

	public void getListaOrdenada() {

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

		
		// Substituição 3: usando metodo estatico 'comparing' de Comparator que recebe uma "function".
		lista.sort(Comparator.comparing(string -> string.length()));
		System.out.println(" Metodos estatico de Comparator : "+ lista);

		
		//Usando 'method reerence' ao invés de lambda (é um resumo de lambda)
		lista.sort(Comparator.comparing(String::length));
		System.out.println("Usando 'method reerence' :: " + lista);

	}


	//////////////////////////// USO DE FOREACH COM CONSUMER ////////////////////////////

	public void getForeach(){

		//Criado class Consumer externa
		forEachConsumer consumer = new forEachConsumer(); 
		lista.forEach(consumer); // iterando com base no consumer
		
		
		//Substituiçao 1: Criando 'consumer' local anônimo
		Consumer consumer2 = new Consumer <String>(){
			@Override
			public void accept(String t) {
				System.out.println("consumer Local anonimo: " + t);
			}
		};
		lista.forEach(consumer2);


		// Substituiçao 2: iterando e criando consumer anonimo ao mesmo tempo
		lista.forEach(new Consumer<String>() { 
			@Override
			public void accept(String t) {
				System.out.println("Consumer anonimo dentro do forEach: " + t);
			}
		});


		//Substituiçao 3: Lambda: Criando consumer usando lambda
		Consumer<String> consumer3 = aluno1 -> System.out.println("consumer com lambda: " + aluno1);
		lista.forEach(consumer3);


		//Substituiçao 4: Lambda: iterando e criando consumer com lambdas,  Lambda apenas com parametro 'String s' do método 'accept'
		lista.forEach((String string) -> {
			System.out.println("lambda: " + string);
		});


		//Substituiçao 5: Lambda enxugado apenas com parametro 'aluno' do método 'accept'
		lista.forEach(aluno -> System.out.println("lambda enxugado: " + aluno));

	}

	////////////////////////// USO STREAM ///////////////////////////
	//Toda collection possui o strean
	//Devolve uma corrente
	//Possui uma variedade de métodos


	//O Filter devolve "true" ou "false" indicando se quer ficar a variavel na lista.
	public void Strean(){
		lista.stream()
				.filter(string -> string.length() > 11)
				.forEach(string -> System.out.println(string));

	//Mapeia Simbolizando (Substituindo) a variavel pelo resultado do lambda.
		lista.stream()
				.filter(string -> string.length() > 11)
				.map(String::length) //dado "string" mapeie (simbolize) para tamanho do "string".
				.forEach(lengthDaString -> System.out.println(lengthDaString));
	}


}
