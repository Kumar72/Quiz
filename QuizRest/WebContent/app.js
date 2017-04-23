$(document).ready(function(){
	console.log('LOADED');
	home();
	config();
});

var reload = function() {
	$('#main-table').remove();
	$('#question-table').remove();
	config();
}

var home = function() {
$('h1').on('click', function(){
		reload();
	})
var bool = false;
	$('#create').click(function(){
		var $createform = $('#quiz-form');
		console.log($createform.length);
		if(!$createform.length){
			console.log('in if');
			createQuiz();
			$('#create').text('Hide Quiz Option')
			reload();
		}
		else{
			$('#quiz-form').remove();
			console.log('in else');
			$('#create').text('Show Quiz Option')
		}
	
	//	$('#quiz-form').toggle();
	});

}

var config = function() {	
	$.ajax({
	    type: "GET",
	    url: "rest/quizzes",
	    dataType: "json"
	}).done(function(data, status){
		datatable(data);
		console.log(data);
	}).fail(function(xhr, status, error){
		console.log(xhr);
		console.log(status);
		console.log(error);
	});
}

 var datatable = function(data) {
	var $table = $('<table>');
		$table.attr('id', 'main-table');
		$table.addClass('table');
	var $thead = $('<thead>');
		$thead.attr('id', 'table-head');
	var $htr = $('<tr>');
		$htr.addClass('row');
	var $th = $('<th>');
		$th.append('Quiz')
	var $th1 = $('<th>');
		$th1.append('Action');
	
	$htr.append($th,$th1);
	$thead.append($htr);
	
	var $tbody = $('<tbody>');
		$tbody.attr('id', 'table-body');
	
	data.forEach(function(quiz) {
	var $id = quiz.id;
	console.log(quiz);			//test works
	
	var $tr = $('<tr>');
		$tr.addClass('row');
	var $td = $('<td>');
		$td.append(quiz.id + ". "+ quiz.name);
//	console.log(quiz.name); 		//test works
	var $td1 = $('<td>');
	var $button = $('<button>');
		$button.attr('id','view');
		$button.text('VIEW');
		
		//Click to view all the questions by quiz
		$button.on('click', function(e){
			e.preventDefault();
//			console.log($id);		//works
			$.ajax({
			    type: "GET",
			    url: "rest/quizzes/"+ $id + "/questions",
			    dataType: "json"
			}).done(function(data, status){
//				console.log(data);
				viewquiz(data);
			}).fail(function(xhr, status, error){
				console.log("done");
				console.log(xhr);
				console.log(status);
				console.log(error);
			});
		});
	
	$td1.append($button);
	$tr.append($td,$td1);
	$tbody.append($tr);
	});
	
	$table.append($thead, $tbody);
// 	console.log($table)
	$('div').prepend($table);
}
 
 
var viewquiz = function(data) {
	data.sort(function(a,b){
		return a.id > b.id;
	})
//	console.log(data);		//getting an array of question obj
	$('h1').text(data.name);
	$('#main-table').remove();
	var $table = $('<table>');
		$table.addClass('table');
		$table.attr('id','question-table');
	var $thead = $('<thead>');
		$thead.addClass('table-head');
	var $htr = $('<tr>');
		$htr.addClass('row');
	var $th = $('<th>');
		$th.append('Questions')
	var $th1 = $('<th>');
		$th1.append('A');
	var $th2 = $('<th>');
		$th2.append('B');
	var $th3 = $('<th>');
		$th3.append('C');
	var $th4 = $('<th>');
		$th4.append('D');
	
	$htr.append($th,$th1,$th2,$th3,$th4);
	$thead.append($htr);
	
	var $tbody = $('<tbody>');
	$tbody.attr('id', 'table-body');
	
	data.forEach(function(question) {
	var $id = question.id;
	console.log(question);			//test works
	
	var $tr = $('<tr>');
		$tr.addClass('row');
	var $td = $('<td>');
		$td.append(question.id + ". "+ question.question);
	var $td1 = $('<td>');
		$td1.append(question.answers[0].answer);
	var $td2 = $('<td>');
		$td2.append(question.answers[1].answer);
	var $td3 = $('<td>');
		$td3.append(question.answers[2].answer);
	var $td4 = $('<td>');
		$td4.append(question.answers[3].answer);
	
	
	$tr.append($td,$td1,$td2,$td3,$td4);
	$tbody.append($tr);
});

$table.append($thead, $tbody);
//	console.log($table)
$('div').prepend($table);
}


function createQuiz() {
	var $form = $('<form>');
		$form.attr('name', 'createForm');
		$form.attr('id', 'quiz-form');
	var $fieldset = $('<fieldset>');
		$fieldset.addClass('form-group');
	var $label = $('<label>');
		$label.text('Quiz Name: ');
	var $input = $('<input>');
		$input.attr('type','text');
		$input.attr('name','qname');
		$input.addClass('form-input');
	var $button = $('<button>');
		$button.text('Create');
		$button.attr('name', 'submit')
		$button.click(function(e){
			e.preventDefault();

			var quiz = {
				name: $(createForm.qname).val()
			}
			console.log(quiz);
			$.ajax({
				type: 'POST',
				url: 'rest/quizzes',
				dataType: 'json',
				data: JSON.stringify(quiz),
				contentType: 'application/json'
			}).done(function(data, status){
				reload();
				
			}).fail(function(xhr, status, error){
				console.log("done");
				console.log(xhr);
				console.log(status);
				console.log(error);
			});
			
		})
	$fieldset.append($label, $input,$button);
	$form.append($fieldset);
	$('div').append($form);
}
