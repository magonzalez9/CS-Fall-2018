<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="main.css">
<
<!------ Include the above in your HEAD tag ---------->

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="media/rleague.png" id="icon" alt="User Icon" />
    </div>

    <!-- Login Form -->
    <form action="process-new-user.php" method="post">
      <input type="text" id="login" class="fadeIn second" name="first" placeholder="First Name">
      <input type="text" id="login" class="fadeIn second" name="last" placeholder="Last Name">
      <input type="text" id="login" class="fadeIn second" name="login" placeholder="Username">

      <input type="password" id="password" class="fadeIn third" name="password" placeholder="Password">
      <input type="password" id="password" class="fadeIn third" name="password-verify" placeholder="Confirm Password">
      <input type="submit" class="fadeIn fourth" value="Sign Up">
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="login.php">Sign In</a>
    </div>

  </div>
</div>