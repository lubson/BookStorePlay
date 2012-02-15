package controllers;
 
import java.util.List;
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

  static boolean isSigned() {
    return true;
  }

  public static void showSignUp() {
    //User user = new User("assa","");
    render();

  }

   public static void createSignUp(String login, String password) {
      User user = new User(login, password);
      user.save();
      List list = User.findAll();
      System.out.println(list);
      Publication.index();
   }
    
}