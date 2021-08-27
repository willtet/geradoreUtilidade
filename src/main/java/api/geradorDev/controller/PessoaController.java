package api.geradorDev.controller;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import api.geradorDev.model.Pessoa;

@RestController
public class PessoaController {
	@GetMapping("/v1/pessoa/gerar")
	@ResponseBody
	public ResponseEntity<Pessoa> gerarPessoa() {
		Pessoa pessoa = new Pessoa("01106090"); 
		return ResponseEntity.ok(pessoa);
	}
	

}
