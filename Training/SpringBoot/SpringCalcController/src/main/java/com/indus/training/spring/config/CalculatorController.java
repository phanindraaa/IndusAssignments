package com.indus.training.spring.config;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	@GetMapping(value = "/add", produces = "application/json")
	public CalculatorResponse add(@RequestParam("a") double a, @RequestParam("b") double b) {
	    return new CalculatorResponse(a + b);
	}

	@GetMapping(value = "/subtract", produces = "application/json")
	public CalculatorResponse subtract(@RequestParam("a") double a, @RequestParam("b") double b) {
	    return new CalculatorResponse(a - b);
	}

	@GetMapping(value = "/multiply", produces = "application/json")
	public CalculatorResponse multiply(@RequestParam("a") double a, @RequestParam("b") double b) {
	    return new CalculatorResponse(a * b);
	}

	@GetMapping(value = "/divide", produces = "application/json")
	public CalculatorResponse divide(@RequestParam("a") double a, @RequestParam("b") double b) {
	    if (b == 0) {
	        throw new IllegalArgumentException("Cannot divide by zero");
	    }
	    return new CalculatorResponse(a / b);
	}

}
