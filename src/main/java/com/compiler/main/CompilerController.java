package com.compiler.main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.compiler.processors.CodeExecute;

@RestController
@RequestMapping("/api/code")
public class CompilerController {

	@PostMapping("/execute")
	public ResponseEntity<String> executeCode(@RequestParam("language") String language,
			@RequestParam("file") MultipartFile file) {

		try {
			String code = new String(file.getBytes());
			CodeExecute ex = new CodeExecute();
			String result = ex.execute(language, code);
			System.out.print("inside execute");
			return ResponseEntity.ok(result);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("Error executing code");
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/execute-code")
	public ResponseEntity<String> executeRawCode(@ModelAttribute CodeFile requestData) {
		String language = requestData.getLanguage();
		String code = requestData.getCode();
		try {
			String decodedCode = new String(Base64.getDecoder().decode(code), StandardCharsets.UTF_8);
			CodeExecute ex = new CodeExecute();
			String result = ex.execute(language, decodedCode);
			System.out.print("inside execute");
			return ResponseEntity.ok(result);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("Error executing code");
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/execute-with-input")
	public ResponseEntity<String> executeCodeWithInput(@ModelAttribute CodeFileWithInput requestData) {
		String language = requestData.getLanguage();
		String code = requestData.getCode();
		String input = requestData.getInput();
		try {
			String decodedCode = new String(Base64.getDecoder().decode(code), StandardCharsets.UTF_8);
			CodeExecute ex = new CodeExecute();
			String result = ex.executeWithInput(language, decodedCode, input);
			System.out.print("inside execute");
			return ResponseEntity.ok(result);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("Error executing code");
		}
	}

	@GetMapping("/test")
	public String test() {
		return "It's working";
	}
}