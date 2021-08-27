package api.geradorDev.gerador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Random;

import org.json.JSONObject;

import api.geradorDev.model.Endereco;


public class GeradorEndereco {
	public Endereco gerar(String cep) throws IOException {
		JSONObject enderecoColetado;
		enderecoColetado = readJsonFromCEP(cep);
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
	
	
}
