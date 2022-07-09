// Places the user's coordinates in the Users table
function getCoordinates() {
    // Executes after successful getCurrentPosition() call
    function success(position) {
        const latitude  = position.coords.latitude;
        const longitude = position.coords.longitude;
        // TODO: insert the location information in the User table
        document.getElementById('location-container').innerHTML = latitude + ", " + longitude; // temp for proof of concept. 
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

/** Fetches questions from the server and adds them to the DOM. */
function loadQuestions() {
    fetch('/list-questions').then(response => response.json()).then((questions) => {
      const questionListElement = document.getElementById('question-list');
      questions.forEach((question) => {
        questionListElement.appendChild(createQuestionElement(question));
      })
    });
}
  
/** Creates an element that represents a question. */
function createQuestionElement(question) {
    const questionElement = document.createElement('li');

    // Elements for the question
    const titleElement = document.createElement('h4');
    titleElement.innerText = 'Question:';
    const textElement = document.createElement('p');
    textElement.innerText = question.text;

    // Elements for the time
    const timeTitleElement = document.createElement('h4');
    timeTitleElement.innerText = 'Time:';
    const timeElement = document.createElement('p');
    timeElement.innerText = question.timestamp;

    // Elements for the username
    const usernameElement = document.createElement('h4');
    usernameElement.innerText = 'Username:';
    const userElement = document.createElement('p');
    userElement.innerText = question.user;
  
    questionElement.appendChild(titleElement);
    questionElement.appendChild(textElement);
    questionElement.appendChild(timeTitleElement);
    questionElement.appendChild(timeElement);
    questionElement.appendChild(usernameElement);
    questionElement.appendChild(userElement);
    return questionElement;
}