package br.com.quintinnodigital.credentiumapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.quintinnodigital.credentiumapi.entity.PlataformaEntity;
import br.com.quintinnodigital.credentiumapi.mapper.PlataformaMapper;
import br.com.quintinnodigital.credentiumapi.repostory.PlataformaRepository;
import br.com.quintinnodigital.credentiumapi.transfer.PlataformaResponseTransfer;

@Service
public class PlataformaService {

    private final PlataformaRepository plataformaRepository;

    public PlataformaService(PlataformaRepository plataformaRepository) {
        this.plataformaRepository = plataformaRepository;
    }

    public PlataformaResponseTransfer create(PlataformaEntity plataformaEntity) {
        return PlataformaMapper.toPlataformaTransfer(this.plataformaRepository.save(plataformaEntity));
    }

    public List<PlataformaResponseTransfer> findAll() {
        return PlataformaMapper.toPlataformaTransfer(this.plataformaRepository.findAll());
    }

}
