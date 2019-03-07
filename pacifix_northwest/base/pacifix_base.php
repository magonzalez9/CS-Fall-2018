<?php
//include 'base/dataManagement.php';

class pacifix {

function __construct(){
	
}
//Database fields that will be returned in sql query
public function getDBfields(){

	$db_fields = array(
        0 => 'name',
        1 => 'email',
        2 => 'phone_number',
		3 => 'phone_type',
		4 => 'touch_function',
		5 => 'display_function',
		6 => 'power_function',
		7 => 'screen_option',
		8 => 'other_info',
		9 => 'severe_level'
		);

    $string = '';

	foreach ($db_fields as $fields){ 
		$string .= $fields.', ';
	}
	$DBfields = chop($string, ", ");
	return $DBfields;
}

 //Database values that will be returned in sql query
 public function putValues($dbValues){

 	$arrayValues = '';

 	foreach ($dbValues as $fields){
		$arrayValues .= "'".$fields."', ";

 }
 $values = chop($arrayValues, ", ");

return $values;
}

//Query writing to database
public function writeToCustomerDB($dbFields, $values) {

$sql = "INSERT INTO customer_information ($dbFields)
VALUES ($values)";

return $sql;

}

//Send Email. 

}


?>

