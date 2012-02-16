package models;

import play.*;
import javax.persistence.*;

import java.util.List;
import java.util.ArrayList;

import play.db.jpa.*;

@Entity
public class CategoryModel extends Model {
  
  public String name;
  
  @OneToMany(mappedBy="categoryModel", cascade=CascadeType.ALL)
  public List<TypeModel> typeModel;
  
  public CategoryModel(String name) {
    this.typeModel = new ArrayList<TypeModel>();
    this.name = name;
  }
}