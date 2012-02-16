package models;

import play.*;
import javax.persistence.*;

import java.util.List;
import java.util.ArrayList;

import play.db.jpa.*;

@Entity
public class CategoryModel extends Model {
  
  public String name;
  
  @OneToMany(cascade=CascadeType.ALL)
  public List<AttributeModel> attributes;
  
  @OneToMany(cascade=CascadeType.ALL)
  public List<PublicationModel> publications;
  
  public CategoryModel(String name) {
    this.attributes = new ArrayList<AttributeModel>();
    this.publications = new ArrayList<PublicationModel>();
    this.name = name;
  }
}