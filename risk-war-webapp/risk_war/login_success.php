<?php
session_start ();
if (! $_SESSION ['username']) {
	header ( "location:index.php" );
}
$result = CallAPI ( 'http://localhost:5555/countries' );
$countries = json_decode ( $result, true );
$dir = "../images/flags";
$dh = opendir ( $dir );
while ( false !== ($filename = readdir ( $dh )) ) {
	$files [] = $filename;
}
$images = preg_grep ( '/\.png$/i', $files );

foreach ( $countries as $country ) {
	echo '<p>';
	echo $country;
	echo '</p>';
	echo '<img src="'.$dir.'/'.$country.'.png" border="0" />';
}
function CallAPI($url) {
	$ch = curl_init ( $url );
	curl_setopt ( $ch, CURLOPT_CUSTOMREQUEST, 'GET' );
	curl_setopt ( $ch, CURLOPT_RETURNTRANSFER, true );
	curl_setopt ( $ch, CURLOPT_HTTPHEADER, array (
			'Content-Type: application/json' 
	) );
	$result = curl_exec ( $ch );
	curl_close ( $ch );
	return $result;
}
?>

<html>
<head>
<title>RISK WARS :: MAIN MENU</title>
</head>
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script>
function initialize() {
  var polygon1 = new google.maps.LatLng(40.2323,-1.3);
  var polygon2 = new google.maps.LatLng(41,-3.5);
  var polygon3 = new google.maps.LatLng(47,0.1);
  var polygon4 = new google.maps.LatLng(45,2);
  var polygon5 = new google.maps.LatLng(39,1.2);
  var myLatlng = new google.maps.LatLng(42,0);
  var mapProp = {
    center:myLatlng,
    zoom:10,
    mapTypeId:google.maps.MapTypeId.TERRAIN
  };
  var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
  var marker=new google.maps.Marker({
	  position:myLatlng,
	  map:map,
	  icon:'../images/Icon_settlement_large.png',
	  animation:google.maps.Animation.DROP,
	  });
  var myTrip = [polygon1,polygon2,polygon3,polygon4,polygon5];
  var flightPath = new google.maps.Polygon({
    path:myTrip,
    map:map,
    strokeColor:"#0000FF",
    strokeOpacity:0.8,
    strokeWeight:2,
    fillColor:"#0000FF",
    fillOpacity:0.4
  });
}
google.maps.event.addDomListener(window, 'load', initialize);
</script>
<body>
<?php
echo '<p><font color="blue">Hello ';
echo $_SESSION ['username'];
echo '</font color="red"></p>';
?>
<div id="googleMap" style="width: 700px; height: 600px;"></div>
</body>
</html>
</html>