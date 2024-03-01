<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Courses </title>
    <link rel="stylesheet" href="styles.css">
    <script src="view.js" defer></script>
    <script src="viewCourses.js" defer></script>
</head>

<body>

    <div class="header" style="margin: 50px auto;"> 
        <button id="homeButton" onclick="window.location.href='mainmenu.php'">
            <img src="home.png" alt="Home" height="75px" width="auto">
        </button>
        <h1 >   Western Computer Science Department Database  </h1>
    </div>


    Show
    <select id="pick-category"> 
        <option value="course"> Courses </option>
        <option value="ta"> Teaching Assistants </option>
    </select>
    <button id="view-data-now-button"> View Now </button>

    <br> <h2> Courses </h2>  
    <?php
    include 'getcourses.php';
    ?>

    <br> <hr> 
    <h2> Course Offerings </h2> 


    <form method="post" action="" onsubmit="return validateForm()">
        <div class="selection-bar">

            <input type="radio" name="course-offering-view" id="course-offering-view" value="course" onchange="toggleCourse()" checked>
            <label for="findco-course"> By Course </label>
            <select name="findco-course" id="findco-course"> 
                    <?php
                    include "getcourselist.php";
                    ?>
            </select>



            <input type="radio" name="course-offering-view" value="ta" onchange="toggleTA()">
            <label for="findco-ta"> By TA </label>
            <select name="findco-ta" id="findco-ta"> 
                    <?php
                    include "gettalist.php";
                    ?>
            </select>

            <br> 
            <label for "co-start-year"> Optional Range </label>
            <input type="number" id="co-start-year" name="co-start-year" maxlength=4> 
            <input type="number" id="co-end-year" name="co-end-year" maxlength=4> 

            <button type="submit" id="view-co-button"> View </button>
        </div>


    </form>

    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        include "getco.php"; 
    }
    ?>

<hr>
<form method="post" action="">
        <div class="selection-bar">
            <label for="view-co"> Find Course Offering </label>
            <select name="view-co" id="view-co"> 
                <?php
                include "getcolist.php";
                ?>
            </select>
            <button type="submit" id="view-co-button"> View </button>
        </div>
    </form>


<?php
 if (isset($_POST["view-co"])) {
 include "getcoinfo.php";
 } 
?>
    
</body>
</html>