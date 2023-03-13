package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAppController {
	
	@GetMapping("/get")
	String resource() {
		return "Got the resource" ;
	}

}
