<?php
include "connecttodb.php";

 $coid = $_POST["view-co"]; //get selected coid
 $query = "SELECT whichcourse, coursename, courseoffer.year, term FROM course, courseoffer WHERE coid='" . $coid . "'" . "AND whichcourse=coursenum"; 

$result = mysqli_query($connection, $query);
 if (!$result) {
 die("databases query  failed. " . mysqli_error($connection));
 }


 while ($row = mysqli_fetch_assoc($result)) {
    echo "<h2> " . $row["coursename"] . " (" . $row["whichcourse"] . ") </h2>";
    echo "<h3> " . $row["term"] . " " . $row["year"] . " </h3>";



     // Second query
    $query_workedon = "SELECT firstname, lastname, ta.tauserid FROM hasworkedon, ta WHERE hasworkedon.coid = '" . $coid . "' AND " .
    "hasworkedon.tauserid=ta.tauserid ";
    $result_workedon = mysqli_query($connection, $query_workedon);
    if (!$result_workedon) {
        die("Database query on loved courses failed: " . mysqli_error($connection));
    }

    echo "<h3> TAs </h3> <ul>";
    while ($row_workedon = mysqli_fetch_assoc($result_workedon)) {
        echo "<li>" . $row_workedon["firstname"] . " " . $row_workedon["lastname"] . " (" . $row_workedon["tauserid"] . ") </li>";
    }
    echo "</ul>";


    mysqli_free_result($result_workedon); //Free 
}


mysqli_free_result($result); //Free ta result

mysqli_close($connection);

?>