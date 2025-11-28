package br.com.quintinnodigital.credentiumapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinnodigital.credentiumapi.entity.PlataformaEntity;
import br.com.quintinnodigital.credentiumapi.service.PlataformaService;

@RestController
@RequestMapping("/plataforma")
public class PlataformaController {

    private final PlataformaService plataformaService;

    public PlataformaController(PlataformaService plataformaService) {
        this.plataformaService = plataformaService;
    }

    @PostMapping
    public PlataformaEntity create(@RequestBody PlataformaEntity plataformaEntity) {
        return this.plataformaService.create(plataformaEntity);
    }

    @GetMapping
    public List<PlataformaEntity> findAll() {
        return this.plataformaService.findAll();
    }

}
