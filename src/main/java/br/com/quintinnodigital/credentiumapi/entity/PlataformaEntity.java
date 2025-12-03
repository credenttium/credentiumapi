package br.com.quintinnodigital.credentiumapi.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_plataforma")
public class PlataformaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code", updatable = false, nullable = false)
    public Long code;

    @Column(name = "nome", unique = true, nullable = false)
    public String nome;

    @Column(name = "url")
    public String url;
    
    @Lob
    private byte[] logomarca;

    @Column(name = "created_at", nullable = false)
    public LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    public LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    public LocalDateTime deletedAt;

    @Column(name = "active")
    public Boolean active = true;
    
    public PlataformaEntity() {}

    public PlataformaEntity(String nome) {
		this.nome = nome;
	}

	public PlataformaEntity(Long code, String nome) {
		this.code = code;
		this.nome = nome;
	}

	public PlataformaEntity(String nome, String url) {
		this.nome = nome;
		this.url = url;
	}

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getLogomarca() {
		return logomarca;
	}

	public void setLogomarca(byte[] logomarca) {
		this.logomarca = logomarca;
	}

	public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
