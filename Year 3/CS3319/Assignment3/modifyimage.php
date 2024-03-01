<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Upload Image </title>
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

    $tauserid = $_POST["modify-image"];
    $url = $_POST["url"];


    $query_insert = "UPDATE ta SET image='" . $url . "' WHERE tauserid='" . $tauserid . "'";
    if (!mysqli_query($connection, $query_insert)) {
            die("Error: upload failed" . mysqli_error($connection));
        }

    echo "<div class='message success'> Image uploaded!</div>";


    mysqli_close($connection);
    ?>

    <a href="edit.php" class="back-btn">Go Back to Edit</a>
</body>
</html>
