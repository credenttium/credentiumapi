package br.com.quintinnodigital.credentiumapi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.com.quintinnodigital.credentiumapi.repostory.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
	
	private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

}
