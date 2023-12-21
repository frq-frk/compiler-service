package com.compiler.file.utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
	public static void createTempFile(String code, String fileName) throws IOException {
		try (FileWriter writer = new FileWriter(fileName)) {
			writer.write(code);
		}
	}
}
