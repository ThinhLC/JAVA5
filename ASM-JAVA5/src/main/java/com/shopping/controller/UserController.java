package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopping.Helper;
import com.shopping.model.UserDtls;
import com.shopping.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {
		UserDtls user = userService.checklogin(email, password);
		if (user != null) {
			Helper.setCurrentUser(session, user);
			
			return "redirect:/products";
		} else {
			model.addAttribute("error", "Invalid email or password");
			return "login";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    // Xóa thông tin người dùng khỏi session
	    session.removeAttribute("currentUser");
	    session.invalidate(); // Xóa hết các attributes của session
	    
	    // Chuyển hướng người dùng đến trang đăng nhập
	    return "redirect:/user/login";
	}
}
