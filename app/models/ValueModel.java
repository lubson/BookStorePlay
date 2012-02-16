package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class ValueModel extends Model {

	public String value;
	
	@ManyToOne
	public PublicationModel publication;
	
	@ManyToOne
	public AttributeModel attribute;
}
