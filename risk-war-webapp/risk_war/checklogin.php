<?php
session_start();
if(!$_SESSION['username']){
	header("location:index.php");
}
$urlLoginService='http://localhost:5555/login';

// username and password sent from form
$username=$_POST['username'];
$password=$_POST['password'];

// create json object
$json_object = array("username" => $username, "password" => $password);
$json = json_encode($json_object);

//connect to rest service
$result = CallAPI($urlLoginService, $json);

// if user found... modify...
if($result == 'true'){
	// Register $myusername, $mypassword and redirect to file "login_success.php"
	$_SESSION['username'] = $username;
	$_SESSION['password'] = $password;
	header("location:login_success.php");
}
else {
	$_SESSION['login_error_message'] = 'User or password incorrect';
	header("location:index.php");
}



// Method: POST, PUT, GET etc
// Data: array("param" => "value") ==> index.php?param=value

function CallAPI($url, $content)
{
	$ch = curl_init($url);
	curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'POST');  
    curl_setopt($ch, CURLOPT_POSTFIELDS, $content);  
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);  
     curl_setopt($ch, CURLOPT_HTTPHEADER, array(  
       'Content-Type: application/json')  
     );  
     $result = curl_exec($ch);
     curl_close($ch);  
	return $result;
}
?>