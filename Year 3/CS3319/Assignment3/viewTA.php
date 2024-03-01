<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Teaching Assistants </title>
    <link rel="stylesheet" href="styles.css">
    <script src="view.js" defer></script>
    <script src="viewTA.js" defer></script>
</head>

<body>

    <div class="header" style="margin: 50px auto;"> 
        <button id="homeButton" onclick="window.location.href='mainmenu.php'">
            <img src="home.png" alt="Home" height="75px" width="auto">
        </button>
        <h1 >   Western Computer Science Department Database  </h1>
    </div>


    <label for="pick-category">Show</label>
     <select id="pick-category" name="pick-category"> 
            <option value="course">Courses</option>
            <option value="ta">Teaching Assistants</option>
    </select>
    <button id="view-data-now-button"> View Now </button> <br>

    <form method="post" action="">
        <div class="selection-bar">

            <label for="sort-category">Sort By </label>
            <select name="sort-category" id="sort-category" onchange="toggleSortOptions()"> 
            
                <option value="lastname">Last Name</option>
                <option value="degreetype">Program Type</option>
            </select>

            <div id="name-sort-container" style="margin-right: 35px"> 
                <input type="radio" id="ascending" name="name-sort-direction" value="ascending" checked>
                <label for="ascending">Ascending</label>
                <input type="radio" id="descending" name="name-sort-direction" value="descending">
                <label for="descending">Descending</label>
            </div>

            
            <div id="ta-filter-container"> 
            <label for="ta-filter-container"> Filter </label>
                <input type="radio" id="all" name="ta-filter" value="all" checked>
                <label for="all">All</label>
                <input type="radio" id="masters" name="ta-filter" value="masters">
                <label for="masters">Masters</label>
                <input type="radio" id="phd" name="ta-filter" value="phd">
                <label for="phd">PhD</label>
            </div>

            <button type="submit" id="sort-ta-button"> Sort </button>
        </div>
    </form>

    <br> 

    <div class="text-body"> 
        <table class="ta-table"> 
            <tr>
                <th> Name </th>
                <th> Program </th>
                <th> User ID </th>
                <th> Student Number </th>
            </tr>
            <?php
            if ($_SERVER["REQUEST_METHOD"] == "POST") {
            include "getta.php";  // Include getta.php to handle sorting
            }
            ?>
        </table>
    </div>

    <form method="post" action="">
        <div class="selection-bar">

            <label for="view-ta"> Find TA </label>
            <select name="view-ta" id="view-ta"> 
                <?php
                include "gettalist.php";
                ?>
            </select>
            <button type="submit" id="view-ta-button"> View </button>
        </div>
    </form>
<hr>

<?php
 if (isset($_POST['view-ta'])) {
 include "gettainfo.php";
 } 
?>


        
    
</body>
</html>