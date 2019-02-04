package com.evaluation.counter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.counter.service.CounterService;

@RestController
@RequestMapping("/counter")
public class EvalutionController {

	@Autowired
	private CounterService counterService;
	
	
    /**
     * API to Increment counter in DB
     * 
     * @return String
     */
	@RequestMapping(value = "/increase", method = RequestMethod.GET)
	public String increaseCounter() {
		try {
			counterService.increaseCounter();
		} catch (Exception e) {
			return "failed";
		}
		return "success";

	}

}
