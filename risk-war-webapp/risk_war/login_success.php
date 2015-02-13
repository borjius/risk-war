<?php
session_start();
if(!$_SESSION['username']){
header("location:index.php");
} 
?>

<html>
<body>
Login Successful
</body>
</html>
