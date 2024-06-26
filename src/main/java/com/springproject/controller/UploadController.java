package com.springproject.controller;

import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@GetMapping("/upload")
	public String getUpload(HttpSession session) {
		
		if (session.getAttribute("validuser") == null) {

			return "LoginForm";
		}
		
		

		return "UploadForm";
	}

	@PostMapping("/upload")
	public String postupload(@RequestParam MultipartFile image, Model model, HttpSession session) {
		
		if (session.getAttribute("validuser") == null) {

			return "LoginForm";
		}

		if (!image.isEmpty()) {

			try {
				Files.copy(image.getInputStream(),Path.of("src/main/resources/static/Images/" + image.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
				
				model.addAttribute("message", "Photo Uploaded Successfully!");

				return "UploadForm";
				
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		model.addAttribute("error", "Upload Failed!");
		return "UploadForm";
	}

}