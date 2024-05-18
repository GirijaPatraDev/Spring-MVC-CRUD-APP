package mvcNoXml.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public String hello() {
		return "Hello From MVC with no xml and only Java Based COnfiG";
	}
	@GetMapping("/")
	public String info() {
		return "info page";
	}
}
