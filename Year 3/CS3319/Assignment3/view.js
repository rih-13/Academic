const viewNowButton = document.getElementById("view-data-now-button");
viewNowButton.addEventListener("click", loadPage);



/* loads either courses or ta page */
function loadPage() {
    const selectCategory = document.querySelector('#pick-category');
    if (selectCategory.value == "course") {
        window.location.href = "viewCourses.php";
    } else if (selectCategory.value == "ta") {
        window.location.href = "viewTA.php";
    }
}