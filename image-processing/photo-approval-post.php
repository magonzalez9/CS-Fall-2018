<?php
require_once('class_files/feedback_class.php');

if(isset($_POST)){	
	$_POST['pixelArray'] = json_decode($_POST['pixelArray'], true); 
	$_POST['outlineArray'] = json_decode($_POST['outlineArray'], true);
	$_POST['grayscaleArray'] = json_decode($_POST['grayscaleArray'], true);  

	$feedbackObj = new Feedback($_POST);

	$feedbackObj->analyzePhoto();  

}
?>