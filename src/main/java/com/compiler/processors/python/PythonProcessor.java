package com.compiler.processors.python;

import java.io.IOException;
import java.io.PrintWriter;

import com.compiler.file.utils.FileUtils;
import com.compiler.processors.GenericProcessor;

public class PythonProcessor extends GenericProcessor{
	
	@Override
	public Process getProcess(String code) throws IOException {
		Process process = null;
		String command = "";
		FileUtils.createTempFile(code, "temp.py");
		command = "python temp.py";
		process = startCommand(command);
		return process;
	}	
}