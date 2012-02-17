
package controllers;

import play.*;

import play.data.Upload;
import play.mvc.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
    
    public static void create(String name, Long categoryId, Upload file) throws URISyntaxException, IOException {
    	
    	String pathOnServer = "public/publications/" + file.getFileName();
    	Date createdTime = new Date();
    	
    	byte[] buffer = new byte[8 * 1024];
    	
    	InputStream input = file.asStream();
    	try {
    	  OutputStream output = new FileOutputStream(pathOnServer);
    	  try {
    	    int bytesRead;
    	    while ((bytesRead = input.read(buffer)) != -1) {
    	      output.write(buffer, 0, bytesRead);
    	    }
    	  } finally {
    	    output.close();
    	  }
    	} finally {
    	  input.close();
    	}
    	
    	
    	    	
    	PublicationModel publication = new PublicationModel(name, pathOnServer, createdTime);
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
     
     public static void list() {
    	 List publications = PublicationModel.findAll();
    	 render(publications);
     }

}