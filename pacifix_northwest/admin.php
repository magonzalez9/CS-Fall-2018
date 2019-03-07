<?php
include ("visual/header.php");
include 'db_calls/connectDB.php';

$sql = "SELECT id, name FROM customer_information";
$result = $conn->query($sql);

echo '<h1>Submissions</h1> 
      <p id="admin">Below are requests that have been submitted in the past 30 days. </p>';

echo '<ul>';
if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        
        echo '<li><a href="http://localhost/pacifix_northwest/admin_view.php?id='.$row["id"].'">'.$row["name"].'</a></li></br>';
    }
echo '</ul>';
} else {
    echo "0 results";
}
$conn->close();
?>