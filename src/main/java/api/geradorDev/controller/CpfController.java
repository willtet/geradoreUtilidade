package api.geradorDev.controller;

import java.time.LocalDate;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import api.geradorDev.dto.CpfDto;
import api.geradorDev.gerador.GeradorCpf;
import api.geradorDev.model.Pessoa;

@RestController
public class CpfController {

	
	@RequestMapping("/v1/cpf/gerar")
	@ResponseBody
	public String gerar() {
		CpfDto cpf = new CpfDto();
		return cpf.getCpf();	 	
	}
	
	@RequestMapping("/v1/cpf/verificar/{cpf}")
	@ResponseBody
	public boolean verificar(@PathVariable("cpf") String cpfVerificar) {
		CpfDto cpf = new CpfDto();
		return cpf.verificar(cpfVerificar);	 	
	}
	
	

	
	@RequestMapping("/v1/cpf/disponibilidade/{cpf}")
	@ResponseBody
	public boolean disponibilidade(@PathVariable("cpf") String cpfVerificar) {
		CpfDto cpf = new CpfDto();
		return cpf.verificar(cpfVerificar);	 	
	}
}

