package com.compiler.processors.cpp;

import java.io.IOException;

import com.compiler.file.utils.FileUtils;
import com.compiler.processors.GenericProcessor;

public class CppProcessor extends GenericProcessor{
	@Override
	public Process getProcess(String code) throws IOException {
		Process process = null;
		String command = "";
		
		command = "g++ -o temp_cpp_exec temp.cpp && ./temp_cpp_exec";
		FileUtils.createTempFile(code, "temp.cpp");
		process = startCommand(command);
		
		return process;
	}
}
