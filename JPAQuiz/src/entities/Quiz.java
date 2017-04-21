package entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="quiz")
public class Quiz {
	
	//fields (total:2	 fk:0)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="quiz")
	private Set<Question> questions;
	
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

	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
//	ToString
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Quiz [name=");
//		builder.append(name);
//		builder.append(", questions=");
//		builder.append(questions.size());
//		builder.append("]");
//		return builder.toString();
//	}
	

}
