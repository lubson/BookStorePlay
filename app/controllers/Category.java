package controllers;

import java.util.*;

import play.*;
import play.mvc.*;

import models.*;

public class Category extends Application {
    
    public static void index() {
        List categories = CategoryModel.findAll();
        render(categories);
    }
    
    public static void create(String name) {
        CategoryModel category = new CategoryModel(name);
        category.save();
        show(category.id);
        //renderJSON(category); 
    }
    
    public static void show(Long id) {
        CategoryModel category = CategoryModel.findById(id);
        render(category);
    }
     
    public static void edit(Long id) {
         CategoryModel category = CategoryModel.findById(id);
         render(category);
    }
     
    public static void save(Long id, String name, List<String> attributes) {
      CategoryModel category = CategoryModel.findById(id);
      category.name = name;
      category.attributes.clear();
      if (!(attributes == null)) {
        List<AttributeModel> convertedAttributes = new ArrayList<AttributeModel>();
        for (String attribute : attributes) {
          category.addAttribute(attribute);
        }
      }
       
      category.save();
      show(category.id);
    }
    
    public static void delete(Long id) {
      CategoryModel category = CategoryModel.findById(id);
      category.delete();
      index();
    }
}