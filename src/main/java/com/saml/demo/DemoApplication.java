package com.saml.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class DemoApplication {

	@RequestMapping("/")
	public String index() {
		return "home";
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/secured/hello")
	public String hello(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, Model model) {
		model.addAttribute("name", principal.getName());
		return "hello";
	}
}
