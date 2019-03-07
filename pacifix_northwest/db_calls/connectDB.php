<?php

$user = 'root';

$password = 'Lalita8711';

$database = 'pacifix_northwest';

$conn = new mysqli('localhost', $user, $password, $database);


if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
// echo "Connected successfully";
 ?>