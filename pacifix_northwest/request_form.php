<?php include ("visual/header.php");?>

<h1>Repair Form</h1>
<p id="rDescription">Below you can submit a request for a phone repair. Make sure you fill out the required fields and that the information you submit is correct. 

<form action="request_post.php" method="post">
<fieldset>
<legend>Personal Info</legend>
<label>Name: *</label></br>
<input class="user" type="text" name="name" required><br>

<label>Email: *</label></br>
<input class="user" type="text" name="email" required><br>

<label>Phone Number: *</label></br>
<input class="user" type="text" name="phone" required><br>
</fieldset>

</br>

<fieldset>
<legend>Phone Information </legend>
<label>Phone Type: </label></br>
  <input type="radio" name="phone_type" value="4"> iPhone 4</input></br>
  <input type="radio" name="phone_type" value="4S"> iPhone 4S</input></br>
  <input type="radio" name="phone_type" value="5"> iPhone 5</input></br>
  <input type="radio" name="phone_type" value="5S"> iPhone 5S</input></br>
  <input type="radio" name="phone_type" value="SE"> iPhone SE</input></br>
  <input type="radio" name="phone_type" value="6"> iPhone 6</input></br>
  <input type="radio" name="phone_type" value="6S"> iPhone 6S</input></br>

  </br> <label>Does the touch capabilty work?</label></br>
  <input type="radio" name="touch_function" value="yes" required> Yes</input>
  <input type="radio" name="touch_function" value="no" required> No</input></br>


  </br> <label>Does the display function?</label></br>
<input type="radio" name="display_function" value="yes"> Yes</input>
 <input type="radio" name="display_function" value="no"> No</input></br>

 </br> <label>Does the phone power on?</label></br>
<input type="radio" name="power" value="yes"> Yes</input>
 <input type="radio" name="power" value="no"> No</input></br>

</br> <label>Severity of screen</label></br>
<input type="radio" name="severity" value="minor">Minor</input></br>
 <input type="radio" name="severity" value="moderete">Moderate</input></br>
 <input type="radio" name="severity" value="severe">Severe</input></br>

 </br> <label>Screen option</label></br>
  <input type="radio" name="screen_option" value="need"> I will provide a screen</input>
  <input type="radio" name="screen_option" value="provide"> I need a screen </input></br>


 </br><label>Other important information: </label></br>
 <textarea name="other" rows="15" cols="60"></textarea>
 </br>

  </fieldset>

<input type="submit" value="Submit">

</form>

</body>
</html>