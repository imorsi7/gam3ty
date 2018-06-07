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
	
	    $first_name = $_GET['first_name'];
	    $middle_name = $_GET['middle_name'];
	    $last_name = $_GET['last_name'];
	    $email = $_GET['email'];
	    $passcode = $_GET['passcode'];

		if($teacher_ID == '' || $first_name == '' || $middle_name == '' || $last_name == '' || $email == '' || $passcode == '')
		{
	
		echo 'please fill all values';
		}
		else{
       
		$sql = "SELECT * FROM teachers WHERE teacher_ID='$teacher_ID' OR email='$email'";
	    $check = mysqli_fetch_array(mysqli_query($con,$sql));
		if(isset($check)){
		echo 'username or email already exist';
		} 
		else 
		{
		$sql = "INSERT INTO teachers (teacher_ID,first_name,middle_name,last_name,email,passcode) VALUES('$teacher_ID','$first_name','$middle_name','$last_name','$email','$passcode')";
		if(mysqli_query($con,$sql)){
			echo 'successfully registered';
	
	}
		else{
				
			echo 'oops! Please try again!';
		
		}
}
			
	        mysqli_close($con);
	}

?>