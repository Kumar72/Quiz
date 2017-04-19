package entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	// fields (total:2 fk:2)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "question_text")
	private String question;
	
	@ManyToOne
	@JoinColumn(name="quiz_id")
	private Quiz quiz;
	
	@OneToMany(mappedBy="question")
	private Set<Answer> answers;

	// ctor
	public Question() {

	}

	public Question(int id, String question, Quiz quizId) {
		super();
		this.id = id;
		this.question = question;
		quiz = quizId;
	}

	// Getters and Setters (No setter for id)
	public int getId() {
		return id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public Set<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	
	
	// ToString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Question [question=");
		builder.append(question);
		builder.append(", quiz=");
		builder.append(quiz);
		builder.append(", answers=");
		builder.append(answers);
		builder.append("]");
		return builder.toString();
	}
	
}
