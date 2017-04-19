package data;

import java.util.HashSet;
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

	//DONE
	@Override
	public List<Quiz> index() {
		String query = "SELECT q FROM Quiz q";
		return em.createQuery(query, Quiz.class).getResultList();
	}
	//DONE
	@Override
	public Quiz show(int id) {
		return em.find(Quiz.class, id);
	}
	
	//DONE
	@Override
	public Quiz create(Quiz quiz) {
		em.persist(quiz);
		em.flush();
		return quiz;
	}

	//DONE
	@Override
	public Quiz update(int id, Quiz quiz) {
		Quiz q= em.find(Quiz.class, id);
		q.setName(quiz.getName());
		em.flush();
		return q;
	}

	//DONE
	@Override
	public boolean destroy(int id) {
		Quiz q = em.find(Quiz.class, id);
		em.remove(q);
		return !em.contains(q);
	}

	//DONE
	@Override
	public Set<Question> showQuestions(int id) {
		String query = "SELECT q FROM Quiz q JOIN FETCH q.questions WHERE q.id= :quizId";
		Quiz quiz = em.createQuery(query, Quiz.class)
				.setParameter("quizId", id)
				.getSingleResult();
//		new HashSet<Question> (em.createQuery(query, Question.class).setParameter("quizId", id).getResultList());
		Set<Question> questionSet = quiz.getQuestions();
		return  questionSet;
	}
	
	//DONE
	@Override
	public Question createQuestion(int quizId, Question q) {
		Quiz quiz = em.find(Quiz.class, quizId);
		q.setQuiz(quiz);
		em.persist(q);
		em.flush();
		return q;
	}

	//DONE
	@Override
	public boolean destroyQuestion(int quizId, int questionId) {
		Question question = em.find(Question.class, questionId);
		em.remove(question);
		return !em.contains(question);
	}

}
