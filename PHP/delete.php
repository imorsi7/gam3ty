<?php

      	header("Access-control-Allow-Origin:*");
      header('Access-control-Allow-Headers: X-Requested-With');
      header('Content-Type: application/json');


     
    define('HOST','localhost');
	    define('USER','id5203021_mohamedmgdy');
	    define('PASS','Nosa1@MS');
	    define('DB','id5203021_gameetyproject');
        $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');



        $announcement_ID = $_GET['announcement_ID'];


		
       
		$sql = "SELECT * FROM announcement WHERE announcement_ID='$announcement_ID'";
	    $check = mysqli_fetch_array(mysqli_query($con,$sql));
		if(isset($check)){
		
		} 
		 else
		 {
		     echo 'ID Not found';
		 }
		
		$sql = "DELETE FROM announcement WHERE announcement_ID='$announcement_ID'";
		if(mysqli_query($con,$sql)){
			echo 'Delete successfully';
	
	}
		else{
				
			echo 'oops! Please try again!';
		
		}

			
	        mysqli_close($con);
	

?>