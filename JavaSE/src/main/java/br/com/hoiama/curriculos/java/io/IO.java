package br.com.hoiama.curriculos.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;

public class IO {

	
	// ENTRADA DE DADOS A PARTIR DE ARQUIVOS!!!
	
	public void getEntradaDadosArquivoFileInputStream() throws IOException {
		InputStream entrada = new FileInputStream("FileWriter.txt");
		InputStreamReader streamReader = new InputStreamReader(entrada);
		BufferedReader bufferReader = new BufferedReader(streamReader);
		String testeTxt = bufferReader.readLine();
		System.out.println(testeTxt );
		bufferReader.close();
	}
	
	public void getEntradaDadosArquivoScanner() throws IOException{
		Scanner leitor = new Scanner(new File("FileWriter.csv"));
		while(leitor.hasNextLine()) {
			String linha = leitor.nextLine();
			String[] arrayPalavras = linha.split(",");
			System.out.println(Arrays.toString(arrayPalavras));
			
			for (String palavra : arrayPalavras) {
				System.out.println(palavra );	
			}
		}
		leitor.close();
	}
	
	public void getEntradaDadosArquivoScannerEspecial() throws IOException{
		Scanner leitor = new Scanner(new File("FileWriter.csv"));
		while(leitor.hasNextLine()) {
			String linha = leitor.nextLine();
			System.out.println(linha);
			Scanner linhaScanner = new Scanner(linha);
			linhaScanner.useLocale(Locale.US);
			linhaScanner.useDelimiter(",");
			
			String valor1 = linhaScanner.next();
			String valor2 = linhaScanner.next();
			String valor3 = linhaScanner.next();
			int numero4 = linhaScanner.nextInt();
			double numero5 = linhaScanner.nextDouble();
			String valor6 = linhaScanner.next();
			
			String formatacao = String.format(
					new Locale("pt", "BR") ,"%s - %s - %s - ( %04d | %09.2f ) - %s ",
					valor1,valor2,valor3,numero4,numero5,valor6);
			
			System.out.println(formatacao);
			linhaScanner.close();
		}
		leitor.close();
	}
	
	public void leitorProperties() throws IOException {
		Properties prop = new Properties();
		prop.load(new FileReader("conf.properties"));
		
		String login = prop.getProperty("login");
		String senha = prop.getProperty("senha");
		String url = prop.getProperty("url");
		
		System.out.println(login + senha + url);
	}
	
	

	// SAIDA DE DADOS EM FORMANTO DE ARQUIVOS TXT

	public void setSaidaDadosFileOutputStream() throws IOException {
		OutputStream saidaBinaria = new FileOutputStream("FileOutputStream.txt");
		Writer saidaTextual = new OutputStreamWriter(saidaBinaria);
		BufferedWriter armazemTextual = new BufferedWriter(saidaTextual);
		armazemTextual.write("Testando saídada de dados");
		armazemTextual.close();
	}

	public void setSaidaDadosFileWriter() throws IOException {
		FileWriter file = new FileWriter("FileWriter.csv");
		file.write("primeira,linha,cc,11,22.2,FileWriter");
		file.write(System.lineSeparator());
		file.write("segunda,linha,xx,33,44.4,  FileWriter");
		file.close();
	}

	public void setSaidaDadosPrintStream() throws IOException {
		PrintStream printStream = new PrintStream("PrintStream");
		printStream.println("Tetando printStream");
		printStream.close();
	}

	public void setSaidaDadosPrintWriter() throws IOException {
		PrintWriter printWriter = new PrintWriter("PrinteWriter.txt");
		printWriter.println("Testando printWriter");
		printWriter.close();
	}
	
	public void criadorProperties() throws IOException {
		Properties propriedades = new Properties();
		propriedades.setProperty("login", "hoiama");
		propriedades.setProperty("senha", "1234");
		propriedades.setProperty("url", "mysql:8080");
		propriedades.store(new FileWriter("conf.properties"), "arquivo do mysql");
	}
}
