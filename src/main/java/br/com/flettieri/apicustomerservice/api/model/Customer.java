package br.com.flettieri.apicustomerservice.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.flettieri.apicustomerservice.api.enums.DocumentTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity()
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String uuid;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "createdDate")
	private LocalDateTime createdDate;
	
	@Column(name = "updatedDate")
	private LocalDateTime updatedDate;
	
	@Column(name = "enabled")
	private Boolean enabled;
	
	@Column(name = "disabledDate")
	private LocalDateTime disabledDate;
	
	@Column(name = "document")
	private String document;
	
	@Enumerated(EnumType.STRING)
	private DocumentTypeEnum documentType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getDisabledDate() {
		return disabledDate;
	}

	public void setDisabledDate(LocalDateTime disabledDate) {
		this.disabledDate = disabledDate;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public DocumentTypeEnum getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentTypeEnum documentType) {
		this.documentType = documentType;
	}
	
	private void sysout() {
		// TODO Qualquer coisa

	}
	
	
	
}
