package br.com.quintinnodigital.credentiumapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

import br.com.quintinnodigital.credentiumapi.entity.PlataformaEntity;
import br.com.quintinnodigital.credentiumapi.repostory.PlataformaRepository;
import br.com.quintinnodigital.credentiumapi.transfer.PlataformaResponseTransfer;

@ExtendWith(MockitoExtension.class)
public class PlataformaServiceTest {

	@Mock
	private PlataformaRepository plataformaRepository;

	@InjectMocks
	private PlataformaService plataformaService;

	@Test
	void deveCriarPlataforma() {
		
		PlataformaEntity entity = new PlataformaEntity();
		entity.setNome("Netflix");

		PlataformaEntity saved = new PlataformaEntity();
		saved.setNome("Netflix");

		when(plataformaRepository.save(entity)).thenReturn(saved);

		PlataformaResponseTransfer result = plataformaService.create(entity);

		assertNotNull(result);
		assertEquals("Netflix", result.getNome());

		verify(plataformaRepository, times(1)).save(entity);
	}

	@Test
	void deveListarPlataformas() {
		
		PlataformaEntity p1 = new PlataformaEntity();
		p1.setNome("Netflix");

		PlataformaEntity p2 = new PlataformaEntity();
		p2.setNome("Amazon Prime");

		List<PlataformaEntity> lista = Arrays.asList(p1, p2);

		when(plataformaRepository.findAll()).thenReturn(lista);

		List<PlataformaResponseTransfer> result = plataformaService.findAll();

		assertEquals(2, result.size());
		assertEquals("Netflix", result.get(0).getNome());
		assertEquals("Amazon Prime", result.get(1).getNome());

		verify(plataformaRepository, times(1)).findAll();
	}

}
