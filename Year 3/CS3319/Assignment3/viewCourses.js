


function toggleCourse() {
    const taDropDown = document.getElementById("findco-ta");
    const courseDropDown = document.getElementById("findco-course");
    const startYearInput = document.getElementById("co-start-year");
    const endYearInput = document.getElementById("co-end-year");
    taDropDown.disabled = true;
    courseDropDown.disabled = false;
    startYearInput.disabled = false;
    endYearInput.disabled = false;

}

function toggleTA() {
    const taDropDown = document.getElementById("findco-ta");
    const courseDropDown = document.getElementById("findco-course");
    const startYearInput = document.getElementById("co-start-year");
    const endYearInput = document.getElementById("co-end-year");
    taDropDown.disabled = false;
    courseDropDown.disabled = true;
    startYearInput.disabled = true;
    endYearInput.disabled = true;
}

function validateForm() {
    var startYearInput = document.getElementById('co-start-year');
    var endYearInput = document.getElementById('co-end-year');

    if (startYearInput.value.trim() !== '') { //check start year 
        var startYear = parseInt(startYearInput.value, 10);
        if (!isValidYear(startYear)) {
            alert('Please enter a valid start year between 0 and 9999.');
            return false;
        }
    }

    if (endYearInput.value.trim() !== '') { //check end year
        var endYear = parseInt(endYearInput.value, 10);
        if (!isValidYear(endYear)) {
            alert('Please enter a valid end year between 0 and 9999.');
            return false;
        }
    }

    // Check if start year is before or equal to end year, if both are provided
    if (startYearInput.value.trim() !== '' && endYearInput.value.trim() !== '' && startYear > endYear) {
        alert('Start year must be before or equal to end year.');
        return false;
    }

    return true;
}



function isValidYear(year) {
    return !isNaN(year) && year >= 0 && year <= 9999;
}
