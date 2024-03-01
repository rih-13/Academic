<?php
include "connecttodb.php";
generateCheckboxes("loves", $connection);
echo "<br>";
generateCheckboxes("hates", $connection);
mysqli_close($connection);




function generateCheckboxes($type, $connection) {
   if ($type == "loves") {
      $label = "Loved";
   }
   else {
      $label = "Hated";
   }
   if (!$connection) {
      die("Database connection failed.");
  }
   $query = "SELECT coursenum FROM course";
   $result = mysqli_query($connection,$query);
   if (!$result) {
   die("databases query failed.");
   }



   echo "<label>Select " . $label . " Courses:</label>";
   while ($row = mysqli_fetch_assoc($result)) {
      echo "<input type='checkbox' class='course-checkbox' name='". $type . "[]' value='" . $row["coursenum"] ."'>";
      echo "<label for='" . $row["coursenum"] . "'> " . $row["coursenum"] . " </label>";
   }
   mysqli_free_result($result);
}

?>

