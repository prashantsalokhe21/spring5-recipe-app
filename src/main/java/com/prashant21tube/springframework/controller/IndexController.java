package com.prashant21tube.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({"","/","/index"})
	public String getIndexPage() {
		System.out.println("This is my first project!!! 1234asd");
		return "index";
	}
}
