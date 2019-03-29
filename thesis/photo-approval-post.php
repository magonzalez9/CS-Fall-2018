<?php
require_once('class_files/feedback_class.php');

if(isset($_POST)){	
	$feedbackObj = new Feedback();

	$feedbackObj->getTemplateArray(); 
}
?>