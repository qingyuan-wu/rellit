// Places the user's coordinates in the Users table
function getCoordinates() {
    const container = document.getElementById('location-container');
    // Executes after successful getCurrentPosition() call
    function success(position) {
        const latitude  = position.coords.latitude;
        const longitude = position.coords.longitude;
        // TODO: insert the location information in the User table
        container.innerHTML = latitude + ", " + longitude; // temp for proof of concept. 
    }
    // Informs user that their location cannot be determined
    function error() {
        container.innerHTML = 'Unable to retrieve your location';
    }
    // Attempts to get the position only if supported by browser
    if(!navigator.geolocation) {
        container.textContent = 'Geolocation is not supported by your browser';
    } else {
        navigator.geolocation.getCurrentPosition(success, error);
    }
}