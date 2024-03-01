<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Create New TA </title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 20px;
        }

        .message {
            margin-bottom: 20px;
            padding: 10px;
            border-radius: 5px;
        }

        .error {
            background-color: #FFD2D2;
            color: #D8000C;
        }

        .success {
            background-color: #DFF2BF;
            color: #4F8A10;
        }

        .back-btn {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #3498db;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
        }
    </style>
</head>


<body>
    <?php
    include "connecttodb.php";

    $given_name = $_POST["given-name"];
    $last_name = $_POST["last-name"];
    $studentnum = $_POST["studentnum"];
    $tauserid = $_POST["tauserid"];
    $degree_type = $_POST["degree-type"];

    // Check if student number is already in use
    $query_student_num = "SELECT studentnum FROM ta WHERE studentnum='" . $studentnum . "'";
    $result_student_num = mysqli_query($connection, $query_student_num);

    // Check if user ID is already in use
    $query_tauserid = "SELECT tauserid FROM ta WHERE tauserid='" . $tauserid . "'";
    $result_tauserid = mysqli_query($connection, $query_tauserid);

    if (!$result_student_num || !$result_tauserid) {
        die("Database query failed.");
    } 
    else if (mysqli_num_rows($result_student_num) > 0) {
        echo "<div class='message error'>Error: Student number already in use </div>";
    } 
    else if (mysqli_num_rows($result_tauserid) > 0) {
        echo "<div class='message error'>Error: User ID already in use </div>";
    } 
    else { // Insert new user
        $query_insert = "INSERT INTO ta VALUES('" . $tauserid . "', '" . $given_name . "', '" . $last_name . "', '" . $studentnum . "', '" . $degree_type . "', NULL)";
        if (!mysqli_query($connection, $query_insert)) {
            die("Error: insert failed" . mysqli_error($connection));
        }
        if (isset($_POST['loves']) && is_array($_POST['loves'])) { // Add loved courses
            $lovedCourses = $_POST['loves'];
            foreach ($lovedCourses as $course) {
                $query_loves = "INSERT INTO loves VALUES ('" . $tauserid . "', '" . $course . "')";
                if (!mysqli_query($connection, $query_loves)) { die("Error: adding loved courses failed" . mysqli_error($connection)); }
            }
        }
        if (isset($_POST['hates']) && is_array($_POST['hates'])) { // Add loved courses
            $hatedCourses = $_POST['hates'];
            foreach ($hatedCourses as $course) {
                $query_hates = "INSERT INTO hates VALUES ('" . $tauserid . "', '" . $course . "')";
                if (!mysqli_query($connection, $query_hates)) { die("Error: adding hated courses failed" . mysqli_error($connection)); }
            }
        }

        echo "<div class='message success'> Created! </div>";
    }


    mysqli_close($connection);
    ?>

    <a href="edit.php" class="back-btn">Go Back to Edit</a>
</body>
</html>
