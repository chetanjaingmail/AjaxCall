package com.example.AjaxCall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WellcomeController {

	
	
@GetMapping("/index")
public String getIndexPage() {
	
	return "index" ;
}
}
