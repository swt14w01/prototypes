package jrmds.view;



import javax.validation.Valid;

import jrmds.controller.JrmdsMainController;
import jrmds.user.UserManagement;
import jrmds.user.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
 

@Controller
public class RegisterController {
	@Autowired
	private JrmdsMainController controller;
	@Autowired
	private UserManagement usr;
	
	@RequestMapping(value = "/register")
	public String showRegistrationForm(WebRequest request, Model model) {
	    WannabeUser wannabeuser = new WannabeUser();
	    model.addAttribute("wannabeuser", wannabeuser);
	    return "register";
	}
	
@RequestMapping(value = "/reg")
public String reg(@ModelAttribute(value="wannabeuser")@Valid WannabeUser wannabeuser) {
	if(!usernameAlreadyExist(wannabeuser.getUsername())) {
		usr.createUser(wannabeuser.getUsername(), wannabeuser.getPassword(), wannabeuser.getEmailAdress());
		return "success";
	} else {
		return"fail";
		}
	} 

public Boolean usernameAlreadyExist(String username) {
	if(usr.getUser(username) == null) {
		return false;
	} else {
		return true;
	}
}



}
