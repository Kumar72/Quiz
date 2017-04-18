package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quiz")
public class Quiz {
	
	//fields (total:2	 fk:0)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	//ctor
	public Quiz() {
		
	}	
	public Quiz(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	//Getters and Setters (No setter for id)
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//ToString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Quiz [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
}
