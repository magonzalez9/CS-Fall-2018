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
	protected $pixelArray; 
	protected $outlineArray; 
	protected $grayscaleArray; 
	protected $outlineTraceArray;

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
	protected $minFaceXPos; 
	protected $maxFaceXPos; 
	protected $minFaceYPos; 
	protected $maxFaceYPos;  
	protected $bodyPercentage;
	protected $bgPercentage; 



	function __construct($data_array){
		// Set class properties
		$this->faceWidth = $data_array['faceWidth']; 
		$this->faceHeight = $data_array['faceHeight']; 
		$this->faceXPos = $data_array['faceXPos']; 
		$this->faceYPos = $data_array['faceYPos'];
		$this->imgWidth = $data_array['imgWidth']; 
		$this->imgHeight = $data_array['imgHeight']; 
		$this->pixelArray = $data_array['pixelArray']; 
		$this->outlineArray = $data_array['outlineArray'];
		$this->grayscaleArray = $data_array['grayscaleArray']; 
		$this->imgPixelCount = $this->imgWidth * $this->imgHeight; 	

		// Set the image template settings
		$this->setTemplateSettings(); 
		$this->getTemplateArray(); 
		
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
			$this->minFaceXPos = $jsonObj->minFaceXPos; 
			$this->maxFaceXPos = $jsonObj->maxFaceXPos; 
			$this->minFaceYPos = $jsonObj->minFaceYPos; 
			$this->maxFaceYPos = $jsonObj->maxFaceYPos; 
			$this->bodyPercentage = $jsonObj->bodyPercentage; 
			$this->bgPercentage = $jsonObj->bgPercentage; 
		}
	}


	// DEBUG ************************************************************
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

	public function printOutlineArray(){ 
		if (!empty($this->outlineArray)) {
			foreach ($this->outlineArray as $column => $row) {
				foreach ($row as $value) {
					echo $value;
				}
				echo "<br>"; 
			}
		}
	}

	public function printGrayscaleArray(){
		if (!empty($this->grayscaleArray)) {
			foreach ($this->grayscaleArray as $column => $row) {
				foreach ($row as $value) {
					echo $value;
				}
				echo "<br>"; 
			}
		}
	}
	// DEBUG ************************************************************

	public function validateFacePosition(){
		$correctFaceXPos = $this->faceXPos <= $this->maxFaceXPos && $this->faceXPos >= $this->minFaceXPos;
		$correctFaceYPos = $this->faceYPos <= $this->maxFaceYPos && $this->faceYPos >= $this->minFaceYPos;
		$xDir = ""; 
		$yDir = ""; 

		// Determine if the face is centered
		if ($correctFaceXPos && $correctFaceYPos) {
		 	// Face is in correct 
		 	$this->feedback_msgs[] = "Face is centered"; 
		 	return true; 
		 } else {
		 	# Face is not centered
		 	// Check X position 
		 	if ($this->faceXPos > $this->maxFaceXPos) {
		 		$xDir = "left"; 
		 	} else if ($this->faceXPos < $this->minFaceXPos) {
		 		$xDir = "right"; 
		 	}

		 	// Check Y position
		 	if ($this->faceYPos > $this->maxFaceYPos) {
		 		$yDir = "higher"; 
		 	} else if($this->faceYPos < $this->minFaceYPos){
		 		$yDir = "lower"; 
		 	}

		 	$this->feedback_msgs[] = "Position your body " . $yDir . " to the " . $xDir . " and make sure your shoulders fit the frame.";
		 }

		 return false; 
		  
	}// --end of function validateFacePosition

	public function validateFaceSize(){
		// Get face area
		$faceArea = $this->faceHeight * $this->faceWidth;

		// Get templateArea
		$minFaceArea = $this->minFaceHeight * $this->minFaceWidth; 
		$maxFaceArea = $this->maxFaceHeight * $this->maxFaceWidth;

		if ($faceArea >= $minFaceArea && $faceArea <= $maxFaceArea) {
		 	$this->feedback_msgs[] = "Face is approriate size";
		 	return true;  
		} else {
			if ($faceArea < $minFaceArea) {
				$this->feedback_msgs[] = "Appears you are a bit far away from the camera"; 
			} else  if($faceArea > $maxFaceArea){
				$this->feedback_msgs[] = "Appears you are too close to the camera"; 
			}
		}
		return false; 

	}

	public function fillOutlineArray(){
		$filteredPixelArray = $this->sampleImagePixels();
	
		// Combine outline and grayscale array 
		foreach ($this->grayscaleArray as $row => $columnArray) {
			foreach ($columnArray as $column => $pixelValue) {
				if (($this->outlineArray[$row][$column] == 0 && $pixelValue == 1) || ($filteredPixelArray[$row][$column] == 1)) {
					$this->outlineArray[$row][$column] = 1; 
				}	
			}
			
		}
	

		// Print newArray
		// if (!empty($this->outlineArray)) {
		// 	foreach ($this->outlineArray as $column => $row) {
		// 		foreach ($row as $value) {
		// 			echo $value;
		// 		}
		// 		echo "<br>"; 
		// 	}
		// }
	}

	public function sampleImagePixels(){
		$rgbPixelArray = array(); 

		$p = 0; 
		for ($i = 0; $i < $this->imgHeight; $i++) {
			$rgbPixelArray[$i] = array();
			for ($j = 0; $j < $this->imgWidth; $j++) {
				if ($this->rgbValidator($this->pixelArray[$p], $this->pixelArray[$p+1], $this->pixelArray[$p+2])) {
					// White pixel
					$rgbPixelArray[$i][$j] = 0; 
				} else {
					// Dark pixel 
					$rgbPixelArray[$i][$j] = 1; 
				}
				$p += 4; 
		  	}
	  	}

	    //  if (!empty($rgbPixelArray)) {
		// 	foreach ($rgbPixelArray as $column => $row) {
		// 		foreach ($row as $value) {
		// 			echo $value;
		// 		}
		// 		echo "<br>"; 
		// 	}
		// }

	  	return $rgbPixelArray; 

	} // --end of function sampleImagePixels

	public function rgbValidator($r, $g, $b){
		$rMagnitude = 20; 
		$gMagnitude = 20; 
		$bMagnitude = 20; 

		if (($r > $g) && ($r > $b)) {
			// Red is dominant, so check magnitude
			if (($r > 235) && (($r - $g) > 20) && (($r - $b) > 20)) {
				return false; 
			}

			if (($r < 235) && ((($r - $g) > 30 ) && (($r - $b) > 30))) {
				return false; 
			}

			if (($r > $g) && ($b > $g)) {
				if ( (($r - $b) > 20) && (($g-$b) > 20) ) {
					return false;
				}
			}
		} else if(($g > $r) && ($g > $b)){
			// Green is dominant color
			if ( (($g-$r) > 15) && (($g - $b) > 15) ) {
				return false; 
			}
		} else if (($b > $r) && ($b > $g)){
			// Blue is dominant color
			if ( (($b-$r) > 15) && (($b - $g) > 15)) {
				return false; 
			}

			if ((($b-$g) < 15) && (($b - $g) > 15)) {
				return false;
			}
		} else if (($r > $b) && ($g > $b)) {
			// Red and green are dominant colors 
			if ( ($r > 225) && ($g > 225) ) {
				if ($b < 200) {
					return false; 				}
			}

		} else if(($g == $r) && ($b == $r)){
			// RGB are equal
			if ($r < 195) {
			 	return false; 
			 } 
		}

		// Check for darkness
		if (($r < 165) && ($g < 155) && ($b < 155 )) {
			return false; 
		}

		return true; 
	}

	public function validateBackground(){
		// First fill outline array w/ filtered pixels + grayscale 
		$this->fillOutlineArray(); 
		$backgroundAccuracy = 0; 
		$bodyPosAccuracy = 0; 

		foreach ($this->outlineArray as $row => $columnArray) {
				foreach ($columnArray as $key => $pixelValue) {
					// Check if inside face area

					if ($pixelValue == 0) {
						$backgroundAccuracy++; 
					} else {
						$bodyPosAccuracy++; 
					}
				}
		}

		$imageArea = $this->imgHeight * $this->imgWidth; 
		$imageBGPercent = (($backgroundAccuracy/$imageArea)*100);

		// These could be adjusted by "Strictness"
		$maxBGP = $this->bgPercentage + 10; 
		$minBGP = $this->bgPercentage - 20; 

		$this->feedback_msgs[] = "bgPercentage: " . $this->bgPercentage . " vs " . $imageBGPercent ; 

		if ($imageBGPercent >= $minBGP) {
			$this->feedback_msgs[] = 'background is white'; 
		} else {
			$this->feedback_msgs[] = 'background is NOT white'; 
		}

	}

	function analyzePhoto(){
		$this->validateFacePosition(); 
		$this->validateFaceSize(); 
		$this->validateBackground(); 

		$this->printFeedbackMsgs(); 
	}

	public function printFeedbackMsgs(){
		foreach ($this->feedback_msgs as $key => $msg) {
			echo $msg . "<br />"; 
		}
	}


	public function reAdjustSettings(){
		// Useful function if image dimensions do not match those in settings
	}
}
?>