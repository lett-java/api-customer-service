package br.com.flettieri.apicustomerservice.api.enums;

import lombok.Getter;

@Getter
public enum DocumentTypeEnum {

	CNPJ("Cnpj"),
	CPF("Cpf");
	
	private String description;
	
	DocumentTypeEnum(String description) {
		this.description = description;
	}
}
