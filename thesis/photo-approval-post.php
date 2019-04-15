<?php
require_once('class_files/feedback_class.php');

if(isset($_POST)){	
	$_POST['filteredPixelArray'] = json_decode($_POST['filteredPixelArray'], true); 
	$_POST['outlineArray'] = json_decode($_POST['outlineArray'], true); 

	$feedbackObj = new Feedback($_POST);

	// $feedbackObj->printTemplateArray(); 
	// $feedbackObj->printPixelArray(); 
	$feedbackObj->traceOutline();  
	$feedbackObj->validateBackground(); 
	$feedbackObj->printFeedbackMsgs();

}
?>