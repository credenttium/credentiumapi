package br.com.quintinnodigital.credentiumapi.service;

import br.com.quintinnodigital.credentiumapi.entity.PlataformaEntity;
import br.com.quintinnodigital.credentiumapi.repostory.PlataformaRepository;
import org.springframework.stereotype.Service;

@Service
public class PlataformaService {

    private final PlataformaRepository plataformaRepository;

    public PlataformaService(PlataformaRepository plataformaRepository) {
        this.plataformaRepository = plataformaRepository;
    }

    public PlataformaEntity create(PlataformaEntity plataformaEntity) {
        return this.plataformaRepository.save(plataformaEntity);
    }

}
