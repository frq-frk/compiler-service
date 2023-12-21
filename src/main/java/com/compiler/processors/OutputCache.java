package com.compiler.processors;

public class OutputCache {
	
	private static OutputCache outputInstance = null;
	
	private String output = null;
	private String error = null;
	
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	public static OutputCache getInstance() {
		if(outputInstance == null) {
			outputInstance = new OutputCache();
		}
		return outputInstance;
	}
	
}
