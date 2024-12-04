package com.example.AmazonWebToolClone.Controller;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
       
	@GetMapping("/")
	public String homepage() {
		return "signinpage";
	}
}
