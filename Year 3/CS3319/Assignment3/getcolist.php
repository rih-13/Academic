<?php
include "connecttodb.php";

 $query = "SELECT * FROM courseoffer";
 $result = mysqli_query($connection,$query);
 if (!$result) {
 die("databases query failed.");
 }

 while ($row = mysqli_fetch_assoc($result)) {
    echo 
    "<option value='" . $row["coid"] ."'>" . $row["coid"] . " - " . $row["whichcourse"] . " " . $row["term"] . " " . $row["year"] .
    "</option>";
 }
 mysqli_free_result($result);
 mysqli_close($connection);
?>
