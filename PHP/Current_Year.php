<?php
	header("Access-control-Allow-Origin:*");
      header('Access-control-Allow-Headers: X-Requested-With');
      header('Content-Type: application/json');


     
    define('HOST','localhost');
	    define('USER','id5203021_mohamedmgdy');
	    define('PASS','Nosa1@MS');
	    define('DB','id5203021_gameetyproject');
        $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');


	$id =$_GET['id'];  
	$stdYear =$_GET['stdYear'];  
	$stdDep = $_GET['stdDep'];
    $stdSemester = $_GET['stdSemester'];
		$sql = "UPDATE  student SET Std_Year='$stdYear' ,Std_dep= '$stdDep',Std_Semester ='$stdSemester' WHERE student_ID = '$id'";
		 		if(mysqli_query($con,$sql)){
		 			echo 'post successful';

		 	}
		 		else{

		 			echo 'oops! Please try again!';

		 		}
		 		?>