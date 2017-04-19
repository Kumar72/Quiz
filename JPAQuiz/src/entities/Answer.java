package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Answer")
public class Answer {
	
	// fields (total:3 fk:1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "answer_text")
	private String answer;
	
	@Column(name="is_correct")
	private boolean correct;
	
	@ManyToOne
	@JoinColumn(name="questionId")
	private Question question;

	//ctor
	public Answer()  {
		
	}
	
	public Answer(String answer, boolean correct, Question questionId) {
		super();
		this.answer = answer;
		this.correct = correct;
		this.question = questionId;
	}

	
	//setter and getters (no setter for id)
	public int getId() {
		return id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}

	
	
	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Answer [answer=");
		builder.append(answer);
		builder.append(", correct=");
		builder.append(correct);
		builder.append(", question=");
		builder.append(question);
		builder.append("]");
		return builder.toString();
	}
}
