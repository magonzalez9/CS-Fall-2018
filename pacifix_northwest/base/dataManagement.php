<?php

class dataManagement{



	public function __construct(){


	}

public function getDBfields(){

	$db_fields = array(
        0 => 'name, ',
        1 => 'email, ',
        2 => 'phone_number, ',
		3 => 'phone_type, ',
		4 => 'touch_function, ',
		5 => 'display_function, ',
		6 => 'power_function, ',
		7 => 'screen_option, ',
		8 => 'other_info, ',
		9 => 'severe_level'
		);

	foreach ($db_fields as $values){
		return $values.', ';
	}

}




}







?>
