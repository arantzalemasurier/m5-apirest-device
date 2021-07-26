package com.example.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller // Spring MVC con redireccion a plantillas html dentro del pryecto
// @Component // Anotación genérica para clases que no recaen en ninguna capa

@RequestMapping("/api") // Enrutado HTTP
@RestController
public class HelloController {

	private final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	/**
	 * http://localhost:8081/api/hello
	 */
	@GetMapping("/hello")
	public String hello() {
	
		log.info("Executing hello world method from logger");
		// diferentes niveles de logger:
		// log.warn("Executing hello world method from logger");
		// log.error("Executing hello world method from logger");
		return "Hola mundo";
		
	}
}
