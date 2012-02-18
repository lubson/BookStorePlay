package controllers;

import java.util.List;

import play.mvc.Controller;

import models.UserModel;

public class User extends Controller{

	public static void signUp() { 
		render();
	}
	
	public static void createUser(String username, String password) {
	      UserModel user = new UserModel(username, password);
	      user.save();
	      
	      UserModel testUser = UserModel.connect(username, password);
	      System.out.println("Created: " + testUser.username + " : " + testUser.password);
	      Publication.index();
	   }
	
}
