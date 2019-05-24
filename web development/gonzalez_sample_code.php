<?php
require_once('photo_upload_ui_class.php');
require_once('photo_upload_class.php');

# Author: Marco Gonzalez
# Class definition 
class PhotoUploadJIRA{

	//Properties
	protected $jira_url = 'https://live.domain.edu/rest/api/2/issue/';
	protected $jira_username = 'api-user'; 
	protected $jira_password = '****************';  
	protected $update_transition_id = '31';
	protected $jira_test_override = false; // Use JIRA test credentials
	protected $id_photo_tmp_dir = "/www/some-directory/uploads/id_photos/";
	protected $person;

	function __construct($username){
		// Create PhotoUpload and PhotoUploadUI objects
		$uploadUI = new PhotoUploadUI($username); 

		// Get person and photo upload record
		$this->person = $uploadUI->get_person_fields($username);	

		// Use JIRA test credentials if test override property is set to true
		if ($this->jira_test_override) {
			$this->jira_url = 'https://test.domain.edu/rest/api/2/issue/';
			$this->jira_password = '*******************';
			$this->update_transition_id = '21';
		}
	}

	//--------------------------------------------------------------------------------------
    // Function: createNewIssue
    // Description: Creates new JIRA issue, updates the reporter and attaches a new image.
    // Parameters: None
    // Returns: JIRA issue key and issue url upon success, response error code message otherwise (String)
	function createNewIssue(){
		// First, get custom field 'Contact Type' to be set in jira issue
		$custom_fields_response = $this->getCustomFields(); 

		// Check for getCustomFields() success (if return type was an array) 
		if (!is_array($custom_fields_response) || empty($custom_fields_response)) {
			// Error: Failed to retrieve 'Contact Type' custom field, so return error response		
			return $custom_fields_response;
		} else {
			// Custom fields data array contains 'Contact Type' field, so continue issue creation process
			// Set JIRA issue fields by using JSON data array 
			$json_data_array = array( "fields" => array(
										"project" => array("key"=>"SC"), 
			                            "summary" =>"ID Photo Submission",
			                            $custom_fields_response['Contact Type'] => array("value" => "Automated/API"),
			                            "issuetype" => array("name" => "ID Photo Approval")
		            				)  
		        		 		);

			// Encode the JSON data array
		    $issue_data = json_encode($json_data_array);
		  
			// Configure curl settings for JIRA issue creation  	   
			$ch = curl_init();
			curl_setopt($ch, CURLOPT_POST, 1);
			curl_setopt($ch, CURLOPT_URL, $this->jira_url);
			curl_setopt($ch, CURLOPT_USERPWD, $this->jira_username . ':' . $this->jira_password);
			curl_setopt($ch, CURLOPT_POSTFIELDS, $issue_data);
			curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-type: application/json'));
			curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

			// Execute curl and get response
			$response = curl_exec($ch);
			$curl_response_code = curl_getinfo($ch, CURLINFO_HTTP_CODE);
			$curl_error_code = curl_errno($ch);
			curl_close($ch); // closing curl
			
			// Convert JSON string returned by curl into PHP object 
			$json_resultObj = json_decode($response); 
			curl_close($ch); // closing curl
			
			// Check if issue creation was successful
			if (!is_object($json_resultObj) || property_exists($json_resultObj, 'errors')) {
				// Failed to create JIRA issue, return reponse code
				return 'Failed to create issue: ' . $curl_response_code; 
			} else {
			    // JIRA tickets created succesfully, now update reporter
			    // Get issue key from JSON object
				$issueKey = $json_resultObj->key;

				// Associative data array containing issue key and issue url will be returned upon reporter and attachment success
				$new_issue_data = array('issue_key' => $issueKey, 'issue_url' => str_replace("rest/api/2/issue/", "", $this->jira_url) ."browse/{$issueKey}");

				$reporter_response = $this->updateReporter($issueKey);
				// If reporter update is successful, upload image attachment
				if ($reporter_response === true) {
					// Reporter update was successful, now attach image to issue
					$attachment_response = $this->uploadAttachment($issueKey);
					// If attachment upload is successful, return issue data
					if ($attachment_response === true) {
						// Attachment added to JIRA issue meaning that all api calls were successful
						// Return associative array containing the issue key and issue url 
						return $new_issue_data; 
					} else {
						// Failed to upload attachment
						return 'Failed to upload attachment: ' . $attachment_response; 
					}// End of if/else upload attachment
				} else {
					// Failed to update reporter
					return 'Failed to update reporter: '. $reporter_response; 
				} // End of if/else reporter update
		    } // End of if/else issue creation
		}// End of if/else custom fields is a non-empty data array
	}// End of function ceateNewIssue

	//--------------------------------------------------------------------------------------
    // Function: updateIssue
    // Description: Updates exisiting JIRA issue by,
	//              - Adding update comment 
	//				- Updating reporter 
	//				- Replacing exisiting image with newly submitted one
    // Parameters: 
    //			  -issueKey: key of issue to update
    // Returns: Boolean true upon success, response error code message otherwise (String)
	function updateIssue($issueKey){
		// Set the issue url
		$issue_url = $this->jira_url . $issueKey. "/transitions/";

		// Update JIRA issue fields by using JSON data array 
		$json_data_array = array( "update" => array(
							 "comment" => array(array("add"=>array("body" => 'Updated image received.')))),
							 "transition" => array("id" => $this->update_transition_id)
	        		 		);

		// Encode the JSON data array
	    $issue_data = json_encode($json_data_array);
	  
		// Configure curl settings for JIRA issue creation  
		$ch = curl_init(); 
		curl_setopt($ch, CURLOPT_POST, 1);
		curl_setopt($ch, CURLOPT_URL, $issue_url);
		curl_setopt($ch, CURLOPT_USERPWD, $this->jira_username . ':' . $this->jira_password);
		curl_setopt($ch, CURLOPT_POSTFIELDS, $issue_data);
		curl_setopt($ch, CURLOPT_HTTPHEADER,  array('Content-type: application/json'));
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

		// Execute curl to create JIRA issue and get response
		$response = curl_exec($ch);
		$curl_response_code = curl_getinfo($ch, CURLINFO_HTTP_CODE);
		$curl_error_code = curl_errno($ch);
		curl_close($ch); // closing curl

		// Check if issue update returned a successful response code
		if ($curl_error_code == 0 && (200 <= $curl_response_code && $curl_response_code <= 204)) {
			// Issue update was successful, now update reporter and delete all attachments
			$reporter_response = $this->updateReporter($issueKey);
			// If reporter update is successful, delete all existing attachments from issue
			if ($reporter_response === true) {
				// Reporter update was successful, now delete all attachments from issue
				$attachment_del_response = $this->deleteAllAttachments($issueKey);
				// If attachment deletion is successful, add new attachment
				if ($attachment_del_response === true) {
					// Attachment deletion success, now upload new attachment
					$attachment_response = $this->uploadAttachment($issueKey);
					// If new attachment upload is successful then return true 
					if ($attachment_response === true) {
						// New attachment added to JIRA issue meaning that all api calls were successful
						// Return true indicating success
						return true; 
					} else {
						// Failed to upload new attachment
						return 'Failed to upload new attachment: ' . $attachment_response; 
					}// End of if/else attachment upload
				} else {
					// Failed to delete all existing attachments
					return 'Failed to delete exisiting attachments: ' . $attachment_del_response; 
				}// End of if/else delete all attachments
			} else {
				// Failed to update reporter
				return 'Failed to update reporter: ' . $reporter_response; 
			} // End of if/else update reporter
		} else {
			// Failed to update existing issue
			return 'Failed to update exisiting issue: ' . $curl_response_code; 
	    } // End of if/else update existing issue
	} // End of function updateIssue

	//--------------------------------------------------------------------------------------
    // Function: updateReporter
    // Description: Updates the reporter field for selected JIRA issue
    // Parameters:	
    //			  -issueKey: key of issue to update
    // Returns:  True (boolean) upon success, curl response code otherwise
	function updateReporter($issueKey){
		//Set the issue url
		$issue_url = $this->jira_url . $issueKey . "/"; 

		// Set JIRA issue fields by using JSON data array 
		$json_data_array = array( "fields" => array(
									"reporter" => array("name" => $this->person['login'])
	            				)  
	        		 		);
		
		// Encode the JSON data array
	    $issue_data = json_encode($json_data_array);
	  
		// Configure curl settings for JIRA issue creation    
		$ch = curl_init();
		curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "PUT");
		curl_setopt($ch, CURLOPT_POSTFIELDS, $issue_data);
		curl_setopt($ch, CURLOPT_URL, $issue_url);
		curl_setopt($ch, CURLOPT_USERPWD, $this->jira_username . ':' . $this->jira_password);
		curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-type: application/json'));
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

		// Execute curl to upload attachment to JIRA issue
		$response = curl_exec($ch);
		$curl_response_code = curl_getinfo($ch, CURLINFO_HTTP_CODE);
		$curl_error_code = curl_errno($ch);
		curl_close($ch); // closing curl

		// If there are no errors and response codes are in 200-204 (success) range
		if ($curl_error_code == 0 && (200 <= $curl_response_code && $curl_response_code <= 204)) {
			// Reporter updated successfully
			return true; 
		} else {
			// Errors found, return the curl response code
			return $curl_response_code; 
		}
	} // End of function updateReporter 

	//--------------------------------------------------------------------------------------
    // Function: uploadAttachment
    // Description: Uploads attachment to selected JIRA issue  
    // Parameters:
    //			  -issueKey: key of issue to upload attachment
    // Returns: True (boolean) upon success, curl response code otherwise
	function uploadAttachment($issueKey){
		// Set the issue url
		$issue_url = $this->jira_url . $issueKey . '/attachments/';

		// Path location of image that we are trying to upload
		$photo_file_path = '@' . $this->id_photo_tmp_dir . $this->person['id'] . '-rectangle.png';

		// Set the name of the JIRA issue attachment
		$jira_attachment_name = $this->person['id'] . '.png';
	
		// Prep for attachment upload
		$attachment_data = array('file' => $photo_file_path . ';filename=' . $jira_attachment_name);

		// Initiate and configure curl settings for JIRA attachment upload
		$ch = curl_init();
		curl_setopt($ch, CURLOPT_URL, $issue_url);
		curl_setopt($ch, CURLOPT_USERPWD, $this->jira_username . ':' . $this->jira_password);
		curl_setopt($ch, CURLOPT_POST, 1);
		curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);
		curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 0);
		curl_setopt($ch, CURLOPT_VERBOSE, 1);
		curl_setopt($ch, CURLOPT_POSTFIELDS, $attachment_data);
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
		curl_setopt($ch, CURLOPT_HTTPHEADER, array('X-Atlassian-Token: nocheck'));

		// Execute curl to upload attachment to JIRA issue
		$response = curl_exec($ch);
		$jsonObj = json_decode($response);
		$curl_response_code = curl_getinfo($ch, CURLINFO_HTTP_CODE);
		$curl_error_code = curl_errno($ch);
		curl_close($ch); // closing curl
		
		// Check if response code is in 200-204 (success) range and JSON object is not null
		if ((200 <= $curl_response_code && $curl_response_code <= 204) && ($jsonObj != null || $jsonObj != '')) {
			// Attachment added successfully
			return true; 
		} else {
			// Errors found, return the curl response code
			return $curl_response_code; 
		}
	}// End of function uploadAttachment

	//--------------------------------------------------------------------------------------
    // Function: deleteAllAttachments
    // Description: Deletes all attachments from seleted JIRA issue
    // Parameters:
    //			  -issueKey: key of issue to update
    // Returns: True (boolean) upon success, curl response code(s) otherwise
	function deleteAllAttachments($issueKey){
		// Remove uneeded string from jira url
		$issue_url = str_replace("issue/", "", $this->jira_url);

		// Get JIRA issue attachment list
		$attachment_list_response = $this->getAttachmentList($issueKey);

		// Set success helper variables
		$delete_success_flag = true; 
		$response_error_codes = array();

		// Check for getAttachmentList success
		if (is_array($attachment_list_response)) {
			// Loop through all attachments and delete one by one
			foreach ($attachment_list_response as $key) {
				// Set the issue url
				$attachment_url = $issue_url . 'attachment/' . $key['id'];

				// Configure curl settings to get JIRA issue data  
				$ch = curl_init();
				curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
				curl_setopt($ch, CURLOPT_URL, $attachment_url);
				curl_setopt($ch, CURLOPT_USERPWD, $this->jira_username . ':' . $this->jira_password);
				curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

				// Execute curl to delete attachments from seleted JIRA issue
				$response = curl_exec($ch);
				$curl_response_code = curl_getinfo($ch, CURLINFO_HTTP_CODE);
				$curl_error_code = curl_errno($ch);
				curl_close($ch); // closing curl
				
				// If curl execution returned errors
				if ($curl_error_code != 0 && !(200 <= $curl_response_code && $curl_response_code <= 204)) {
					// Change success flag to false and add curl response code to the error codes array
					$success = false; 
					$response_error_codes[$key['id']] = $curl_response_code;

				}
			} // End of foreach attachment
		} else {
			// There was an error getting attachment list
			$response_error_codes['attachment_error'] = $attachment_list_response;
		}// End of if/else attachment list is array

		// Check deletion success flag for possible errors 
		if ($delete_success_flag === false) {
			// There was an error, so return array containing response error code(s)
		 	return $response_error_codes;
		} else {
			// Attachment deletion was successful
			return true; 
		} 
	} // End of function deleteAllAttachments

	//--------------------------------------------------------------------------------------
    // Function: getAttachmentList
    // Description: Gets the attachment list of seleted JIRA issue (if any exist)
    // Parameters: 
    //	   		  -issueKey: key of issue to update
    // Returns: Array containing a list of attachments if successful or the cURL response code if an error occurs.
	function getAttachmentList($issueKey){
		//Set the issue url
		$issue_url = $this->jira_url . $issueKey. "/"; 

		// Configure curl settings to get JIRA attachment data  
		$ch = curl_init($issue_url);
		curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "GET");
		curl_setopt($ch, CURLOPT_URL, $issue_url);
		curl_setopt($ch, CURLOPT_USERPWD, $this->jira_username . ':' . $this->jira_password);
		curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-type: application/json'));
		curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

		// Execute curl to upload attachment to JIRA issue
		$response = curl_exec($ch);
		$curl_response_code = curl_getinfo($ch, CURLINFO_HTTP_CODE);
		$curl_error_code = curl_errno($ch);
		curl_close($ch); // closing curl

		// Decode JSON string returned by curl into array
		$json_array = json_decode($response, true);

		// Check if curl execution returned a valid JSON string containing the attachment list
		if (is_array($json_array)) {
			// Curl call execution success, return the array of attachment ids
			return $json_array['fields']['attachment'];
		} else {
			// Curl execution failed, return response code
			return $curl_response_code; 
		}
	}// End of function getAttachmentCount

	//--------------------------------------------------------------------------------------
    // Function: getCustomFields
    // Description: Retrieves selected custom fields from JIRA api
    // Parameters: 
    //	   		  -none
    // Returns: Array containing a list of specified custom fields if successful or the cURL response code if an error occurs.
	function getCustomFields(){
		$custom_fields_url = str_replace('issue/', 'field/', $this->jira_url); 
		$fields_to_retrieve = array('Contact Type'); // The field name(s) to retrieve
		$custom_fields = array();

		$ch = curl_init();
		curl_setopt($ch,CURLOPT_URL,$custom_fields_url);
		curl_setopt($ch,CURLOPT_RETURNTRANSFER, 1);
		curl_setopt($ch, CURLOPT_USERPWD, $this->jira_username . ':' . $this->jira_password);

		// Execute curl to retrieve custom fields json object
		$response = curl_exec($ch);
		$curl_response_code = curl_getinfo($ch, CURLINFO_HTTP_CODE);
		$curl_error_code = curl_errno($ch);
		curl_close($ch); // closing curl

		// json object declaration
		$jira_custom_fields = json_decode($response);

		// Check if curl returned correct json string for custom fields obj creation
		if (is_object($json_resultObj) || !property_exists($json_resultObj, 'errors')) {
			// Retrieve id names of custom fields and store them in $custom_fields array
			foreach ($jira_custom_fields as $key => $json_value){
			 	if (in_array($json_value->name, $fields_to_retrieve)){
			  		$custom_fields[$json_value->name] = $json_value->id; 
			  	}
			} // End of foreach custom field

			// Check if 'Contact Type' exists in custom fields array
			if (array_key_exists('Contact Type', $custom_fields)) {
				// Custom field, 'Contact Type' exists, so return custom fields array
				return $custom_fields; 
			} else {
				// Custom field was not found
				return "Custom field 'Contact Type' not found";
			} // End of if/else 'Contact Type' exists
		} else {
			// Curl execution failed
			return 'Unable to retrieve custom fields: ' . $curl_response_code; 
		} // End if/else curl returned correct json string
	}// End of function addCustomField

}// --End of PhotoUploadJIRA class

?>