<?php

include("connecttodb.php");

/* See if user specified special queries, if not set default values */
if (isset($_POST["sort-category"])) {
    $sortCategory = $_POST["sort-category"];
} else {
    $sortCategory = "lastname"; 
}

if (isset($_POST["name-sort-direction"])) {
    $sortDirection = $_POST["name-sort-direction"];
} else {
    $sortDirection = "ascending"; 
}

if (isset($_POST["ta-filter"])) {
    $filter = $_POST["ta-filter"];
} else {
    $filter = "all"; 
}



/* Create query based ons et specification */
$query = "SELECT * FROM ta"; //for all queries 

if ($filter == "masters") { 
    $query = $query . " WHERE degreetype = 'Masters'";
}
else if ($filter == "phd") {
    $query = $query .  " WHERE degreetype = 'PhD'";
}
if ($sortCategory == "degreetype") {
    $query = $query . " ORDER BY degreetype";
}
else {
    if ($sortDirection == "descending") {
        $query = $query . " ORDER BY lastname DESC";
    }
    else {
        $query = $query . " ORDER BY lastname";
    }
}




$result = mysqli_query($connection,$query);
if (!$result) {
     die("databases query failed.") . mysqli_error($connection);
}




while ($row = mysqli_fetch_assoc($result)) {
    echo "<tr>";
    echo "<td>" . $row["firstname"] . " " . $row["lastname"]. "</td>";
    echo "<td>" . $row["degreetype"] .  "</td>";
    echo "<td>" . $row["tauserid"] .  "</td>";
    echo "<td>" . $row["studentnum"] .  "</td>";
    echo "</tr>";
}
mysqli_free_result($result);
mysqli_close($connection);
?>