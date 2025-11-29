package br.com.quintinnodigital.credentiumapi.controller;

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

@RestController
@RequestMapping("/plataforma")
@CrossOrigin
public class PlataformaController {

	private final PlataformaService plataformaService;

	public PlataformaController(PlataformaService plataformaService) {
		this.plataformaService = plataformaService;
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public PlataformaEntity create(
			@RequestPart("nome") String nome, 
			@RequestPart(value = "url", required = false) String url, 
			@RequestPart(value = "file", required = false) MultipartFile multipartFile) {
		PlataformaEntity plataformaEntity = new PlataformaEntity();
			plataformaEntity.setNome(nome);
			plataformaEntity.setUrl(url);

		if (multipartFile != null && !multipartFile.isEmpty()) {
//			String fileName = multipartFile.getOriginalFilename();
		}

		return this.plataformaService.create(plataformaEntity);
	}

	@GetMapping
	public List<PlataformaEntity> findAll() {
		return this.plataformaService.findAll();
	}

}
