package api.geradorDev.gerador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONObject;

import com.monitorjbl.xlsx.StreamingReader;

import api.geradorDev.model.Endereco;


public class GeradorEndereco {
	public Endereco gerar() {
		List<String> listaCEP = new ArrayList<String>();
		try {
			listaCEP = lerTabelaExcel();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject enderecoColetado = new JSONObject();
		String cep = listaCEP.get(new Random().nextInt(listaCEP.size()));
		try {
			enderecoColetado = readJsonFromCEP(cep);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Endereco novoEndereco = new Endereco(
				cep,
				enderecoColetado.get("logradouro").toString(),
				enderecoColetado.get("bairro").toString(),
				enderecoColetado.get("localidade").toString(),
				enderecoColetado.get("uf").toString()
				);
		
		
		return novoEndereco;
	}
	
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
	
	private JSONObject readJsonFromCEP (String cep) throws IOException {
		URL url;
		int statusCode;
		do {
			Random r = new Random();
			url = new URL("https://viacep.com.br/ws/"+cep+"/json/");
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			statusCode = http.getResponseCode();
		}while(statusCode != 200);
		InputStream is = url.openStream();	
		try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONObject json = new JSONObject(jsonText);
		      return json;
		    } finally {
		      is.close();
		    }
	}
	
private List<String> lerTabelaExcel() throws FileNotFoundException {
		
		InputStream is = new FileInputStream(new File(System.getProperty("user.dir")+"/datas/cep.xlsx"));
		Workbook worbook = StreamingReader.builder()
				.rowCacheSize(100)
				.bufferSize(100)
				.open(is);
		
		Sheet sheet = worbook.getSheet("Planilha1");
		
		List<String> listaDDD = new ArrayList<String>();
		
		for (Row row : sheet) {
			listaDDD.add(row.getCell(0).getStringCellValue());
		}
		
		return listaDDD;
	}
	
	
}
