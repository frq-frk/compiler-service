package com.compiler.processors;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

public class CodeExecute {
	public String execute(String language, String code) throws IOException, InterruptedException {
		GenericProcessor processor = ProcessorFactory.getGenericProcessor(language.toUpperCase() + "_PROCESSOR");

		if (processor == null) {
			return ("Unsupported Language");
		}

		Process process = processor.getProcess(code);

		if (process == null) {
			return (OutputCache.getInstance().getError());
		}

		int executeCode = process.waitFor();
		if (executeCode != 0) {
			String error = OutputHandler.captureErrorOutput(process);
			System.out.println(process);
			return (error);
		}

		return OutputHandler.captureOutput(process);
	}

	public String executeWithInput(String language, String code, String input) throws IOException, InterruptedException {
		GenericProcessor processor = ProcessorFactory.getGenericProcessor(language.toUpperCase() + "_PROCESSOR");

		if (processor == null) {
			return ("Unsupported Language");
		}

		Process process = processor.getProcess(code);

		if (process == null) {
			return (OutputCache.getInstance().getError());
		}
		OutputStream outputStream = process.getOutputStream();
        
        byte[] inputBytes = Base64.getDecoder().decode(input);
        outputStream.write(inputBytes);
        outputStream.flush();
        
		int executeCode = process.waitFor();
		if (executeCode != 0) {
			String error = OutputHandler.captureErrorOutput(process);
			System.out.println(process);
			return (error);
		}

		return OutputHandler.captureOutput(process);
	}

}
