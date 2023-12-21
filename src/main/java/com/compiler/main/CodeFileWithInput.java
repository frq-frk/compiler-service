package com.compiler.main;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="code_file")
@Entity
public class CodeFileWithInput {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private String id = UUID.randomUUID().toString();
	private String code;
	private String language;
	private String input;
	
    public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public void setId(String id) {
		this.id = id;
	}
    public String getId() {
    	return id;
    }
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
