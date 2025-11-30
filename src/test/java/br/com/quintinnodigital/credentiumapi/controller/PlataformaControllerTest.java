package br.com.quintinnodigital.credentiumapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.quintinnodigital.credentiumapi.entity.PlataformaEntity;
import br.com.quintinnodigital.credentiumapi.service.PlataformaService;
import br.com.quintinnodigital.credentiumapi.transfer.PlataformaResponseTransfer;

@ExtendWith(MockitoExtension.class)
public class PlataformaControllerTest {

	@InjectMocks
	private PlataformaController plataformaController;

	@Mock
	private PlataformaService plataformaService;

	@Test
	void createPlataformaComSucesso() {

		String nome = "Plataforma Teste";
		String url = "http://url-da-logo.com/logo.png";

		PlataformaResponseTransfer respostaMock = new PlataformaResponseTransfer();
		respostaMock.setCode("1");
		respostaMock.setNome(nome);
		respostaMock.setUrl(url);

		Mockito.when(plataformaService.create(Mockito.any(PlataformaEntity.class))).thenReturn(respostaMock);

		PlataformaResponseTransfer response = plataformaController.create(nome, url, null);

		assertNotNull(response);
		assertEquals("Plataforma Teste", response.getNome());
		assertEquals("http://url-da-logo.com/logo.png", response.getUrl());

	}

}
