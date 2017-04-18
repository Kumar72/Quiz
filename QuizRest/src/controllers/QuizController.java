package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.QuizDAO;

@RestController
public class QuizController {
	
	@Autowired
	private QuizDAO qDao;

	@RequestMapping(value="ping", method=RequestMethod.GET)
	public String ping() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$ IN PING METHOD OF CONTROLLER $$$$$$$$$$$$$$$$$$$$$$$$$");
		return "pong";
	}
}
