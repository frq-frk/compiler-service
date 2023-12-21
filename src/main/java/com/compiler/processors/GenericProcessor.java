package com.compiler.processors;

import java.io.IOException;

public abstract class GenericProcessor {
	public Process getProcess(String code) throws IOException, InterruptedException {
		return null;
	}
	
	public static Process startCommand(String command) throws IOException {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            // Windows OS
            return Runtime.getRuntime().exec(new String[]{"cmd", "/c", command});
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            // Unix-like OS (Linux, macOS)
            return Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", command});
        } else {
            throw new UnsupportedOperationException("Unsupported operating system");
        }
    }
}
