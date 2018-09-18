package br.com.hoiama.curriculos.java.java8;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8 {



	private List<String> lista = new ArrayList<>();

    public Java8(){
        List<String> lista = new ArrayList<>();
        lista.add("tamanho02");
        lista.add("tamanho003");
        lista.add("tamanho0004");
        lista.add("tamanho00005");
        lista.add("tamanho000006");
        this.lista = lista;
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
		System.out.println("Comparador local anonimo: " + lista);


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
		System.out.println("Usando 'method reerence' :: " + lista);

        //Substituiao 3: Lambda: Criando consumer usando lambda
        Consumer<String> consumer3 = aluno1 -> System.out.println("consumer com lambda: " + aluno1);
        lista.forEach(consumer3); // usando consumer local com lambda

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
		System.out.println("Usando 'method reerence' : " + lista);

//		//Usando 'method reerence' ao invés de lambda (omitindo 'Comparator')
//		lista.sort(comparing(String::length));
//		System.out.println("Usando 'method reerence' : " + lista);

		//Substituiao 3: Lambda: Criando consumer usando lambda
		Consumer<String> consumer3 = aluno1 -> System.out.println("consumer com lambda: " + aluno1);
		lista.forEach(consumer3); // usando consumer local com lambda

	}


	public void streamFilter(){

		/**
		 * ".filter" filtra elementos ormando uma nova lista baseada em uma condição.
		 */
		lista
			.stream()
			.filter(curso -> curso.length()>4)
			.forEach(curso -> System.out.println("Strean : " + curso));


		/**
		 * ".map" simboliza os elementos da lista na forma do retorno da função definida.
		 */
		lista
			.stream()
			.filter(cursoFiltrado -> cursoFiltrado.length()>4)
			.map(TamanhoCurso -> TamanhoCurso.length())
			.forEach(curso -> System.out.println("Strean:filter:map : " + curso));


		/**
		 * ".map" simboliza os elementos da lista na forma de Integer, permitindo encadear outras funções específicas.
		 */
		lista
			.stream()
			.filter(cursoFiltrado -> cursoFiltrado.length() > 4)
			.mapToInt(TamanhoCurso -> TamanhoCurso.length())
			.forEach(curso  -> System.out.println("Strean:filter:mapToInt : " + curso));


		/**
		 * Exemplo de função específica com "mapToInt".
		 */
		int somaListaLengh =
			lista
				.stream()
				.mapToInt(curso -> curso.length())
				.sum();
		System.out.println("somaListaLengh " + somaListaLengh);


		/**
		 * Encontra valor qualquer(findAny), executa função se presente (ifPresent)
		 */
		Optional<Integer> optionalInteger =
				lista
					.stream()
					.filter(curso -> curso.length()>5)
					.map(curso -> curso.length())
					.findAny();
		System.out.println("optional: " + optionalInteger);
		optionalInteger.orElse(null); //ou devolve o "optionalInteger" ou Null
		optionalInteger.ifPresent(curso -> System.out.println("ifPresent : " + curso));

		/**
		 * Coleta valor em um Collector"
		 */
		List<Integer> optionalColetado =
				lista
					.stream()
					.filter(curso -> curso.length()>5)
					.map(curso -> curso.length())
					.collect(Collectors.toList());
		System.out.println("optionalColetado: " + optionalColetado);

		optionalColetado
				.stream()
				.findAny()
				.ifPresent(curso -> System.out.println("ifPresent : " + curso));



		/**
		 * Coleta valor em um Collector" e guarda em um map.
		 */
		lista
			.stream()
			.collect(Collectors.toMap(curso -> curso.toString(), cursoLength -> cursoLength.length()))
			.forEach((curso, cursoLenth) -> System.out.println(curso + " tem " + cursoLenth + " Caracteres "));

	}


	public void DatasAPI(){
		LocalDate hoje = LocalDate.now();
		System.out.println("Hoje" + hoje);

		System.out.println("Ano" + hoje.getYear());
		System.out.println("mes " + hoje.getMonth());
		System.out.println("dia do mes " + hoje.getDayOfMonth());

		LocalDate olimpiadas = LocalDate.of(2016, Month.APRIL, 5);
		System.out.println("olinpiedas " + olimpiadas);

		Period periodo = Period.between(olimpiadas, hoje);
		System.out.println(periodo.getDays() + " e " + periodo.getMonths() + " Meses ");




	}


}
