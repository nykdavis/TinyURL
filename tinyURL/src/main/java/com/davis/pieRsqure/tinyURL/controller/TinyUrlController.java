package com.davis.pieRsqure.tinyURL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.davis.pieRsqure.tinyURL.service.TinyURLService;

@Controller
public class TinyUrlController {
	
	@Autowired
	private TinyURLService tinyURLService;
	
	@GetMapping("/homePage")
    public String showHomePage() {
        return "homePage";
    }

    @PostMapping("/generate")
    public String generateShortUrl(@RequestParam("originalUrl") String originalUrl, Model model) {
        String shortenUrl = tinyURLService.generateTinyURL(originalUrl);
        model.addAttribute("shortenUrl", shortenUrl);
        return "homePage";
    } 

}
