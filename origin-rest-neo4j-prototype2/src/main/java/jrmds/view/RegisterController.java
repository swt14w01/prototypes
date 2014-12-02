package jrmds.view;



import javax.validation.Valid;

import jrmds.controller.JrmdsMainController;
import jrmds.user.UserManagement;
import jrmds.user.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
 

@Controller
public class RegisterController {
	@Autowired
	private JrmdsMainController controller;
	@Autowired
	private UserManagement usr;
	
	//Beim Seitenaufruf wird ein leeres Objekt vom Typ WannabeUser an den Webrequest gebunden
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
	    WannabeUser wannabeuser = new WannabeUser();
	    model.addAttribute("wannabeuser", wannabeuser);
	    return "register";
	}

	//Das gefüllte WannabeUser Objekt wird hier aufgefangen und getestet. Falls keine Fehler auftreten wird ein neuer Registered User in der Datenbank angelegt.
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String checkRegistrationForm(@ModelAttribute(value="wannabeuser")@Valid WannabeUser wannabeuser, BindingResult bindingResult) {
	
		if (bindingResult.hasErrors()) {
        return "register";
    }
    return "redirect:/login";
    
	//if(!usernameAlreadyExist(wannabeuser.getUsername())) {
	//	usr.createUser(wannabeuser.getUsername(), wannabeuser.getPassword(), wannabeuser.getEmailAdress());
	//	return "success";
	//} else {
	//	return"fail";
	//	}
	} 

public Boolean usernameAlreadyExist(String username) {
	if(usr.getUser(username) == null) {
		return false;
	} else {
		return true;
	}
}



}
