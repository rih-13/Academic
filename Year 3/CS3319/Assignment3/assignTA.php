<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TA Assignment</title>
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

    $tauserid = $_POST["assign-ta"];
    $coid = $_POST["assign-co"];
    $hour = $_POST["assign-hours"];

    // Check if the relationship already exists
    $query = "SELECT * FROM hasworkedon WHERE tauserid='" . $tauserid . "' AND coid='" . $coid . "'";
    $result = mysqli_query($connection, $query);

    if (!$result) {
        die("Database query failed.");
    }

    if (mysqli_num_rows($result) > 0) {
        echo "<div class='message error'>Error: TA is already assigned to this course</div>";
    } else {
        // If the relationship doesn't exist, insert it
        $query_insert = 'INSERT INTO hasworkedon values("' . $tauserid . '","' . $coid . '","' . $hour . '")';

        if (!mysqli_query($connection, $query_insert)) {
            die("Error: insert failed" . mysqli_error($connection));
        }

        echo "<div class='message success'>TA assigned!</div>";
    }

    mysqli_free_result($result);
    mysqli_close($connection);
    ?>

    <a href="edit.php" class="back-btn">Go Back to Edit</a>
</body>
</html>
