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