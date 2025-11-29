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

        PlataformaEntity plataformaEntityPersistencia = new PlataformaEntity(1L, "Plataforma Teste");

//        Mockito.when(plataformaService.create(plataformaEntity)).thenReturn(plataformaEntityPersistencia);
        
        Mockito.when(plataformaService.create(Mockito.any(PlataformaEntity.class))).thenReturn(plataformaEntityPersistencia);

        PlataformaEntity plataformaEntitySalvo = plataformaController.create("Plataforma Teste", "http://url-da-logo.com/logo.png", null);

        assertNotNull(plataformaEntitySalvo);
        
    }

}
