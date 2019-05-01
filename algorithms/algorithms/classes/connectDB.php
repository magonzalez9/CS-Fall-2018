<?php

$user = 'root';

$password = 'Lalita8711';

$database = 'rocket-power';

$conn = new mysqli('localhost', $user, $password, $database);


if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
// echo "Connected successfully";
 ?>