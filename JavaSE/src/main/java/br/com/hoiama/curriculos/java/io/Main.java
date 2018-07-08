package br.com.hoiama.curriculos.java.io;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		IO io = new IO();

		io.setSaidaDadosFileOutputStream();
		io.setSaidaDadosFileWriter();
		io.setSaidaDadosPrintStream();
		io.setSaidaDadosPrintWriter();

		io.getEntradaDadosArquivoFileInputStream();
		io.getEntradaDadosArquivoScanner();
		io.getEntradaDadosArquivoScannerEspecial();
		io.criadorProperties();
		io.leitorProperties();

		String letra = "c";
		System.out.println(letra);
		System.out.println(letra.getBytes("UTF-8"));
		System.out.println(letra.getBytes("UTF-16"));

	}
}
