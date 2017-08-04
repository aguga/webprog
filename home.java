<?php
//make sure the page uses a secure connecton
/*if(!isset($_SERVER['HTTPS'])){
$url='https://'.$_SERVER['HTTP_HOST'].$_SERVER['REQUEST_URI'];
header("Location:".$url);
exit();
}*/

session_start();
include_once'functions.php';

$uname=$passwd='';
$error='';

if(isset($_POST['login']))
{
$uname=sanitizeString($_POST['uname']);
$passwd=sanitizeString($_POST['passwd']);
$query="select * from students where username='$uname' and password='$passwd'";
$results=mysql_query($query);
if(!$results) die(mysql_error());
$rows=mysql_num_rows($results);
if($rows<>0){
$row=mysql_fetch_row($results);
$_SESSION['username']=$row[1];
$_SESSION['firstname']=$row[2];
$_SESSION['lastname']=$row[3];
header("location:student_account.php");
}
else{
$query="select * from staff where username='$uname' and password='$passwd'";
$results=mysql_query($query);
if(!$results) die(mysql_error());
$rows=mysql_num_rows($results);
if($rows<>0){
$row=mysql_fetch_row($results);
$_SESSION['username']=$row[1];
$_SESSION['firstname']=$row[2];
$_SESSION['lastname']=$row[3];
header("location:staff_account.php");
}
else{
$error="Invalid login ";
}
}
}
?>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Books Records Mangement System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>  
<div id="form_head">User Login Form</div>
<div id="login_container">

    <form method="post">
        <table border="0" cellpadding="4" cellspacing="0">
              <h4><font style="color:red"><?php echo $error ?></font></h4>
              <tr><td>User Name:</td></tr>
              <!--<tr><td><span id="info"></span></td></tr>-->
              <tr> <td><input type="text" name="uname" id="textbox" placeholder="Username" required="required" /></td></tr>
              <tr><td>Password:</td></tr>
              <tr><td><input type="password" name="passwd" id="textbox" placeholder="Password" required="required" /></td></tr>
              <tr><td><input type="submit" name="login" value="Log in" id="login_button">
      </table>
  </form>  
  </div>        
</body>
</html>

              
              