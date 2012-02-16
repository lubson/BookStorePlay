package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;

@Entity
public class User extends Model {
  
  public String login;
  public String password;

  @OneToMany(cascade=CascadeType.ALL)
  public List<PublicationModel> publications;
  
  public User(String login, String password) {
    this.login = login;
    this.password = password;
    
  }
    
    public static User connect(String login, String password) {
        return find("byLoginAndPassword", login, password).first();
    }
  
}