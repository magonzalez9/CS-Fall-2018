<?php
include ("visual/header.php");
include 'db_calls/connectDB.php';
include 'base/pacifix_base.php';

$pacifix = new pacifix();

$id = $_GET['id'];

$db_fields = $pacifix->getDBfields();

$sql = "SELECT $db_fields FROM customer_information WHERE id=$id";
$result = $conn->query($sql);

$row = $result->fetch_assoc();

?>

<h1>Submission</h1>

<table>
  
  <tr>
    <td class="left">Name</td>
    <td class="right"><?php echo $row["name"]?></td>
   
  </tr>
  <tr>
    <td class="left">Email</td>
    <td class="right"><?php echo $row["email"]; ?></td>
   
  </tr>
  <tr>
    <td class="left">Phone Number</td>
    <td class="right"><?php echo $row["phone_number"]; ?></td>
    
  </tr>
  <tr>
    <td class="left">Phone Type</td>
    <td class="right"><?php echo $row["phone_type"]; ?></td>
    
  </tr>
  <tr>
    <td class="left">Does the Touch Capability Work?</td>
    <td class="right"><?php echo $row["touch_function"]; ?></td>
   
  </tr>
  <tr>
    <td class="left">Does the display function work?</td>
    <td class="right"><?php echo $row["display_function"]; ?></td>
   
  </tr>
  <tr>
    <td class="left">Does the phone power on?</td>
    <td class="right"><?php echo $row["power_function"]; ?></td>
   
  </tr>
  <tr>
    <td class="left">Severity of Screen</td>
    <td class="right"><?php echo $row["severe_level"]; ?></td>
   
  </tr>

  <tr>
    <td class="left">Screen Option</td>
    <td class="right"><?php echo $row["screen_option"]; ?></td>
   
  </tr>
  <tr>
    <td class="left">Other Important Information</td>
    <td class="right"><?php echo $row["other_info"]; ?></td>
   
  </tr>

</table>