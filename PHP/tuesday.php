	<?php
    
        define('HOST','localhost');
	    define('USER','id5203021_mohamedmgdy');
	    define('PASS','Nosa1@MS');
	    define('DB','id5203021_gameetyproject');
        $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');

	     $id = $_GET['id'];
    
    
     $test1=mysqli_query($con,"SELECT Std_Year,	Std_dep, Std_Semester FROM student WHERE student_ID= '$id' ");
     
     $row = mysqli_fetch_array($test1, MYSQLI_NUM);
     
     $query=mysqli_query($con,"SELECT appointment, teacher_name, leacture_hall, course_ID, day FROM student_schedules WHERE year='$row[0]' AND department='$row[1]' AND 	semester_NO='$row[2]' ");
     
     if($query)
     {
        
       while($row = mysqli_fetch_array($query))
        {
            $flag[] = $row;
        }
       
       

        print(json_encode($flag));
    }
    mysqli_close($con);
    ?>
