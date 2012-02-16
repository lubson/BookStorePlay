package models;

import play.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class CategoryModel extends Model {
  
  public String name;
  
  public CategoryModel(String name) {
    this.name = name;
  }
}