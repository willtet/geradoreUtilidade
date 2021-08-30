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

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.monitorjbl.xlsx.StreamingReader;

public class GeradorDDDTelefone {
	public String gerarTelefone() {
		return randomTelefone();
		
	}
	
	public String gerarDDD() {
		try {
			List<String> listaDDD = lerTabelaExcel();
			return listaDDD.get(new Random().nextInt(listaDDD.size()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private String randomTelefone() {
		Random random = new Random();
		String telSemNove = String.format("%08d", random.nextInt(99999999));
		
		return "9"+telSemNove;
	}
	
	private List<String> lerTabelaExcel() throws FileNotFoundException {
		
		InputStream is = new FileInputStream(new File(System.getProperty("user.dir")+"/datas/ddd.xlsx"));
		Workbook worbook = StreamingReader.builder()
				.rowCacheSize(100)
				.bufferSize(100)
				.open(is);
		
		Sheet sheet = worbook.getSheet("Planilha1");
		
		List<String> listaDDD = new ArrayList<String>();
		
		for (Row row : sheet) {
			listaDDD.add(row.getCell(0).getStringCellValue());
		}
		listaDDD.remove(0);
		
		return listaDDD;
	}
}
