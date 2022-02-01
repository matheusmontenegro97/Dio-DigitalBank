package dio.br.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.br.model.Conta;
import dio.br.repository.ContaRepository;

@RestController
@RequestMapping("conta")
public class ContaController {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@GetMapping
	public List<Conta> list(){
		return contaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Conta retrievalContaById(@PathVariable Long id) {
		Optional<Conta> conta = contaRepository.findById(id);
		if(conta.isEmpty())
			return null;
		return conta.get();
	}
	
	@PostMapping
	public String createConta(@RequestBody Conta conta) {
		contaRepository.save(conta);
		return "As informações da conta foram salvas.";
		
	}
	
	@PutMapping
	public String updateConta(@RequestBody Conta conta) {
		if (conta.getId() == null)
			return "Informe o id da conta!";
		
		contaRepository.save(conta);
		return "Os dados referente ao curso foram atualizados";
	}
	
	@DeleteMapping
	public String deleteConta(@RequestBody Conta conta) {
		if (conta.getId() == null)
			return "Informe o id da conta!";
		
		contaRepository.delete(conta);
		return "O curso foi deletado!";
	}
	
	
	
}

