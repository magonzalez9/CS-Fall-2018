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
	protected $faceCount; 

	// Feedback msgs based on given attributes
	// Contains sub arrays of errors, suggestions and positive feedback
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
		$this->faceCount = $data_array['faceCount'];
		$this->imgPixelCount = $this->imgWidth * $this->imgHeight; 	

		// Set the image template settings
		$this->setTemplateSettings(); 
		$this->getTemplateArray(); 
		
	}

	// Function: setTempleateSettings
	// Description: Sets all of the template settings based on JSON file
	// Parameters: None
	// Returns: None
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
	}// --end of function setTemplateSettings

	// Function: getTemplateArray
	// Description: Sets the template array property by getting values from template array file
	// Parameters: None
	// Returns: templateArray 
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
	}// --end of function getTemplateArray

	// Function: validateFaceSize
	// Description: Determines whether face is appropriate size
	//              e.g. Individual is too close or too far
	// Parameters: None
	// Returns: None
	public function validateFaceSize(){
		// Get face area
		$faceArea = $this->faceHeight * $this->faceWidth;

		// Get templateArea
		$minFaceArea = $this->minFaceHeight * $this->minFaceWidth; 
		$maxFaceArea = $this->maxFaceHeight * $this->maxFaceWidth;

		if ($faceArea >= $minFaceArea && $faceArea <= $maxFaceArea) {
		 	$this->feedback_msgs['positive'][] = "You are at an appropriate distance from the camera";
		 	return true;  
		} else {
			if ($faceArea < $minFaceArea) {
				if ( (abs($minFaceArea)/$faceArea) > 4) {
					$this->maxFaceXPos -= 20; 
					$this->minFaceXPos += 20; 
					$this->feedback_msgs['error'][] = "You are too far away from the camera"; 
				} else {
					$this->feedback_msgs['error'][] = "You are slightly far away from the camera";
				}
				
			} else  if($faceArea > $maxFaceArea){
				$this->feedback_msgs['error'][] = "You are too close to the camera"; 
			}
		}

		if (array_key_exists('error', $this->feedback_msgs)) {
			$this->feedback_msgs['suggestions'][] = "Use the cropping tool slider to adjust the magnification";
		}
		return false; 

	}

	// Function: validateFacePosition
	// Description: Determines wheter face's position is appropriate
	// Parameters: None
	// Returns: None
	public function validateFacePosition(){
		$correctFaceXPos = $this->faceXPos <= $this->maxFaceXPos && $this->faceXPos >= $this->minFaceXPos;
		$correctFaceYPos = $this->faceYPos <= $this->maxFaceYPos && $this->faceYPos >= $this->minFaceYPos;
		$xDir = ""; 
		$yDir = ""; 
		$facePosition = ""; 

		// Determine if the face is centered
		if ($correctFaceXPos && $correctFaceYPos) {
		 	// Face centered
		 	$facePosition = "centered"; 
		 	if (array_key_exists('error', $this->feedback_msgs)) {
		 		if (in_array("You are too close to the camera", $this->feedback_msgs['error']) || in_array("You are too far away from the camera", $this->feedback['error'])) {
		 			$this->feedback_msgs['positive'][] = "Face appears to be centered";
			 	} else {
					$this->feedback_msgs['positive'][] = "Shoulders fit the frame"; 
			 	}
		 	} else {
		 		$this->feedback_msgs['positive'][] = "Shoulders fit the frame"; 
		 	}
		 	
		 	
		 } else {
		 	# Face is not centered
		 	// Check X position 
		 	if ($this->faceXPos > $this->maxFaceXPos) {
		 		$xDir = "left"; 
		 	} else if ($this->faceXPos < $this->minFaceXPos) {
		 		$xDir = "right"; 
		 	}
		 	$facePosition = $xDir; 

		 	// Check Y position
		 	if ($this->faceYPos > $this->maxFaceYPos) {
		 		$yDir = "higher"; 
		 	} else if($this->faceYPos < $this->minFaceYPos){
		 		$yDir = "lower"; 
		 	}

		 	//Check X and Y position displacement
		 	if ($xDir != "" && $yDir != "") {
		 		// Both X and Y positions are incorrect so add error/suggestion message to feedback array
		 		$this->feedback_msgs['error'][] = "Your body position is off-center";
		 		$this->feedback_msgs['suggestions'][] = "Use the cropping tool to position yourself " . $yDir . " to the " . $xDir . " and ensure your shoulders fit the frame";
		 	} else if ($xDir != "") {
		 		// Only X is incorrect meaning individual's body position is either too far right or too far left
		 		$this->feedback_msgs['error'][] = "Your body position is off-center";
		 		$this->feedback_msgs['suggestions'][] = "Use the cropping tool to reposition yourself slightly to the " . $xDir . " and ensure your shoulders fit the frame";  
		 	} else{
		 		// Only Y is incorrect meaning individual's body position is either to high or too low
		 		if ($yDir == "higher") {
		 			$this->feedback_msgs['suggestions'][] = "Use the cropping tool to raise your body position and ensure your shoulders fit the frame"; 
		 		} else {
		 			$this->feedback_msgs['suggestions'][] = "Use the croppin tool to lower your body position and ensure your shoulders fit the frame";
		 		}

		 		// Since X position is correct, it means face is centered
		 		$this->feedback_msgs['positive'][] = "Your face position is centered";
		 		 
		 	}
		 	
		 }

		 return $facePosition; 
		  
	}// --end of function validateFacePosition

	// Function: validateBackground
	// Description: Validates the photo's bg color by making sure background is appropriate color
	// Parameters: None
	// Returns: None
	public function validateBackground(){
		// First fill outline array w/ filtered pixels + grayscale 
		$this->fillOutlineArray(); 
		$facePosition = $this->validateFacePosition(); 

		$backgroundAccuracy = 0; 
		$bodyPosAccuracy = 0; 

		// Determine bounds of face location
		$leftMax = round($this->faceXPos - ($this->faceWidth/2));
		$rightMax = round(($this->faceWidth/2) + $this->faceXPos);
		$topMax = round($this->faceYPos - ($this->faceHeight/2)); 
		$bottomMax = round(($this->faceHeight/2) + $this->faceYPos);

		// Determine what portion of the background we want examine based on face location 
		$bgSampleResult = $this->sampleBackground($leftMax, $rightMax, $facePosition); 

		foreach ($this->outlineArray as $row => $columnArray) {
				foreach ($columnArray as $column => $pixelValue) {
					// Check if inside face area
					if ( ($column < $rightMax) && ($column > $leftMax) && ($row > $topMax) ) {
						$this->outlineArray[$row][$column] = 1; 
						$bodyPosAccuracy++; 
					} else if($pixelValue == 0) {
						$backgroundAccuracy++; 
					} else {
						$bodyPosAccuracy++; 
					}
				}
		}

		// Calculate the appropriate background color percentage
		$imageArea = $this->imgHeight * $this->imgWidth; 
		$imageBGPercent = (($backgroundAccuracy/$imageArea)*100);

		// These could be adjusted by "Strictness"
		$maxBGP = $this->bgPercentage + 10; 
		$minBGP = $this->bgPercentage - 25; 

		 if (($imageBGPercent >= $minBGP) && ($imageBGPercent > 40)) {
		 	if (($bgSampleResult == false)) {
		 		$this->feedback_msgs['error'][] = "Background color is predominantly white but non-white portions detected"; 
		 	} else {
		 		$this->feedback_msgs['positive'][] = "Background color is white";
		 	}
		 } else if (($imageBGPercent >= $minBGP) && ($bgSampleResult == true)) {
			$this->feedback_msgs['positive'][] = "Background color is white"; 
		 } else {
			$this->feedback_msgs['error'][] = "Invalid background color detected"; 
			$this->feedback_msgs['suggestions'][] = "Try uploading a photo with a whiter background color";
		 }

	}// --end of function validateBackground

	// Function: analyzePhoto
	// Description: Compiles all of the validation methods into one method
	// Parameters: None
	// Returns: None
	public function analyzePhoto(){
		if ($this->faceCount > 1) {
			$this->feedback_msgs['error'][] = "It appears there are multiple people in your photo";
		} else {
			$this->validateFaceSize();
			$this->validateBackground(); 
		}
		
		$this->printFeedbackMsgs(); 
	}

	// Function: fillOutlineArray
	// Description: Fills the outline array
	// Parameters: None
	// Returns: None
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
	}// --end of function fillOutlineArray

	// Function: sampleImagePixels
	// Description: Samples ALL image pixels and categorizes them based on RGB color
	// Parameters: None
	// Returns: filtered pixel array containing validated pixels
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

	  	return $rgbPixelArray; 

	} // --end of function sampleImagePixels

	// Function: sampleBackground
	// Description: determines which background portions to sample
	// Parameters: $leftMax - X location of left side of face
    //             $rightMax - X location of right side of face
    //             $facePosition - Str value of face location 
	// Returns: Boolean false if large portion of invalide colors exist, true otherwise
	public function sampleBackground($leftMax, $rightMax, $facePosition){
		if ($facePosition == "left") {
			return $this->sampleLeftPortionOfBG($rightMax); 
		} else if ($facePosition == "right") {
			return $this->sampleRightPortionOfBG($leftMax); 
		} 

		return ($this->sampleLeftPortionOfBG($leftMax) == true && $this->sampleRightPortionOfBG($rightMax) == true);
	}// --end of function sampleBackground

	// Function: sampleLeftPortionOfBG
	// Description: Takes a small sample the left side of the image background and determines if 
	//              invalid colors exist
	// Parameters: 
	//           - $leftMax - X location of left side of face
	// Returns: Boolean false if large portion of invalide colors exist, true otherwise
	public function sampleLeftPortionOfBG($leftMax){
		// Sample outline array background to make sure there are no shadows or dark
		$sampleCount = 0; 
		$invalidPixelCount = 0; 
		$rowMax = sizeof($this->outlineArray)/2;
		$columnMax = sizeof($this->outlineArray)/2;

		for ($row=0; $row < $rowMax; $row++) { 
			for ($col=0; $col < $columnMax; $col++) { 
				$outOfFaceArea = ($col < ($leftMax-25));

				if ($outOfFaceArea) {
					if($this->outlineArray[$row][$col] == 1){
						$this->outlineArray[$row][$col] = 'P';
						$invalidPixelCount++; 
					}
				} else {
					break 1; 
				}
				$sampleCount++;
			}
			$columnMax-=1; 
		}// --end of foreach

	
		// Calculate results
		$invalidPixelPercent = (($invalidPixelCount/$sampleCount)*100); 

		if ($sampleCount > 1000 && $invalidPixelPercent > 15) {
			return false;
		} else {
			return true; 
		}	
	} // --end of sampleLeftPortionOfBG

	// Function: sampleRightPortionOfBG
	// Description: Takes a small sample the right side of the image background and determines if 
	//              invalid colors exist
	// Parameters: 
	//           - $rightMax - X location of right side of face
	// Returns: Boolean false if large portion of invalide colors exist, true otherwise
	public function sampleRightPortionOfBG($rightMax){
		// Sample outline array background to make sure there are no shadows or dark
		$sampleCount = 0; 
		$invalidPixelCount = 0; 
		$rowMax = sizeof($this->outlineArray)/2;
		$columnMax = sizeof($this->outlineArray)/2;

		for ($row=0; $row < $rowMax; $row++) { 
			for ($col=sizeof($this->outlineArray[$row])-1; $col > $columnMax; $col--) { 
				$outOfFaceArea = ($col > ($rightMax+25));

				if ($outOfFaceArea) {
					if($this->outlineArray[$row][$col] == 1){
						$this->outlineArray[$row][$col] = 'P';
						$invalidPixelCount++; 
					}
				} else {
					break 1; 
				}
				$sampleCount++;

			}
			$columnMax+=1; 
		}// --end of foreach

		// Calculate results
		$invalidPixelPercent = (($invalidPixelCount/$sampleCount)*100); 

		if ($sampleCount > 1000 && $invalidPixelPercent > 15) {
			return false;
		} else {
			return true; 
		}
	} // --end of sampleRightPortionOfBG

	// Function: rgbValidator	
	// Description: Validates rgb values of pixel
	// Parameters: RGB color pixel value
	//			   $r - red, $g - green, $b - blue
	// Returns: Boolean true if pixel is appropriate color, false otherwise
	public function rgbValidator($r, $g, $b){
		$rMagnitude = 20; 
		$gMagnitude = 20; 
		$bMagnitude = 20; 

		if (($r > $g) && ($r > $b)) {
			// Red is dominant color
			if ((abs(($r - $g)) > 20) && (abs(($r - $b)) > 20)) {
				return false; 
			}

			if ( (($r < 215) && ($g < 215)) && (abs(($r - $g)) < 15) && abs($r - $b) > 25) {
				return false;
			}

			if ((($r < 200) && ($b < 200)) && (abs(($r - $g)) > 15)) {
				return false; 
			}

			if (($r > $g) && ($b > $g)) {
				if ( (($r - $b) > 20) && (($g-$b) > 20) ) {
					return false;
				}
			}
		}

		if(($g > $r) && ($g > $b)){
			// Green is dominant color
			if ((abs(($g-$r)) > 15) && (abs(($g - $b)) > 15) ) {
				return false; 
			}

			if ((($g < 200) && ($r < 200)) && (($g-$r) <15) ) {
				if (($g-$b) > 25) {
					return false; 
				}
			}
		}

		// Green and Blue are dominant colors 
		if ((abs($g - $b) < 10) && ($g > $r) && ($b > $r)) {
				if ( (abs($g-$r) > 15) || (abs($b-$r) > 15) ) {
						return false; 
				}
		}

		// Blue is dominant color
		if (($b > $r) && ($b > $g)){
			if ( (($b-$r) > 15) && (($b - $g) > 15)) {
				return false; 
			}

			if ((($b-$g) < 15) && (($b - $g) > 15)) {
				return false;
			}
		}

		if (($b > $g) && ($r > $g) && ($b > $r)) {
			// Blue and Red are dominant colors (Blue is main)
			if ((abs($b - $r) < 10) && ($b - $g) > 10 ) {
				return false; 
			}

		}

		if (($r > $b) && ($g > $b)) {
			// Red and green are dominant colors 
			if ( ($r > 225) && ($g > 225) ) {
				if ($b < 200) {
					return false; 				}
			}
		}

		if(($g == $r) && ($b == $r)){
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

	// Function: 
	// Description:
	// Parameters
	// Returns
	public function printFeedbackMsgs(){

		echo "<h2>Feedback</h2>";
		echo "<ul>";
		foreach ($this->feedback_msgs as $msg_type => $msg_array) {
			if ($msg_type != 'suggestions') {			
				foreach ($msg_array as $key => $msg) {
					if ($msg_type == 'positive') {
						echo "<li>" . $msg . " &#10004;</li>"; 
					} else {
						echo "<li>" . $msg . " &#10006;</li>"; 
					}
				}
			}
		}
		echo "</ul>";
		
		if (array_key_exists('suggestions', $this->feedback_msgs)) {
			echo "<h2>Suggestions</h2>";
			echo "<ul>";
			foreach ($this->feedback_msgs as $msg_type => $msg_array) {
				if ($msg_type == 'suggestions') {			
					foreach ($msg_array as $key => $msg) {
						echo "<li>" . $msg . " </li>"; 
					}
				
				}
			}
			echo "</ul>";
				
		}

	}

} // --END of class Feedback
?>