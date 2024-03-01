<?php
include "connecttodb.php";

 $query = "SELECT * FROM course";
 $result = mysqli_query($connection,$query);
 if (!$result) {
 die("databases query failed.");
 }

 while ($row = mysqli_fetch_assoc($result)) {
    echo 
    "<option value='" . $row["coursenum"] ."'>" . $row["coursename"] . " (" . $row["coursenum"] . ")" .
    "</option>";
 }
 mysqli_free_result($result);
 mysqli_close($connection);
?>
