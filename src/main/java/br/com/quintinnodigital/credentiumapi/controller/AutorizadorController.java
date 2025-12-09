package br.com.quintinnodigital.credentiumapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinnodigital.credentiumapi.entity.UsuarioEntity;
import br.com.quintinnodigital.credentiumapi.service.AutorizadorService;

@RestController
@RequestMapping("/autorizador")
@CrossOrigin("*")
public class AutorizadorController {
	
	private final AutorizadorService autorizadorService;
	
	public AutorizadorController(AutorizadorService autorizadorService) {
		this.autorizadorService = autorizadorService;
	}

	@PostMapping("/registrar")
	public UsuarioEntity registrar(@RequestBody UsuarioEntity usuarioEntity) {
		return this.autorizadorService.registrar(usuarioEntity);
	}
	
	@PostMapping("/acessar")
	public String acessar(@RequestBody UsuarioEntity usuarioEntity) {
		return this.autorizadorService.acessar(usuarioEntity);
	}

}
