
<?php
include "connecttodb.php";
$query = "SELECT * FROM course";
$result = mysqli_query($connection,$query);
if (!$result) {
     die("databases query failed.");
}
echo "<ul>";
while ($row = mysqli_fetch_assoc($result)) {
    echo "<li>";
    echo $row["coursename"] . "</li>";
}
mysqli_free_result($result);
echo "</ul>";
mysqli_close($connection);
?>