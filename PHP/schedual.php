<?php
	header("Access-control-Allow-Origin:*");
      header('Access-control-Allow-Headers: X-Requested-With');
      header('Content-Type: application/json');


        define('HOST','localhost');
	    define('USER','id5203021_mohamedmgdy');
	    define('PASS','Nosa1@MS');
	    define('DB','id5203021_gameetyproject');
        $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');



   	      $s_schedule_ID = '';
         
		 $appointment = $_GET['appointment'];
		 $teacher_name = $_GET['teacher_name'];
		 $leacture_hall = $_GET['leacture_hall'];
		 $semester_NO = $_GET['semester_NO'];
		 $course_ID = $_GET['course_ID'];
		 $year = $_GET['year'];
		 $department = $_GET['department'];
         $day = $_GET['day'];
        
         
		 $sql = "INSERT INTO  student_schedules (s_schedule_ID,appointment,teacher_name,leacture_hall,semester_NO,course_ID,year,department,day) VALUES(NULL,'$appointment','$teacher_name','$leacture_hall','$semester_NO','$course_ID','$year','$department','$day')";
		 		if(mysqli_query($con,$sql)){
		 			echo 'success';

		 	}
		 		else{

		 			echo 'oops! Please try again!';

		 		}


?>