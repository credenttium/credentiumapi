package br.com.quintinnodigital.credentiumapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.quintinnodigital.credentiumapi.entity.CredencialEntity;
import br.com.quintinnodigital.credentiumapi.repostory.CredencialRepository;

@ExtendWith(MockitoExtension.class)
public class CredencialServiceTest {

	@Mock
	private CredencialRepository credencialRepository;

	@InjectMocks
	private CredencialService credencialService;

	@Test
	void deveCriarCredencial() {
		
		CredencialEntity entity = new CredencialEntity();

		when(credencialRepository.save(entity)).thenReturn(entity);

		CredencialEntity result = credencialService.create(entity);

		assertEquals(entity, result);
		
		verify(credencialRepository, times(1)).save(entity);
	}

	@Test
	void deveRetornarListaDeCredenciais() {
		
		CredencialEntity e1 = new CredencialEntity();
		CredencialEntity e2 = new CredencialEntity();
		List<CredencialEntity> lista = Arrays.asList(e1, e2);

		when(credencialRepository.findAll()).thenReturn(lista);

		List<CredencialEntity> result = credencialService.findAll();

		assertEquals(lista, result);
		verify(credencialRepository, times(1)).findAll();
	}

}
