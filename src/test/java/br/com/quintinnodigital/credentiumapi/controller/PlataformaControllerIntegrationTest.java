package br.com.quintinnodigital.credentiumapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.quintinnodigital.credentiumapi.service.PlataformaService;

@SpringBootTest
@AutoConfigureMockMvc
public class PlataformaControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private PlataformaService plataformaService;

	@Autowired
	private tools.jackson.databind.ObjectMapper objectMapper;

//    @Test
	/*
	void cadastrarDadosDaPlatformaViaRequisicaoJSON() throws Exception {

		// Arrange
		PlataformaEntity entrada = new PlataformaEntity();
		entrada.setNome("PlayStation");

		PlataformaEntity salvo = new PlataformaEntity();
		salvo.setCode(1L);
		salvo.setNome("PlayStation");

		when(plataformaService.create(any(PlataformaEntity.class))).thenReturn(salvo);

		mockMvc.perform(post("/plataforma").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(entrada))).andExpect(status().isOk())
				.andExpect(jsonPath("$.code").value(1L)).andExpect(jsonPath("$.nome").value("PlayStation"));

		verify(plataformaService, times(1)).create(any(PlataformaEntity.class));
	}
	*/

//	@Test
	/*
	void cadastrarDadosDaPlataformaViaMultipart() throws Exception {

		PlataformaEntity salvo = new PlataformaEntity(1L, "PlayStation");
		
		when(plataformaService.create(any(PlataformaEntity.class))).thenReturn(salvo);

		MockMultipartFile nome = new MockMultipartFile("nome", "", "text/plain", "PlayStation".getBytes());

		MockMultipartFile url = new MockMultipartFile("url", "", "text/plain", "https://sony.com".getBytes());

		MockMultipartFile file = new MockMultipartFile("file", "logo.png", "image/png", "IMAGEM_FAKE".getBytes());

		mockMvc.perform(multipart("/plataforma").file(nome).file(url).file(file).with(request -> { 
			request.setMethod("POST");
			return request;
		})).andExpect(status().isOk()).andExpect(jsonPath("$.code").value(1L)).andExpect(jsonPath("$.nome").value("PlayStation"));

		verify(plataformaService, times(1)).create(any(PlataformaEntity.class));
	}
	*/

}
