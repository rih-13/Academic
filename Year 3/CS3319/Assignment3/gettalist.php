<?php
include "connecttodb.php";


 $query = "SELECT * FROM ta ORDER BY lastname";
 $result = mysqli_query($connection,$query);
 if (!$result) {
 die("databases query failed.");
 }

 while ($row = mysqli_fetch_assoc($result)) {
    echo 
    "<option value='" . $row["tauserid"] ."'>" . $row["firstname"] . " " . $row["lastname"]
    . " (" . $row["tauserid"] . ")" .
    "</option>";
 }
 mysqli_free_result($result);
 mysqli_close($connection);
?>


