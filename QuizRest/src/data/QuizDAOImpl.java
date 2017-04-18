package data;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.Question;
import entities.Quiz;

@Transactional
public class QuizDAOImpl implements QuizDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Quiz> index() {
		String query = "SELECT q FROM Quiz q";
		return em.createQuery(query, Quiz.class).getResultList();
	}

	@Override
	public Quiz show(int id) {
		return em.find(Quiz.class, id);
	}

	@Override
	public Quiz create(Quiz quiz) {
		em.persist(quiz);
		em.flush();
		return null;
	}

	@Override
	public Quiz update(int id, Quiz quiz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean destroy(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Question> showQuestions(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question createQuestion(int id, Question q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean destroyQuestion(int id, int questid) {
		// TODO Auto-generated method stub
		return false;
	}

}
