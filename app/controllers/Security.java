package controllers;
 
import java.util.List;
import models.*;
 
public class Security extends Secure.Security {
  
  static boolean authenticate(String username, String password) {
	  System.out.println(UserModel.connect(username, password));
      return UserModel.connect(username, password) != null;
  }
  

  static boolean isSigned() {
	 return session.contains("username");
  }
  
  static void onAuthenticated() {
	  Publication.index();
  }
  
  static void onDisconnected() {
	  Publication.index();
  }

}