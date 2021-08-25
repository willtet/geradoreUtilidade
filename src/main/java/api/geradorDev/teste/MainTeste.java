package api.geradorDev.teste;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.SimpleFormatter;

import api.geradorDev.gerador.GeradorEndereco;

public class MainTeste {
	public static void main(String[] args) throws MalformedURLException, IOException {
//		String pattern = "dd/MM/yyyy";
//		DateTimeFormatter sp = DateTimeFormatter.ofPattern(pattern);
//		System.out.println(sp.format(LocalDate.now()));
//		
//		String data = "04/04/1996";
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		LocalDate dataF = LocalDate.parse(data,formatter);
//		System.out.println(dataF.toString());
		
		System.out.println(new GeradorEndereco().gerar("05319040").toString());
	}
}
