package br.com.quintinnodigital.credentiumapi.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintinnodigital.credentiumapi.entity.CredencialEntity;

@Repository
public interface CredencialRepository extends JpaRepository<CredencialEntity, Long>{}
