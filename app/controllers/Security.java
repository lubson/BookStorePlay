package controllers;
 
import models.*;
 
public class Security extends Secure.Security {
  
  static boolean authenticate(String username, String password) {
      return User.connect(username, password) != null;
  }
  
  static boolean check(String profile) {
    if("admin".equals(profile)) {
          return Secure.Security.isConnected();
      } 
    return false;
  }

  public static void getSignUp(String login, String password) {
    render();

  }


   public static void postSignUp(String login, String password) {
      User user = new User(login, password);
      user.save();
      Publication.index();
   }
    
}