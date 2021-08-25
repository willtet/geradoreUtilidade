package api.geradorDev.gerador;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Random;

public class GeradorCpf {
	
	public GeradorCpf() {
		// TODO Auto-generated constructor stub
	};
	
	public String gerarCpf() {
		Random random = new Random();

		while(true) {
			String primPonto = String.format("%03d", random.nextInt(999));
			String segPonto = String.format("%03d", random.nextInt(999));
			String terPonto = String.format("%03d", random.nextInt(999));
			String digito = String.format("%02d", random.nextInt(99));
			String cpf = primPonto+"."+segPonto+"."+terPonto+"-"+digito;

			if(validar(cpf)) {
				return cpf;
			}
		}
		
	}
	
	
	public boolean validar(String cpf) {
		String cpfFormatada = cpf.replaceAll("[^0-9]", "");
		String listaDeNumero[] = cpfFormatada.split("(?!^)");
		int listaFormatada[] = new int[listaDeNumero.length];
		
		
		for (int i = 0; i < listaDeNumero.length; i++) {
			listaFormatada[i] = Integer.parseInt(listaDeNumero[i]);
		}
		
		
		return validarCpf(listaFormatada);
	}


	private boolean validarCpf(int[] cpf) {
		int validadorPrimeiroNumero = validarDigitoCpf(cpf, 10, 9);
		int validadorSegundoNumero = validarDigitoCpf(cpf, 11, 10);
		
		if(validadorPrimeiroNumero == cpf[cpf.length-2] &&	validadorSegundoNumero == cpf[cpf.length-1]) {
			return true;
		}else {
			return false;
		}
	}


	private int validarDigitoCpf(int[] listaFormatadaCpf, int divisao, int campoPercorrido) {
		int somatoria = 0;
		for (int i = 0; i < campoPercorrido; i++) {
			somatoria += listaFormatadaCpf[i]*divisao;
			divisao-=1;
		}
		int resultadoMult = somatoria*10;
		int resultadoFinal = resultadoMult%11;
		return resultadoFinal;
	}
}
