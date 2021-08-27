package api.geradorDev.teste;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.SimpleFormatter;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.monitorjbl.xlsx.StreamingReader;

import api.geradorDev.gerador.GeradorEndereco;
import api.geradorDev.gerador.GeradorSenha;

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
//		
//		System.out.println(new GeradorEndereco().gerar("05319040").toString());
//		
//
//		Map<String, List<String>> listaFormatada = new HashMap<String, List<String>>();
//		
//		InputStream is = new FileInputStream(new File(System.getProperty("user.dir")+"/datas/nomes.xlsx"));
//		Workbook worbook = StreamingReader.builder()
//				.rowCacheSize(100)
//				.bufferSize(100)
//				.open(is);
//		
//		Sheet sheet = worbook.getSheet("Planilha1");
//		
//		List<String> listaNomes = new ArrayList<String>();
//		for (Row row : sheet) {
//			 listaNomes.add(row.getCell(1).getStringCellValue());
//		}
//		listaNomes.remove(0);
//		
//		for (String string : listaNomes) {
//			System.out.println(string);
//		}
		
		System.out.println(new GeradorSenha().gerarSomenteEspeciais(10));
}}
