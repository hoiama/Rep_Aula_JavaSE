package br.com.hoiama.curriculos.java.java8;

import java.util.function.Consumer;

class forEachConsumer implements Consumer<String>{

	@Override
	public void accept(String s1) {
		System.out.println("Class consumer: " + s1);
	}
	
}
