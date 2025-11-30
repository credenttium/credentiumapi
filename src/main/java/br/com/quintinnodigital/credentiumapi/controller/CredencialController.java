package br.com.quintinnodigital.credentiumapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinnodigital.credentiumapi.entity.CredencialEntity;
import br.com.quintinnodigital.credentiumapi.service.CredencialService;

@RestController
@RequestMapping("/credencial")
@CrossOrigin("*")
public class CredencialController {
	
	private final CredencialService credencialService;

	public CredencialController(CredencialService credencialService) {
		this.credencialService = credencialService;
	}

	@PostMapping
	public ResponseEntity<CredencialEntity> create(@RequestBody CredencialEntity credencialEntity) {
		return ResponseEntity.ok(this.credencialService.create(credencialEntity));
	}
	
	@GetMapping
	public List<CredencialEntity> findAll() {
		return this.credencialService.findAll();
	}
	

}
