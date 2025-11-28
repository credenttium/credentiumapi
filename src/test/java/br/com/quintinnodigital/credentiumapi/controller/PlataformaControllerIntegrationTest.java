package br.com.quintinnodigital.credentiumapi.controller;

import br.com.quintinnodigital.credentiumapi.entity.PlataformaEntity;
import br.com.quintinnodigital.credentiumapi.service.PlataformaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PlataformaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PlataformaService plataformaService;

    @Autowired
    private tools.jackson.databind.ObjectMapper objectMapper;

    @Test
    void cadastrarDadosDaPlatformaViaRequisicaoJSON() throws Exception {

        // Arrange
        PlataformaEntity entrada = new PlataformaEntity();
        entrada.setNome("PlayStation");

        PlataformaEntity salvo = new PlataformaEntity();
        salvo.setCode(1L);
        salvo.setNome("PlayStation");

        when(plataformaService.create(any(PlataformaEntity.class))).thenReturn(salvo);

        mockMvc.perform(post("/plataforma")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(entrada)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1L))
                .andExpect(jsonPath("$.nome").value("PlayStation"));

        verify(plataformaService, times(1)).create(any(PlataformaEntity.class));
    }

}
