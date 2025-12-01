package br.com.quintinnodigital.credentiumapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.quintinnodigital.credentiumapi.entity.CredencialEntity;
import br.com.quintinnodigital.credentiumapi.repostory.CredencialRepository;

@Service
public class CredencialService {


	private final CredencialRepository credencialRepository;

	public CredencialService(CredencialRepository credencialRepository) {
		this.credencialRepository = credencialRepository;
	}
	
	public CredencialEntity create(CredencialEntity credencialEntity) {
		return this.credencialRepository.save(credencialEntity);
	}
	
	public List<CredencialEntity> findAll() {
		return this.credencialRepository.findAll();
	}
	
	public CredencialEntity findOne(Long codigoCredencial) {
		return this.credencialRepository.findById(codigoCredencial).get();
	}
	
}
