package com.springproject.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	
	@GetMapping("/img")
	public String img(Model model) {
		
		String[] imgName = new File("src/main/resources/static/Images").list();
		
		model.addAttribute("imgList", imgName);
		
		return "GalleryPage";
	}

}
