package com.compiler.processors.c;

import java.io.IOException;

import com.compiler.file.utils.FileUtils;
import com.compiler.processors.GenericProcessor;

public class CProcessor extends GenericProcessor {
	@Override
	public Process getProcess(String code) throws IOException {
		Process process = null;
		String command = "";
		
		command = "gcc -o temp_c_exec temp.c && ./temp_c_exec";
		FileUtils.createTempFile(code, "temp.c");
		
		process = startCommand(command);
		return process;
	}
}
