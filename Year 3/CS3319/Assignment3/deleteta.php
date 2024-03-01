<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Delete </title>
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

    $tauserid = $_POST["delete-ta"];

    $query_check = "SELECT tauserid FROM hasworkedon WHERE tauserid='" . $tauserid . "'";
    $result_check = mysqli_query($connection, $query_check);
    if (!$result_check) {
        die("Error: delete precheck failed" . mysqli_error($connection));
    }
    if (mysqli_num_rows($result_check) > 0) {
        echo "<div class='message error'>Error: TA is assigned to a course and cannot be deleted </div>";
    }
    else {
        $query_delete = "DELETE FROM ta WHERE tauserid='" . $tauserid . "'";
        if (!mysqli_query($connection, $query_delete)) {
                die("Error: delete failed" . mysqli_error($connection));
        }
        echo "<div class='message success'> Deleted</div>";
    }






    mysqli_close($connection);
    ?>

    <a href="edit.php" class="back-btn">Go Back to Edit</a>
</body>
</html>