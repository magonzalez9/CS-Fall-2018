<?php 
class Feedback{
	# Class Properties
	protected $this->settingsFilePath = '../settings/settings.txt'; 

	// Facial features
	protected $faceWidth; 
	protected $faceHeight; 
	protected $faceXPos; 
	protected $faceYPos; 

	// Image attributes
	protected $imgWidth; 
	protected $imgHeight;

	protected $templateArray; 
	protected $imgPixelArray; 

	// Feedback msgs based on given attributes
	protected $feedback_msgs; 

	protected $targetWidth; 
	protected $targetHeight; 


	function __construct($data_array){
		// Set class properties
		$this->faceWidth = $data_array['faceWidth']; 
		$this->faceHeight = $data_array['faceHeight']; 
		$this->faceXPos = $data_array['faceXPos']; 
		$this->faceYPos = $data_array['faceYPos'];
		$this->imgWidth = $data_array['imgWidth']; 
		$this->imgPixelArray = $data_array['imgPixelArray']; 
	}

	public function getTemplateArray(){

	}

	public function setImageSettings(){
		$json_str = file_get_contents($this->settingsFilePath);

		if ($json_str !== false) {
			$jsonObj = json_decode($json_str); 

			// Set the target dimension properties 
			$this->targetWidth = $jsonObj->targetWidth; 
			$this->targetHeight = $jsonObj->targetHeight; 
		}
	}
}
?>