package testentities;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	
	 @Before
	  public void setUp() throws Exception { 
		 emf = Persistence.createEntityManagerFactory("Persist");
		 em = emf.createEntityManager();
		 qz = em.find(Quiz.class, 1);
	 }
	 @After
	  public void tearDown() throws Exception { 
		 em.close();
		 emf.close();	 
	 }
	 
	 @Test
	 public void test_quiz_mapping() {
		assertNull(qz);
	 }
}
