<?php
header("Access-control-Allow-Origin:*");
      header('Access-control-Allow-Headers: X-Requested-With');
      header('Content-Type: application/json');


        define('HOST','localhost');
	    define('USER','id5203021_mohamedmgdy');
	    define('PASS','Nosa1@MS');
	    define('DB','id5203021_gameetyproject');
        $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');



	$student_ID = $_GET['student_ID'];
    $passcode = $_GET['passcode'];
	$sql =  "SELECT * FROM student WHERE student_ID='$student_ID' AND passcode='$passcode'";
	$result = mysqli_query($con, $sql);
	$check = mysqli_fetch_array($result);
	if(isset($check)){

		echo "Login success welcome";
	}
	else
	{
		echo "Login not success";
	}

/*

	if($_SERVER['REQUEST_METHOD']=='POST'){
	$teacher_ID= "200157";

	$passcode = "123456";
	$sql = "SELECT * FROM teachers WHERE teacher_ID='$teacher_ID' AND password='$password'";

	$result = mysqli_query($con,$sql);
	$check = mysqli_fetch_array($result);

	if(isset($check))
	{
	echo "success";
	}
	else{
	echo "failure";
	}
		mysqli_close($con);
	}*/
?>
