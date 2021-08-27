package api.geradorDev.gerador;

import java.util.Random;

public class GeradorSenha {
	public String gerar(int qtdCaractere) {
		StringBuilder senha = new StringBuilder();
		for (int i = 0; i < qtdCaractere; i++) {
			char e[] = {'!','@','#','$','%','&','*','(',')','-','_','+','.',',',';','?','{','[','}',']','^','>','<',':'};
			int maiusculo = new Random().nextInt(90-65)+65;
			int minusculo = new Random().nextInt(122-97)+97;
			int caracterEspecial;
			senha.append((char) minusculo);
		}
		return senha.toString();
	}
	
	public String gerarSomenteMinusculo(int qtdCaractere) {
		StringBuilder senha = new StringBuilder();
		for (int i = 0; i < qtdCaractere; i++) {
			int minusculo = new Random().nextInt(122-97)+97;
			senha.append((char) minusculo);
		}
		return senha.toString();
	}
	
	public String gerarSomenteMaiusculo(int qtdCaractere) {
		StringBuilder senha = new StringBuilder();
		for (int i = 0; i < qtdCaractere; i++) {
			int maiusculo = new Random().nextInt(90-65)+65;
			senha.append((char) maiusculo);
		}
		return senha.toString();
	}
	
	public String gerarSomenteEspeciais(int qtdCaractere) {
		StringBuilder senha = new StringBuilder();
		for (int i = 0; i < qtdCaractere; i++) {
			char e[] = {'!','@','#','$','%','&','*','(',')','-','_','+','.',',',';','?','{','[','}',']','^','>','<',':'};
			char caracterEspecial =e[new Random().nextInt(e.length)];
			senha.append(caracterEspecial);
		}
		return senha.toString();
	}
	
	public String gerarMinusculoMaiusculo(int qtdCaractere) {
		StringBuilder senha = new StringBuilder();
		for (int i = 0; i < qtdCaractere; i++) {
			int maiusculo = new Random().nextInt(90-65)+65;
			int minusculo = new Random().nextInt(122-97)+97;
			int caracterEspecial;
			senha.append((char) minusculo);
		}
		return senha.toString();
	}
	
	public String gerarMinusculoEspeciais(int qtdCaractere) {
		StringBuilder senha = new StringBuilder();
		for (int i = 0; i < qtdCaractere; i++) {
			char e[] = {'!','@','#','$','%','&','*','(',')','-','_','+','.',',',';','?','{','[','}',']','^','>','<',':'};
			int maiusculo = new Random().nextInt(90-65)+65;
			int minusculo = new Random().nextInt(122-97)+97;
			int caracterEspecial;
			senha.append((char) minusculo);
		}
		return senha.toString();
	}
	
	public String gerarMaiusculoEspeciais(int qtdCaractere) {
		StringBuilder senha = new StringBuilder();
		for (int i = 0; i < qtdCaractere; i++) {
			char e[] = {'!','@','#','$','%','&','*','(',')','-','_','+','.',',',';','?','{','[','}',']','^','>','<',':'};
			int maiusculo = new Random().nextInt(90-65)+65;
			int minusculo = new Random().nextInt(122-97)+97;
			int caracterEspecial;
			senha.append((char) minusculo);
		}
		return senha.toString();
	}
}
