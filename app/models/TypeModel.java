package models;

import play.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class TypeModel extends Model {
  
  public String name;
  
  @ManyToOne
  public CategoryModel categoryModel;
  
  public TypeModel(String name) {
    this.name = name;
  }
}