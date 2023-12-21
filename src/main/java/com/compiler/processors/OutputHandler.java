package com.compiler.processors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OutputHandler {
	public static String captureOutput(Process process) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		StringBuilder output = new StringBuilder();
		String line;

		while ((line = reader.readLine()) != null) {
			output.append(line).append("\n");
		}
		
		OutputCache.getInstance().setOutput(output.toString());
		return output.toString();
	}

	public static String captureErrorOutput(Process process) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		StringBuilder errorOutput = new StringBuilder();
		String line;

		while ((line = reader.readLine()) != null) {
			errorOutput.append(line).append("\n");
		}

		OutputCache.getInstance().setError(errorOutput.toString());
		return errorOutput.toString();
	}
}
