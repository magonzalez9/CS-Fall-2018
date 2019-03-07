<?php 

include 'db_calls/connectDB.php';
include 'base/pacifix_base.php';

$name = $_REQUEST['name'];
$email = $_REQUEST['email'];
$phone = $_REQUEST['phone'];

//phone information
$phone_type = $_REQUEST['phone_type'];
$touch_function= $_REQUEST['touch_function'];
$display_function = $_REQUEST['display_function'];


$pacifix = new pacifix();


$dbValues = array(
	0 => $_REQUEST['name'],
	1 => $_REQUEST['email'],
	2 => $_REQUEST['phone'],
	3 => $_REQUEST['phone_type'],
	4 => $_REQUEST['touch_function'],
	5 => $_REQUEST['display_function'],
	6 => $_REQUEST['power'],
	7 => $_REQUEST['screen_option'],
	8 => $_REQUEST['other'],
	9 => $_REQUEST['severity']
	);

//put values in SQL query
$values =  $pacifix->putValues($dbValues);

//store DB fields in variables
$dbFields = $pacifix->getDBfields();

//store information in database
$sql = $pacifix->writeToCustomerDB($dbFields, $values);


if ($conn->query($sql) === TRUE) {
   header("Location: thank_you.php");
die();
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}


$conn->close();

?>