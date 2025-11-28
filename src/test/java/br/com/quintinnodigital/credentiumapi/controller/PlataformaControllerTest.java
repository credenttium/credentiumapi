package br.com.quintinnodigital.credentiumapi.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.quintinnodigital.credentiumapi.entity.PlataformaEntity;
import br.com.quintinnodigital.credentiumapi.service.PlataformaService;

@ExtendWith(MockitoExtension.class)
public class PlataformaControllerTest {

    @Mock
    private PlataformaService plataformaService;

    @InjectMocks
    private PlataformaController plataformaController;

    @Test
    void createPlataformaComSucesso() {

        PlataformaEntity plataformaEntity = new PlataformaEntity();
            plataformaEntity.setNome("Plataforma Teste");

        PlataformaEntity plataformaEntityPersistencia = new PlataformaEntity();
            plataformaEntityPersistencia.setCode(1L);
            plataformaEntityPersistencia.setNome("Plataforma Teste");

        Mockito.when(plataformaService.create(plataformaEntity)).thenReturn(plataformaEntityPersistencia);

        PlataformaEntity plataformaEntitySalvo = plataformaController.create(plataformaEntity);

        assertNotNull(plataformaEntitySalvo);
        
    }

}
