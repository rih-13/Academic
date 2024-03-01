<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Western Computer Science Department Database </title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

    <div class="header" style="margin: 50px auto;"> 
        <button id="homeButton" onclick="window.location.href='mainmenu.php'">
            <img src="home.png" alt="Home" height="75px" width="auto">
        </button>
        <h1 >   Western Computer Science Department Database  </h1>
    </div>
    
    <div class=main-body> 
        <div class="vertical-menu"> 
            <button id="view-data-button"> VIEW DATA </button>
            <button id="edit-data-button"> EDIT DATA </button>
        </div>
    </div>
    
    <script>
        const viewDataButton = document.getElementById("view-data-button");
        const editDataButton = document.getElementById("edit-data-button");
        viewDataButton.addEventListener("click", function() {
            window.location.href = "view.php";
        });
        editDataButton.addEventListener("click", function() {
            window.location.href = "edit.php";
        });
    </script>
    
</body>
</html>