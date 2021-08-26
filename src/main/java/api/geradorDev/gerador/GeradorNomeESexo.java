package api.geradorDev.gerador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.monitorjbl.xlsx.StreamingReader;

public class GeradorNomeESexo {
	public String gerar() {
		try {
			Map<String, List<String> > listaDeNomes = lerTabelaExcel();
			
			String[] array = {"masculino", "feminino"};
			int randomSexo = new Random().nextInt(2);
			String sexoDefinido = array[randomSexo];
			
			List<String> nomes = listaDeNomes.get(sexoDefinido);
			List<String> sobrenomes = listaDeNomes.get("sobrenome");
			
			String nome = nomes.get(new Random().nextInt(nomes.size())+1);
			String sobrenome = sobrenomes.get(new Random().nextInt(sobrenomes.size())+1);
			
			return nome+";"+sobrenome+";"+sexoDefinido;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String gerarMãe(String sobrenomePai) {
		try {
			Map<String, List<String> > listaDeNomes = lerTabelaExcel();
			
			String[] array = {"masculino", "feminino"};
			int randomSexo = new Random().nextInt(2);
			String sexoDefinido = array[randomSexo];
			
			List<String> nomes = listaDeNomes.get("feminino");
			List<String> sobrenomes = listaDeNomes.get("sobrenome");
			
			String nome = nomes.get(new Random().nextInt(nomes.size())+1);
			String sobrenome = sobrenomes.get(new Random().nextInt(sobrenomes.size())+1);
			while (sobrenome.equals(sobrenomePai)) {
				sobrenome = sobrenomes.get(new Random().nextInt(sobrenomes.size())+1);
				
			}
			
			return nome+" "+sobrenome+" "+sobrenomePai;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String gerarPai(String SobrenomePai) {
		try {
			Map<String, List<String> > listaDeNomes = lerTabelaExcel();
			
			List<String> nomes = listaDeNomes.get("masculino");
			
			String nome = nomes.get(new Random().nextInt(nomes.size())+1);
			
			return nome+" "+SobrenomePai;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	private Map<String, List<String>> lerTabelaExcel() throws FileNotFoundException {
		Map<String, List<String>> listaFormatada = new HashMap<String, List<String>>();
		
		InputStream is = new FileInputStream(new File(System.getProperty("user.dir")+"/datas/nomes.xlsx"));
		Workbook worbook = StreamingReader.builder()
				.rowCacheSize(100)
				.bufferSize(100)
				.open(is);
		
		Sheet sheet = worbook.getSheet("Planilha1");
		
		List<String> listaMas = new ArrayList<String>();
		List<String> listaFem = new ArrayList<String>();
		List<String> listaSobre = new ArrayList<String>();
		
		for (Row row : sheet) {
			listaMas.add(row.getCell(0).getStringCellValue());
			listaFem.add(row.getCell(1).getStringCellValue());
			listaSobre.add(row.getCell(2).getStringCellValue());
		}
		listaMas.remove(0);
		listaFem.remove(0);
		listaSobre.remove(0);
		
		
		listaFormatada.put("masculino", listaMas);
		listaFormatada.put("feminino", listaFem);
		listaFormatada.put("sobrenome", listaSobre);
		
		return listaFormatada;
	}
		
}