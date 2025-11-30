package br.com.quintinnodigital.credentiumapi.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.quintinnodigital.credentiumapi.entity.PlataformaEntity;
import br.com.quintinnodigital.credentiumapi.transfer.PlataformaResponseTransfer;

public class PlataformaMapper {

	public static PlataformaEntity toPlataformaEntity(PlataformaResponseTransfer plataformaResponseTransfer) {
		PlataformaEntity plataformaEntity = new PlataformaEntity();
			plataformaEntity.setCode(Long.parseLong(plataformaResponseTransfer.getCode()));
			plataformaEntity.setNome(plataformaResponseTransfer.getNome());
			plataformaEntity.setUrl(plataformaResponseTransfer.getUrl());
			plataformaEntity.setCreatedAt(plataformaResponseTransfer.getCreatedAt() != null ? LocalDateTime.parse(plataformaResponseTransfer.getCreatedAt()) : null);
			plataformaEntity.setUpdatedAt(plataformaResponseTransfer.getUpdatedAt() != null ? LocalDateTime.parse(plataformaResponseTransfer.getUpdatedAt()) : null);
			plataformaEntity.setDeletedAt(plataformaResponseTransfer.getDeletedAt() != null ? LocalDateTime.parse(plataformaResponseTransfer.getDeletedAt()) : null);
			plataformaEntity.setActive(Boolean.parseBoolean(plataformaResponseTransfer.getActive()));
		return plataformaEntity;
	}

	public static PlataformaResponseTransfer toPlataformaTransfer(PlataformaEntity plataformaEntity) {
		PlataformaResponseTransfer plataformaResponseTransfer = new PlataformaResponseTransfer();
			plataformaResponseTransfer.setCode(plataformaEntity.getCode().toString());
			plataformaResponseTransfer.setNome(plataformaEntity.getNome());
			plataformaResponseTransfer.setUrl(plataformaEntity.getUrl());
			plataformaResponseTransfer.setCreatedAt(plataformaEntity.getCreatedAt() != null ? plataformaEntity.getCreatedAt().toString() : "");
			plataformaResponseTransfer.setUpdatedAt(plataformaEntity.getUpdatedAt() != null ? plataformaEntity.getUpdatedAt().toString() : "");
			plataformaResponseTransfer.setDeletedAt(plataformaEntity.getDeletedAt() != null ? plataformaEntity.getDeletedAt().toString() : "");
			plataformaResponseTransfer.setActive(plataformaEntity.getActive().toString());
		return plataformaResponseTransfer;
	}

	public static List<PlataformaResponseTransfer> toPlataformaTransfer(List<PlataformaEntity> plataformaEntityList) {
		List<PlataformaResponseTransfer> plataformaResponseTransferList = new ArrayList<PlataformaResponseTransfer>();
		for (PlataformaEntity plataformaEntity : plataformaEntityList) {
			PlataformaResponseTransfer plataformaResponseTransfer = new PlataformaResponseTransfer();
				plataformaResponseTransfer.setCode(plataformaEntity.getCode().toString());
				plataformaResponseTransfer.setNome(plataformaEntity.getNome());
				plataformaResponseTransfer.setUrl(plataformaEntity.getUrl());
				plataformaResponseTransfer.setCreatedAt(plataformaEntity.getCreatedAt() != null ? plataformaEntity.getCreatedAt().toString() : "");
				plataformaResponseTransfer.setUpdatedAt(plataformaEntity.getUpdatedAt() != null ? plataformaEntity.getUpdatedAt().toString() : "");
				plataformaResponseTransfer.setDeletedAt(plataformaEntity.getDeletedAt() != null ? plataformaEntity.getDeletedAt().toString() : "");
				plataformaResponseTransfer.setActive(plataformaEntity.getActive().toString());
				plataformaResponseTransferList.add(plataformaResponseTransfer);
		}
		return plataformaResponseTransferList;
	}

}
