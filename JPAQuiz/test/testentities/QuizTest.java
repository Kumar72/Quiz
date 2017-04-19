package testentities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Answer;
import entities.Question;
import entities.Quiz;

public class QuizTest {
	
	@Test		//Basic test
	public void test() {
		boolean pass = true;
		assertEquals(pass, true);
	}
//--------------------------------------------------------------/
	
	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Quiz qz;
	private Question question;
	private Answer ans;
	
	 @Before
	  public void setUp() throws Exception { 
		 emf = Persistence.createEntityManagerFactory("Persist");
		 em = emf.createEntityManager();
		 qz = em.find(Quiz.class, 1);
		 question = em.find(Question.class, 3);
		 ans = em.find(Answer.class, 10);
	 }
	 @After
	  public void tearDown() throws Exception { 
		 em.close();
		 emf.close();	 
	 }
	
	 
	 
	 @Test
	 public void test_quiz_mapping() {
		assertEquals("Basic Math", qz.getName());
	 }
	 
	 @Test
	 public void test_question_mapping() {
		 assertEquals("States", question.getQuiz().getName());
	 }
	 
	 @Test
	 public void test_answer_mapping() {
		 assertEquals("States", ans.getQuestion().getQuiz().getName());
	 }
}
