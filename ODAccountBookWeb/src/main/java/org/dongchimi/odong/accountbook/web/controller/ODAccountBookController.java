package org.dongchimi.odong.accountbook.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ODAccountBookController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String index() {
		return "signin";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	String signup() {
		return "signup";
	}

	@RequestMapping(value = "/signupSendEMail", method = RequestMethod.GET)
	String signupSendEMail() {
		return "signupSendEMail";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	String signin() {
		return "signin";
	}

	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public String settings(Model model) {
		return "settings";
	}

	@RequestMapping(value = "/assets", method = RequestMethod.GET)
	public String assets(Model model) {
		return "assets";
	}

	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	String calendar() {
		return "calendar";
	}

	@RequestMapping(value = "/apis", method = RequestMethod.GET)
	String apis() {
		return "apis";
	}
	
	@RequestMapping(value = "/settings-category", method = RequestMethod.GET)
	public String settingsCategory(Model model) {
		return "settings-category";
	}
}
