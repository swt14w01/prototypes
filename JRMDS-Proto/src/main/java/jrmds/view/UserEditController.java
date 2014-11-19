package jrmds.view;

import jrmds.controller.JRMDS;
import jrmds.user.UserManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class UserEditController {
	@Autowired
	private UserManagement usr;
	
	@RequestMapping(value="/editUser")
	public String htmlOutput() {
		return "";
	}
}
