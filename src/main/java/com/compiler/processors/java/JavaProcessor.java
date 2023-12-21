package com.compiler.processors.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.compiler.processors.GenericProcessor;
import com.compiler.processors.OutputHandler;

public class JavaProcessor extends GenericProcessor{
	@Override
	public Process getProcess(String code) throws IOException, InterruptedException {
		ProcessBuilder processBuilder = null;
		String command = "";
		
		String tempFilePath = "TempDynamicProgram.java";
		PrintWriter writer = new PrintWriter(tempFilePath, "UTF-8");
		writer.println(code);
		writer.close();

		// Compile the temporary Java source file
		Process compileProcess = new ProcessBuilder("javac", tempFilePath).start();
		int compileExitCode = compileProcess.waitFor();
		if (compileExitCode == 0) {

			// Get the class name from the code
			String className = "Main";

			// Run the compiled class
			processBuilder = new ProcessBuilder("java", className);
		}else {
	        System.out.print(OutputHandler.captureErrorOutput(compileProcess));
		}
		new java.io.File(tempFilePath).delete();
		if(processBuilder == null) {
			return null;
		}
		return processBuilder.start();
	}
}
