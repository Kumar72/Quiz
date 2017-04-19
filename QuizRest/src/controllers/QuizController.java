package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.QuizDAO;
import entities.Quiz;

@RestController
public class QuizController {
	
	@Autowired
	private QuizDAO qDao;

	//DONE
	@RequestMapping(value="ping", method=RequestMethod.GET)
	public String ping() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$ IN PING METHOD OF CONTROLLER $$$$$$$$$$$$$$$$$$$$$$$$$");
		return "pong";
	}
	
	//DONE
	@RequestMapping(value="quizzes", method=RequestMethod.GET)
	public List<Quiz> index() {
		return qDao.index();
	}
	
	//DONE
	@RequestMapping(value="quizzes/{quizId}", method=RequestMethod.GET)
	public Quiz show(int quizId) {
		return qDao.show(quizId);
	}
	
	//DONE
	@RequestMapping(value="quizzes", method=RequestMethod.POST)
	public Quiz create(@RequestBody String jsonQuiz, HttpServletResponse res) {
		res.setStatus(201);
		ObjectMapper om = new ObjectMapper();
		
		try {
			Quiz mappedQuiz = om.readValue(jsonQuiz, Quiz.class);
			return qDao.create(mappedQuiz);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//DONE
	@RequestMapping(value="quizzes/{quizId}", method=RequestMethod.PUT)
	public Quiz update(@PathVariable int quizId,@RequestBody String jsonQuiz, HttpServletResponse res) {
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!"+quizId);
		res.setStatus(202);
		ObjectMapper om = new ObjectMapper();
		
		try {
			Quiz mappedQuiz = om.readValue(jsonQuiz, Quiz.class);
			return qDao.update(quizId, mappedQuiz);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//DONE
	@RequestMapping(value="quizzes/{id}", method=RequestMethod.DELETE)
	public boolean destroy(@PathVariable int id){
		return qDao.destroy(id);
	}
	
	
}

//EXPECTED METHODS: 

//public String ping();																	DONE
//public List<Quiz> index();															DONE
//public Quiz show(int id);																DONE
//public Quiz create(String quizJSON, HttpServletResponse res);							DONE
//public Quiz update(int id, String quizJSON, HttpServletResponse res);					DONE
//public boolean destroy(int id);														DONE
//public Set<Question> showQuestions(int id);
//public Question createQuestions(int id, String questionJson, HttpServletResponse res);
//public  boolean destroyQuestions(int id, int questid);
