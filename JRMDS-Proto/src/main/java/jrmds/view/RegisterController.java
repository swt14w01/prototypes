package jrmds.view;

import jrmds.controller.JRMDS;
import jrmds.user.UserManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
	@Autowired
	private JRMDS ctlr;
	@Autowired
	private UserManagement usr;
	
	@RequestMapping(value="/register")
	public String htmlRegister() {
		return "";
	}
}
