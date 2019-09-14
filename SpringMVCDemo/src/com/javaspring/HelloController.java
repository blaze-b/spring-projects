package com.javaspring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author Brian
 *
 */
@Controller
public class HelloController {
	@RequestMapping("/")
	public String display() {
		return "index";
	}

	@RequestMapping("/hello")
	public String redirect() {
		return "viewpage";
	}

	@RequestMapping("/helloagain")
	public String display1() {
		return "final";
	}

	@RequestMapping("/login")
	public String display2(HttpServletRequest req, Model m) {
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		if (pass.equals("admin")) {
			String msg = "Hello " + name;
			// add a message to the model
			m.addAttribute("message", msg);
			return "welcome";
		} else {
			String msg = "Sorry " + name + ". You entered an incorrect password";
			m.addAttribute("message", msg);
			return "errorpage";
		}

	}
}
