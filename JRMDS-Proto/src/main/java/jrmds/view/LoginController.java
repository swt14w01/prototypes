package jrmds.view;

import jrmds.controller.JRMDS;
import jrmds.user.UserManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController {
	@Autowired
	private UserManagement usr;
	
	@RequestMapping(value="/login")
	public String htmlOutput() {
		return "";
	}
}
