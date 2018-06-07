<?php

    header("Access-control-Allow-Origin:*");
    header('Access-control-Allow-Headers: X-Requested-With');
    header('Content-Type: application/json');


    define('HOST','localhost');
	    define('USER','id5203021_mohamedmgdy');
	    define('PASS','Nosa1@MS');
	    define('DB','id5203021_gameetyproject');
        $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');


     $query=mysqli_query($con,"SELECT title,description,announcement_ID FROM announcement ");
     if($query)
     {
        while($row=mysqli_fetch_array($query))
        {
            $flag[]=$row;
        }

        print(json_encode($flag));
    }
    mysqli_close($con);
    ?>