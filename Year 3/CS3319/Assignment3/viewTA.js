/* View TA Page */



/* upon loading, get saved selections from local storage and display on page if not null */
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("pick-category").value = "course";

    const storedSort = localStorage.getItem("selectedSort");
    if (storedSort !== null) {
        document.getElementById("sort-category").value = storedSort;
    }

    const storedDirection = localStorage.getItem("selectedDirection");
    if (storedDirection !== null) {
        document.querySelector(`input[name="name-sort-direction"][value="${storedDirection}"]`).checked = true;
    }

    const storedFilter = localStorage.getItem("selectedFilter");
    if (storedFilter !== null) {
        document.querySelector(`input[name="ta-filter"][value="${storedFilter}"]`).checked = true;
    }

    toggleSortOptions();
});

/* When user clicks sort saves selections from selection bar to local storage */
function saveData() {

    const sortCategory = document.querySelector('#sort-category');
    localStorage.setItem("selectedSort", sortCategory ? sortCategory.value : "lastname");

    const sortDirection = document.querySelector('input[name="name-sort-direction"]:checked');
    localStorage.setItem("selectedDirection", sortDirection ? sortDirection.value : "ascending");

    const filter = document.querySelector('input[name="ta-filter"]:checked');
    localStorage.setItem("selectedFilter", filter ? filter.value : "all");
}
const sortTAButton = document.getElementById("sort-ta-button"); 
sortTAButton.addEventListener("click", saveData);


/* If selecting sort by last name, make asc/desc options visible, otherwise hide */
function toggleSortOptions() {
    var sortCategory = document.getElementById("sort-category");
    var nameSortContainer = document.getElementById("name-sort-container");
  
    if (sortCategory.value === "lastname") {
      nameSortContainer.style.display = "block";
    } else {
      nameSortContainer.style.display = "none";
    }
}


  
