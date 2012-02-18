package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;

import java.util.*;
import java.net.URI;
import java.net.URISyntaxException;

@Entity
public class PublicationModel extends Model{
	
	
	
	@ManyToOne
	public UserModel user;
	
	@ManyToOne 
	public CategoryModel category;
	
	@OneToMany(cascade=CascadeType.ALL)
	public List<ValueModel> values;
	
	public String name;
	public URI path;
	public Date createdTime;
	
	public PublicationModel(String name, URI path, Date createdTime) {
		this.name = name;
		this.user = null;
		this.category = null;
		this.path = path;
		this.createdTime = createdTime;
	}
	
	public PublicationModel(String name, String path, Date createdTime) throws URISyntaxException {
		this.name = name;
		this.user = null;
		this.category = null;
		this.path = new URI(path);
		this.createdTime = createdTime;
	}
	
	public String toString(){
		return name + " : " + path + " : " + category.name;	
	}
}
