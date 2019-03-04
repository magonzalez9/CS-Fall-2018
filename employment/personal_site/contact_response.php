<?php

if(isset($_POST['g-recaptcha-response'])) {
    $secretKey = '6LdUQZUUAAAAAKJCfRH22QkjESaVLOS67LsDfY7U';
    $response = $_POST['g-recaptcha-response'];     
    $remoteIp = $_SERVER['REMOTE_ADDR'];


    $reCaptchaValidationUrl = file_get_contents("https://www.google.com/recaptcha/api/siteverify?secret=$secretKey&response=$response&remoteip=$remoteIp");
    $result = json_decode($reCaptchaValidationUrl, TRUE);

    //get response along side with all results
    print_r($result);

    if($result['success'] == 1) {
        //True - What happens when user is verified
        $userMessage = '<div>Success: you\'ve made it :)</div>';

        $name = $_POST['name'];
		$sender_email = $_POST['email'];
		$subject = $_POST['subject']; 
		$message = $_POST['message'];

		$to_email = 'magonzalez@willamette.edu'; 

		$headers = "From: " . $sender_email;

		// $mail_response = mail($to_email, $subject, $message, $headers);

		// if ($mail_response == true) {
		// 	echo "Success"; 
		// } else {
		// 	echo "Fail"; 
		// }
    } else {
        //False - What happens when user is not verified
        $userMessage = '<div>Fail: please try again :(</div>';
    }
}



?>