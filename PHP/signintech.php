<?php 
header("Access-control-Allow-Origin:*");
      header('Access-control-Allow-Headers: X-Requested-With');
      header('Content-Type: application/json');

       
        define('HOST','localhost');
	    define('USER','id5203021_mohamedmgdy');
	    define('PASS','Nosa1@MS');
	    define('DB','id5203021_gameetyproject');
        $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');



	$teacher_ID = $_GET['teacher_ID'];
    $passcode = $_GET['passcode'];
	$sql =  "SELECT * FROM teachers WHERE teacher_ID='$teacher_ID' AND passcode='$passcode'";
	$result = mysqli_query($con, $sql);
	$check = mysqli_fetch_array($result);
	if(isset($check)){

		echo "Login success welcome";
	}
	else
	{
		echo "Login not success";
	}
	

?>