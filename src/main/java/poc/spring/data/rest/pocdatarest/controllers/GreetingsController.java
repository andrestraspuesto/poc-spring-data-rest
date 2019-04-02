package poc.spring.data.rest.pocdatarest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greetings")
public class GreetingsController {
	
	@RequestMapping("/hi")
	public String hi(){
		return "hola";
	}

}
