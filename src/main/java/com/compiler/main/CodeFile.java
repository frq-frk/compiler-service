package com.compiler.main;

import java.util.UUID;


public class CodeFile {
    private String id = UUID.randomUUID().toString();
	private String code;
	private String language;
	
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
