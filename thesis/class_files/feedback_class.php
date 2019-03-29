<?php 
class Feedback{
	# Class Properties
	protected $settingsFilePath = "C:\\xampp\htdocs\\thesis\\settings\\settings.txt"; 
	protected $templatePath = "C:\\xampp\htdocs\\thesis\\settings\\template.txt"; 

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

	protected $templateWidth; 
	protected $templateHeight; 


	function __construct($data_array){
		// Set class properties
		$this->faceWidth = $data_array['faceWidth']; 
		$this->faceHeight = $data_array['faceHeight']; 
		$this->faceXPos = $data_array['faceXPos']; 
		$this->faceYPos = $data_array['faceYPos'];
		$this->imgWidth = $data_array['imgWidth']; 
		$this->imgPixelArray = $data_array['imgPixelArray']; 

		// Set the image settings
		$this->setImageSettings(); 
		
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

	public function setImageSettings(){
		$json_str = file_get_contents($this->settingsFilePath);

		if ($json_str !== false) {
			$jsonObj = json_decode($json_str); 

			// Set the target dimension properties 
			$this->templateWidth = $jsonObj->templateWidth; 
			$this->templateHeight = $jsonObj->templateHeight; 
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
}
?>