package br.com.quintinnodigital.credentiumapi.component;

import java.time.Instant;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.quintinnodigital.credentiumapi.entity.UsuarioEntity;

@Component
public class TokenJwtConfiguration {
	
	private String segredo = "credentium";
	
	public String gerarTokenJWT(UsuarioEntity usuarioEntity) {
		return JWT
				.create()
				.withClaim("usuario", usuarioEntity.getCode())
				.withSubject(usuarioEntity.getUsuario())
				.withExpiresAt(Instant.now().plusSeconds(86400))
				.withIssuedAt(Instant.now())
				.sign(getAlgorithm());
				
	}

	private Algorithm getAlgorithm() {
		return Algorithm.HMAC256(segredo);
	}

}
