package br.com.quintinnodigital.credentiumapi.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.quintinnodigital.credentiumapi.component.TokenJwtConfiguration;
import br.com.quintinnodigital.credentiumapi.entity.UsuarioEntity;
import br.com.quintinnodigital.credentiumapi.repostory.UsuarioRepository;

@Service
public class AutorizadorService {
	
	private final UsuarioRepository usuarioRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	private final AuthenticationManager authenticationManager;
	
	private final TokenJwtConfiguration tokenJwtConfiguration;
	
	public AutorizadorService(
			UsuarioRepository usuarioRepository, 
			PasswordEncoder passwordEncoder, 
			AuthenticationManager authenticationManager, 
			TokenJwtConfiguration tokenJwtConfiguration) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
		this.tokenJwtConfiguration = tokenJwtConfiguration;
	}

	public UsuarioEntity registrar(UsuarioEntity usuarioEntity) {
		usuarioEntity.setSenha(passwordEncoder.encode(usuarioEntity.getSenha()));
		return this.usuarioRepository.save(usuarioEntity);
	}
	
	public String acessar(UsuarioEntity usuarioEntity) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuarioEntity.getUsuario(), usuarioEntity.getSenha()));
	    return tokenJwtConfiguration.gerarTokenJWT((UsuarioEntity) authentication.getPrincipal());
	}

}
