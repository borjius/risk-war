<?php
session_start();
if(!$_SESSION['username']){
header("location:index.php");
} 
?>

<html>
<head><title>RISK WARS :: MAIN MENU</title></head>
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script>
function initialize() {
  var mapProp = {
    center:new google.maps.LatLng(51.508742,-0.120850),
    zoom:7,
    mapTypeId:google.maps.MapTypeId.TERRAIN
  };
  var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
}
google.maps.event.addDomListener(window, 'load', initialize);
</script>
<body>
Login Successful
<div id="googleMap" style="width:700px;height:600px;"></div>
</body>
</html>
</html>