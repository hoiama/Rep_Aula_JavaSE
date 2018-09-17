package br.com.hoiama.curriculos.java.java8;

import java.util.*;
import java.util.function.Consumer;

public class Java8 {

	List<String> lista = new ArrayList<>();

	public Java8 (){
		lista.add("bd");
		lista.add("d");
		lista.add("aaa");
		lista.add("ccccc");
		lista.add("ff");
		lista.add("e");
	}


	/**
	 * Ordena por Collections.sort
	 */
	public void ordenaPorCollectionSort(){
		Collections.sort(lista);
		System.out.println("ordenaPorCollectionSort" + lista);
	}


	/**
	 * Comparando usando uma classe "comparator" externa.
	 */
	public void ordenarPorTamanhoComparatorExternoCollections(){
		ComparatorLength comparatorLength = new ComparatorLength();
		Collections.sort(lista, comparatorLength);
		System.out.println("ordenarPorTamanhoComparatorExternoCollections:" + lista);
	}


	/**
	 * (Novo) Comparando usando uma classe "comparator" externa.
	 */
	public void ordenarPorTamanhoComparatorExterno(){
		ComparatorLength comparatorLength = new ComparatorLength();
		lista.sort(comparatorLength);
		System.out.println("ordenarPorComparatorExterna:" + lista);
	}


	/**
	 * Cria 'comparator' anonimo localmente para o ArrayList "lista"
	 * Chamando "sort" no ArrayList "lista".
	 */
	public void ordenarPorTamanhoComparatorSimples(){
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
		System.out.println("ordenarPorComparatoLocalSimples:" + lista);
	}


	/**
	 * (Novo) com Lambda o "sort" cria um 'comparator' sem tipo dos argumentos "String".
	 */
	public void comparatorLocalComLambda(){
		lista.sort((s1, s2) -> {
			if (s1.length() < s2.length())	return -1;
			if (s1.length() > s2.length())	return 1;
			return 0;
		});
		System.out.println("comparatorLocalComLambda: " + lista);
	}


	/**
	 * substituição 2: lambda + 'Integer.compare' com os retornos '+1, -1'
	 */
	public void  listaOrdenadacomLambda(){
		lista.sort((s1, s2) ->  Integer.compare(s1.length(), s2.length()));
		System.out.println("listaOrdenadacomLambda: " + lista);
	}



		// USO DE FOREACH COM CONSUMER

	/**
	 * Usando Consumer externo para efetuar forEach com base no consumer.
	 */
	public void consumer(){
		forEachConsumer consumerExterno = new forEachConsumer();
		lista.forEach(consumerExterno);
	}


	/**
	 * (Novo): Criando 'consumer' local anônimo
	 */
	public void consumerLocal1(){
		Consumer consumerLocal = new Consumer<String>() {
			@Override
			public void accept(String stringTeste) {
				System.out.println("consumer Local anonimo: " + stringTeste);
			}
		};
		lista.forEach(consumerLocal);
	}

	/**
	 * Usamos o "consumer local" como sendo um parametro do método "forEach".
	 */
	public void consumerLocal2(){
		lista.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println("consumerLocal2: " + t);
			}
		});
	}


	/**
	 * Recebe um parametro que será o mesmo do método "Acept" da classe "Consumer"
	 */
	public void consumerLocalComLambda1(){
		lista.forEach((String parametroDoMetodoAceptDoConsumer) -> {
			System.out.println("consumerLocalComLambda1: " + parametroDoMetodoAceptDoConsumer);
		});
	}


	/**
	 * Removemos tipo do parametro "String" e os "{}" visto que só existe 1 metodo a ser executado.
	 */
	public void consumerLocalComLambda2(){
		lista.forEach(parametroDoMetodoAceptDoConsumer -> System.out.println("consumerLocalComLambda2: " + parametroDoMetodoAceptDoConsumer));
	}



	//ORGANIZAR ABAIXO DE ACORDO COM A AULA



	public void getListaOrdenada() {
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

		//Substituiao 3: Lambda: Criando consumer usando lambda
		Consumer<String> consumer3 = aluno1 -> System.out.println("consumer com lambda: " + aluno1);
		lista.forEach(consumer3); // usando consumer local com lambda

	}



}
