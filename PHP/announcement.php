<?php
	header("Access-control-Allow-Origin:*");
      header('Access-control-Allow-Headers: X-Requested-With');
      header('Content-Type: application/json');


     
    define('HOST','localhost');
	    define('USER','id5203021_mohamedmgdy');
	    define('PASS','Nosa1@MS');
	    define('DB','id5203021_gameetyproject');
        $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');



	$announcement_ID ='';  
	$title = $_GET['title'];;
     $description = $_GET['description'];;
		 $sql = "INSERT INTO  announcement (announcement_ID,title,description) VALUES(NULL,'$title','$description')";
		 		if(mysqli_query($con,$sql)){
		 			echo 'post successful';

		 	}
		 		else{

		 			echo 'oops! Please try again!';

		 		}
		 		?>