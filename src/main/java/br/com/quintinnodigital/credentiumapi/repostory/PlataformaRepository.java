package br.com.quintinnodigital.credentiumapi.repostory;

import br.com.quintinnodigital.credentiumapi.entity.PlataformaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlataformaRepository extends JpaRepository<PlataformaEntity, Long> {}
