package api.geradorDev.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import api.geradorDev.model.Pessoa;

@RestController
public class PessoaController {
	@GetMapping("/v1/pessoa/gerar")
	@ResponseBody
	public Pessoa gerarPessoa() {
		Pessoa pessoa = new Pessoa("willian",LocalDate.parse("1996-04-04"),"masculino","00001000"); 
		return pessoa;
	}
	

}
