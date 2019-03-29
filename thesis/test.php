<?php
require_once('class_files/feedback_class.php');

$data_array = array(); 

$data_array['faceWidth'] = 250; 
$data_array['faceHeight'] = 200; 
$data_array['faceXPos'] = 5; 
$data_array['faceYPos'] = 5;
$data_array['imgWidth'] = 275; 
$data_array['imgPixelArray'] = 275; 

$feedbackObj = new Feedback($data_array);

$feedbackObj->getTemplateArray();

$feedbackObj->printTemplateArray(); 
?>