
package controllers;

import play.*;

import play.mvc.*;

import java.net.URISyntaxException;
import java.util.*;

import models.*;

//@With(Secure.class)
public class Publication extends Controller {
    public static void index() {
    	List publications = PublicationModel.findAll();
        render(publications);
    }
    
    public static void add() {
        List categories = CategoryModel.findAll();
        render(categories);
    }
    
    public static void create(String name, Long categoryId) throws URISyntaxException {
    	Date createdTime = new Date();
    	PublicationModel publication = new PublicationModel(name, "defaultPath", createdTime);
    	System.out.println("AAAAAAAAAAAAAAAAAAA" + categoryId);
    	publication.category = CategoryModel.findById(categoryId);
    	publication.save();
    	index();
    }
    
    public static void show(Long id) {
        PublicationModel publication = PublicationModel.findById(id);
        render(publication);
    }
     
     public static void edit(Long id) {
         PublicationModel publication = PublicationModel.findById(id);
         render(publication);
     }
     
     
     //todo
     public static void save(Long id, String name) {
         CategoryModel category = CategoryModel.findById(id);
         category.name = name;
         category.save();
         show(category.id);
     }
     //todo
     public static void delete(Long id) {
        CategoryModel category = CategoryModel.findById(id);
        category.delete();
        index();
    }

}