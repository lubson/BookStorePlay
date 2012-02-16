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
        renderJSON(category);
    }

}