package br.com.quintinnodigital.credentiumapi.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.quintinnodigital.credentiumapi.entity.PlataformaEntity;
import br.com.quintinnodigital.credentiumapi.service.PlataformaService;
import br.com.quintinnodigital.credentiumapi.transfer.PlataformaResponseTransfer;

@RestController
@RequestMapping("/plataforma")
@CrossOrigin("*")
public class PlataformaController {

	private final PlataformaService plataformaService;

	public PlataformaController(PlataformaService plataformaService) {
		this.plataformaService = plataformaService;
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public PlataformaResponseTransfer create(
			@RequestPart("nome") String nome, 
			@RequestPart(value = "url", required = false) String url, 
			@RequestPart(value = "logomarca", required = false) MultipartFile multipartFile) {
		
		PlataformaEntity plataformaEntity = new PlataformaEntity(nome, url);

		if (multipartFile != null && !multipartFile.isEmpty()) {
			try {
				plataformaEntity.setLogomarca(multipartFile.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return this.plataformaService.create(plataformaEntity);
	}

	@GetMapping
	public List<PlataformaResponseTransfer> findAll() {
		return this.plataformaService.findAll();
	}

}
