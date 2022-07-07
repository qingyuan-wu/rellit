// function onSignIn(googleUser) {
//     console.log(`User: ${JSON.stringify(googleUser.getBasicProfile())}`);
// }

// function init() {
//     params = {
//         client_id: "859550291312-jmcarebfcc8hrqkq4c1p7t5qt5cj7l5f.apps.googleusercontent.com"
//     }
//     gapi.load('auth2', function() {
//         gapi.auth2.init()
//     });
// }
// const jwt_decode = require("jwt-decode");

function handleCredentialResponse(res) {
    const resPayload = jwt_decode(res.credential);

    console.log("ID: " + resPayload.sub);
    console.log('Full Name: ' + resPayload.name);
    console.log('Given Name: ' + resPayload.given_name);
    console.log('Family Name: ' + resPayload.family_name);
    console.log("Image URL: " + resPayload.picture);
    console.log("Email: " + resPayload.email);

    document.getElementById("custom-greeting").innerHTML = `Hello ${resPayload.given_name}!`;
 }