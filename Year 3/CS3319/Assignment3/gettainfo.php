<?php
include "connecttodb.php";


 $whichTA = $_POST["view-ta"]; //get selected ta
 $query = "SELECT * FROM ta WHERE tauserid='" . $whichTA . "'" ; 

$result = mysqli_query($connection, $query);
 if (!$result) {
 die("databases query on art pieces failed. " . mysqli_error($connection));
 }


 while ($row = mysqli_fetch_assoc($result)) {
    echo 
    "<h1> " . $row["firstname"] . " " . $row["lastname"] . "</h1>" .
    "<h4> User ID: " . $row["tauserid"] . "</h3>" . 
    "<h4> Student Number: " . $row["studentnum"] . "</h3>" .
    "<h4> Program: " . $row["degreetype"] . "</h3>";

    if ($row["image"] !== null) {
        echo '<img src="' . $row["image"] . '" height="90" width="auto">';
    } else {
        echo '<img src="unknown.jpg" height="60" width="60">';
    }

     // Second query
    $query_loves = "SELECT coursename FROM course, loves WHERE loves.lcoursenum = course.coursenum AND ltauserid='" . $whichTA . "'";
    $result_loves = mysqli_query($connection, $query_loves);
    if (!$result_loves) {
        die("Database query on loved courses failed: " . mysqli_error($connection));
    }

    echo "<h2> Loved Courses </h2> <ul>";
    while ($row_loves = mysqli_fetch_assoc($result_loves)) {
        echo "<li>" . $row_loves["coursename"] . "</li>";
    }
    echo "</ul>";


    // Third query - hates
    $query_hates = "SELECT coursename FROM course, hates WHERE hates.hcoursenum = course.coursenum AND htauserid='" . $whichTA . "'";
    $result_hates = mysqli_query($connection, $query_hates);
     if (!$result_hates) {
         die("Database query on loved courses failed: " . mysqli_error($connection));
     }
 
     echo "<h2> Hated Courses </h2> <ul>";
     while ($row_hates = mysqli_fetch_assoc($result_hates)) {
         echo "<li>" . $row_hates["coursename"] . "</li>";
     }
     echo "</ul>";

    mysqli_free_result($result_loves); //Free loves
    mysqli_free_result($result_hates); //Free hates
}


mysqli_free_result($result); //Free ta result
mysqli_close($connection);



?>