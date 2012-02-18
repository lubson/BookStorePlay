package controllers;

import java.util.List;

import play.data.validation.Required;
import play.mvc.Controller;
import sun.text.normalizer.ICUBinary.Authenticate;

import models.UserModel;

public class User extends Controller{

	public static void signUp(String username) { 
		render(username);
	}
	
	public static void createUser(@Required String username, @Required String password, 
			@Required String confirmPassword) throws Throwable {
		if (!password.equals(confirmPassword)){
	    	validation.addError("password", "Passwords are not equal!");
	    }
		if (password.length() < 4){
	    	validation.addError("password", "Password must be at least 4 characters long!");
	    }
		
		if (validation.hasErrors()) {
			flash.error("Some fields are not filled correctly");
			signUp(username);
		}
		UserModel user = new UserModel(username, password);
	    user.save();
	    Secure.authenticate(username, password, false);
	   }
	
}
