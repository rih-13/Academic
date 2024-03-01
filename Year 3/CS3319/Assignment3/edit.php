<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Western Computer Science Department Database</title>
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

            <form method="post" action="insertta.php" 
            onsubmit="return checkInput('given-name') && checkInput('last-name') && checkInput('studentnum') && checkInput('tauserid') && checkRadio('degree-type')">
                <div> 
                    <label for="given-name" class="inputLabel"> Create New TA </label>
                    <label>
                        Given Name(s)
                        <input type="text" name="given-name" id="given-name" maxlength="30">
                    </label>
                    <label>
                        Last Name 
                        <input type="text" name="last-name" id="last-name" maxlength="30">
                    </label>
                    <label>
                        Student Number
                        <input type="text" name="studentnum" id="studentnum" maxlength="9">
                    </label>
                    <label>
                        User ID
                        <input type="text" name="tauserid" id="tauserid" maxlength="8">
                    </label>
                    <input type="radio" id="masters" name="degree-type" value="Masters">
                    <label for="masters">Masters</label>
                    <input type="radio" id="phd" name="degree-type" value="PhD">
                    <label for="phd">PhD</label>
                    <div>
                        <button type="button" onclick="openModal()" style="font-size: 12; font-weight: 400; padding=4px" > Select Loved and Hated Courses </button>
                    </div>

                    <!-- Modal -->
                    <div id="courseModal" class="modal" display="none" style="display:none">
                        <div class="modal-content">
                            <span class="close" onclick="closeModal()" style="font-weight: 700";>&times;</span> <br>
                            <?php
                            include "getcoursecheckbox.php";
                            ?>
                        </div>
                    </div>



                    <button type="submit"> Create </button>
                </div>
            </form>
            <br>
            <br>







            <form method="post" action="deleteta.php" onsubmit="return confirmDelete()">
                <div> 
                    <label for="delete-ta" class="inputLabel"> Delete TA </label>
                    <select name="delete-ta" id="delete-ta"> 
                        <?php
                        include "gettalist.php";
                        ?>
                    </select>
                    <button type="submit"> Delete </button>
                </div>
            </form>
            <br>
            <br>

            <form method="post" action="modifyimage.php" onsubmit="return checkInput('url')">
                <div> 
                    <label for="modify-image" class="inputLabel"> Upload Profile Picture </label>
                    <select name="modify-image" id="modify-image"> 
                        <?php
                        include "gettalist.php";
                        ?>
                    </select>
                    <label> Image URL </label>
                    <input type="text" name="url" id="url" maxlength="200">
                    <button type="submit"> Upload </button>
                </div>
            </form>
            <br>
            <br>

            <form method="post" action="assignTA.php" onsubmit="return checkInput('assign-hours')">
                <div> 
                    <label for="assign-ta" class="inputLabel"> Assign TA </label>
                    <select name="assign-ta" id="assign-ta"> 
                        <?php
                        include "gettalist.php";
                        ?>
                    </select>
                    <select name="assign-co" id="assign-co"> 
                        <?php
                        include "getcolist.php";
                        ?>
                    </select>
                    <label> Hours </label>
                    <input type="number" name="assign-hours" id="assign-hours">
                    <button type="submit"> Assign </button>
                </div>
            </form>






        </div>
    </div>

    <script> 
        /* Checks if input for given ID is empty, alerts user and prevents form submission */
        function checkInput(inputID) {
            var input = document.getElementById(inputID);
            if (!input.value || input.value.trim() === '') {
                alert("Please enter a value for all fields.");
                return false;
            }
            return true;
        }

        /** Returns true if at least one button in given group is checked */
        function checkRadio(radioGroupName) {
            var radioButtons = document.getElementsByName(radioGroupName);
            var buttonChecked = false;

            for (var i = 0; i < radioButtons.length; i++) {
                if (radioButtons[i].checked) {
                    buttonChecked = true;
                    break;
                }
            }

            if (buttonChecked === false) {
                alert("Please select a program.");
            }

            return buttonChecked;
        }

        function confirmDelete() {
            return confirm("Are you sure you want to delete this TA?");
        }


    function openModal() {
        document.getElementById('courseModal').style.display = 'block';
    }

    function closeModal() {
        document.getElementById('courseModal').style.display = 'none';
    }
    </script>
        
    
</body>
</html>