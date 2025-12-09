package br.com.quintinnodigital.credentiumapi.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintinnodigital.credentiumapi.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	
	public UsuarioEntity findByUsuario(String usuario);
	
}
