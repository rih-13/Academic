<?php

include "connecttodb.php";

/* See if user specified special queries, if not set default values */
if (isset($_POST["course-offering-view"])) {
    $searchBy = $_POST["course-offering-view"];
} else {
    $searchBy = "course"; 
}


/* If user searches by course */
if ($searchBy == "course" && isset($_POST["findco-course"])) {
    $coursenum = $_POST["findco-course"];
    echo ' <div class="text-body"> 
            <table class="co-table"> 
                <tr>
                    <th> Course Offer ID </th>
                    <th> Term </th>
                    <th> Year </th>
                    <th> Enrollment </th>
                </tr>';

    $query = "SELECT * FROM courseoffer WHERE whichcourse='" . $coursenum . "'";
    if (!empty($_POST["co-start-year"])) {
        $startYear = $_POST["co-start-year"];
        $query = $query . " AND year >= " . $startYear;
    }
    if (!empty($_POST["co-end-year"])) {
        $endYear = $_POST["co-end-year"];
        $query = $query . " AND year <= " . $endYear;
    }

    echo "<h4> Showing course offerings for " . $coursenum . "</h4>";
    $result = mysqli_query($connection,$query);
    if (!$result) {
        die("databases query failed.") . mysqli_error($connection);
    }
            
            
            
    while ($row = mysqli_fetch_assoc($result)) {
                echo "<tr>";
                echo "<td>" . $row["coid"] . "</td>";
                echo "<td>" . $row["term"] .  "</td>";
                echo "<td>" . $row["year"] .  "</td>";
                echo "<td>" . $row["numstudent"] .  "</td>";
                echo "</tr>";
    }
    echo '</table>     </div>';
            
            
    mysqli_free_result($result);

}

else if ($searchBy == "ta") {
    $tauserid = $_POST["findco-ta"];
    $query = "SELECT
            course.coursename,
            course.coursenum,
            hasworkedon.coid,
            courseoffer.term,
            courseoffer.year,
            hasworkedon.hours,
            loves.lcoursenum AS love_status,
            hates.hcoursenum AS hate_status
          FROM
            hasworkedon
            JOIN courseoffer ON hasworkedon.coid = courseoffer.coid
            JOIN course ON courseoffer.whichcourse = course.coursenum
            LEFT JOIN hates ON hates.hcoursenum = course.coursenum AND hates.htauserid = '" . $tauserid . "'
            LEFT JOIN loves ON loves.lcoursenum = course.coursenum AND loves.ltauserid = '" . $tauserid . "'
          WHERE
            hasworkedon.tauserid = '" . $tauserid . "'";


    $result = mysqli_query($connection, $query);

    if (!$result) {
        die("Database query failed: " . mysqli_error($connection));
    }

    $query_name = "SELECT firstname, lastname FROM ta WHERE tauserid='" . $tauserid . "'";
    $result_name = mysqli_query($connection,$query_name);
    if (!$result_name) {
        die("databases query failed.") . mysqli_error($connection);
    }
    while ($row_name = mysqli_fetch_assoc($result_name)) {
        echo "<h4> Showing course offerings for " . $row_name["firstname"] . " " . $row_name["lastname"] . "</h4>";
    }

    echo '<table class="co-table">
            <tr>
                <th>Course Name</th>
                <th>Course Number</th>
                <th>Course Offer ID</th>
                <th>Term</th>
                <th>Year</th>
                <th>Hours</th>
                <th>Loved/Hated</th>
            </tr>';

    while ($row = mysqli_fetch_assoc($result)) {
        echo "<tr>";
        echo "<td>" . $row["coursename"] . "</td>";
        echo "<td>" . $row["coursenum"] . "</td>";
        echo "<td>" . $row["coid"] . "</td>";
        echo "<td>" . $row["term"] . "</td>";
        echo "<td>" . $row["year"] . "</td>";
        echo "<td>" . $row["hours"] . "</td>";
        echo "<td>";
        
        // Check if the course is loved or hated
        if (!empty($row["love_status"])) {
            echo "&#9825;";
        }
        if (!empty($row["hate_status"])) {
            echo "&#10005;";
        }
        
        echo "</td>";
        echo "</tr>";
    }

echo '</table>';
mysqli_free_result($result);
mysqli_free_result($result_name);


            
    
}

mysqli_close($connection);

?>
