$(document).ready(function(){
	console.log('LOADED');
	config();
});

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
				console.log(data);
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
	$('body').append($table);
}
 
 
var viewquiz = function(data) {
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
	$th1.append('Action');

$htr.append($th,$th1);
$thead.append($htr);

var $tbody = $('<tbody>');
	$tbody.attr('id', 'table-body');

//data.forEach(function(quiz) {
//var $id = quiz.id;
//console.log(quiz);			//test works
//
//var $tr = $('<tr>');
//	$tr.addClass('row');
//var $td = $('<td>');
//	$td.append(quiz.id + ". "+ quiz.name);
////console.log(quiz.name); 		//test works
//var $td1 = $('<td>');
//var $button = $('<button>');
//	$button.attr('id','view');
//	$button.text('VIEW');
//	
//	//Click to view all the questions by quiz
//	$button.on('click', function(e){
//		e.preventDefault();
////		console.log($id);		//works
//		$.ajax({
//		    type: "GET",
//		    url: "rest/quizzes/"+ $id,
//		    dataType: "json"
//		}).done(function(data, status){
//			viewquiz(data);
//		}).fail(function(xhr, status, error){
//			console.log(xhr);
//			console.log(status);
//			console.log(error);
//		});
//	});
//
//$td1.append($button);
//$tr.append($td,$td1);
//$tbody.append($tr);
//});

$table.append($thead, $tbody);
//	console.log($table)
$('body').append($table);
}