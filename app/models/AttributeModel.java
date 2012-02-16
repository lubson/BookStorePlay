package models;

import play.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class AttributeModel extends Model {
  
  public String name;
  
  @ManyToOne
  public CategoryModel category;
  
  public AttributeModel(String name) {
	  this.name = name;
	  this.category = null;
  }
}