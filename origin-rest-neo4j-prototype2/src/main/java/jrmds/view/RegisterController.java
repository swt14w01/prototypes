package jrmds.view;

import jrmds.controller.JrmdsMainController;
import jrmds.user.UserManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
	@Autowired
	private JrmdsMainController jrmdsMainController;
	@Autowired
	private UserManagement usr;
	
	@RequestMapping(value="/register")
	public String htmlRegister() {
		return "";
	}
}
