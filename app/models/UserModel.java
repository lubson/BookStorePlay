package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class UserModel extends Model {
  
  public String username;
  public String password;

  @OneToMany(cascade=CascadeType.ALL)
  public List<PublicationModel> publications;
  
  public UserModel(String username, String password) {
    this.username = username;
    this.password = password;
    
  }
    
    public static UserModel connect(String username, String password) {
        return find("byUsernameAndPassword", username, password).first();
    }
    
  public String toString() {
	  return username + " : " + password;
  }
  
}