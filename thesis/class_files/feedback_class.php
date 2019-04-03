<?php 
class Feedback{
	# Class Properties
	protected $settingsFilePath = "C:\\xampp\htdocs\\thesis\\settings\\settings.txt"; 
	// protected $settingsFilePath = '/Applications/XAMPP/xamppfiles/htdocs/thesis/settings/settings.txt'; 
	protected $templatePath = "C:\\xampp\htdocs\\thesis\\settings\\template.txt"; 
	// protected $templatePath = '/Applications/XAMPP/xamppfiles/htdocs/thesis/settings/template.txt'; 

	// Facial features
	protected $faceWidth; 
	protected $faceHeight; 
	protected $faceXPos; 
	protected $faceYPos; 

	// Image attributes
	protected $imgWidth; 
	protected $imgHeight;
	protected $imgPixelCount; 
	protected $filteredPixelArray; 

	// Feedback msgs based on given attributes
	protected $feedback_msgs; 

	// Template properties
	protected $templateArray; 
	protected $templateWidth; 
	protected $templateHeight;
	protected $minFaceWidth; 
	protected $maxFaceWidth;
	protected $minFaceHeight; 
	protected $maxFaceHeight; 
	protected $minXPos; 
	protected $maxXPos; 
	protected $minYPos; 
	protected $maxYPos;  


	function __construct($data_array){
		// Set class properties
		$this->faceWidth = $data_array['faceWidth']; 
		$this->faceHeight = $data_array['faceHeight']; 
		$this->faceXPos = $data_array['faceXPos']; 
		$this->faceYPos = $data_array['faceYPos'];
		$this->imgWidth = $data_array['imgWidth']; 
		$this->imgHeight = $data_array['imgHeight']; 
		$this->filteredPixelArray = $data_array['filteredPixelArray']; 
		$this->imgPixelCount = $this->imgWidth * $this->imgHeight; 	

		// Set the image template settings
		$this->setTemplateSettings(); 
		
	}

	public function getTemplateArray(){
		$fp = fopen($this->templatePath, 'r');
		if (!$fp) {
		    echo 'Could not open file';
		}

		$row = 0; 
		$column = 0; 
		while (false !== ($pixel = fgetc($fp))) {
		    $this->templateArray[$column][$row] = $pixel;

		    if ($row == $this->templateWidth-1) {
		    	$row = 0; 
		    	$column++; 
		    } else {
		    	$row++; 
		    }
		}// --end of while

		return $this->templateArray; 
	}

	public function setTemplateSettings(){
		$json_str = file_get_contents($this->settingsFilePath);

		if ($json_str !== false) {
			$jsonObj = json_decode($json_str); 

			// Set the target dimension properties 
			$this->templateWidth = $jsonObj->templateWidth; 
			$this->templateHeight = $jsonObj->templateHeight;
			$this->minFaceWidth = $jsonObj->minFaceWidth; 
			$this->maxFaceWidth = $jsonObj->maxFaceWidth; 
			$this->minFaceHeight = $jsonObj->minFaceHeight; 
			$this->maxFaceHeight = $jsonObj->maxFaceHeight; 
			$this->minXPos = $jsonObj->minXPos; 
			$this->maxXPos = $jsonObj->maxXPos; 
			$this->minYPos = $jsonObj->minYPos; 
			$this->maxYPos = $jsonObj->maxYPos; 
		}
	}

	public function printTemplateArray(){
		if (!empty($this->templateArray)) {
			foreach ($this->templateArray as $column => $row) {
				foreach ($row as $value) {
					echo $value;
				}
				echo "<br>"; 
			}
		}
	} // --end of function printTemplateArray

	public function printPixelArray(){
		if (!empty($this->filteredPixelArray)) {
			foreach ($this->filteredPixelArray as $column => $row) {
				foreach ($row as $value) {
					echo $value;
				}
				echo "<br>"; 
			}
		}
	} // --end of function printTemplateArray

	public function validateFacePosition(){
		$correctFaceXPos = $this->faceXPos <= $this->maxXPos && $this->faceXPos >= $this->minXPos;
		$correctFaceYPos = $this->faceYPos <= $this->maxYPos && $this->faceYPos >= $this->minYPos;
		$xDir = ""; 
		$yDir = ""; 

		// Determine if the face is centered
		if ($correctFaceXPos && $correctFaceYPos) {
		 	// Face is in correct 
		 	$this->feedback_msgs[] = "Face is centered"; 
		 } else {
		 	# Face is not centered
		 	// Check X position 
		 	if ($this->faceXPos > $this->maxXPos) {
		 		$xDir = "left"; 
		 	} else if ($this->faceXPos < $this->minXPos) {
		 		$xDir = "right"; 
		 	}

		 	// Check Y position
		 	if ($this->faceYPos > $this->maxYPos) {
		 		$yDir = "up"; 
		 	} else if($this->faceYPos < $this->minYPos){
		 		$yDir = "down"; 
		 	}

		 	$this->feedback_msgs[] = "Move your face " . $xDir . " and " . $yDir;
		 }

		 #Testing printing feedback msg array
		 $this->printFeedbackMsgs();

	}// --end of function validateFacePosition

	public function validateFaceSize(){
		//
	}

	public function validateBackground(){
		$output = array();
		$backgroundAccuracy = 0; 
		$bodyPosAccuracy = 0; 
		$inaccuracy = 0; 
		for ($i=0; $i < sizeof($this->filteredPixelArray); $i++) { 
			for ($j=0; $j < sizeof($this->filteredPixelArray[$i]); $j++) { 
				if ($this->filteredPixelArray[$i][$j] == 0 && $this->templateArray[$i][$j] == 0) {
					$output[$i][$j] = '-'; 
					$backgroundAccuracy++; 
				} else if ( $this->filteredPixelArray[$i][$j] == 1 && $this->templateArray[$i][$j] == 1){
					$output[$i][$j] = '*'; 
					$bodyPosAccuracy++; 
				} else {
					$output[$i][$j] = "x";
					$inaccuracy++;  
				}
			}
		}

		// Calculate percentage of image correctness 

		// TESTING printing output array!
		foreach ($output as $column => $row) {
			foreach ($row as $value) {
				echo $value;
			}
			echo "<br>"; 
		}


	}

	public function printFeedbackMsgs(){
		foreach ($this->feedback_msgs as $key => $value) {
			echo $value . "<br />"; 
		}
	}

	public function validateBodyPosition(){

	}

	public function reAdjustSettings(){
		// Useful function if image dimensions do not match those in settings
	}
}
?>