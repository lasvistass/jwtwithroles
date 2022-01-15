package com.akhianand.springrolejwt.controllerView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/index")
public class ControllerJsp {

	
	
	@GetMapping(value="/home")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("Home/homeController");
		return model;
	}
}
