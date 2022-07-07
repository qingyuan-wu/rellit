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

/** Fetches tasks from the server and adds them to the DOM. */
function loadQuestions() {
    fetch('/list-responses').then(response => response.json()).then((questions) => {
      const taskListElement = document.getElementById('response-list');
      questions.forEach((question) => {
        taskListElement.appendChild(createQuestionElement(question));
      })
    });
}
  
/** Creates an element that represents a task, including its delete button. */
function createQuestionElement(question) {
    const taskElement = document.createElement('li');
    taskElement.className = 'response';
  
    const titleElement = document.createElement('span');
    titleElement.innerText = task.title;
  
    const deleteButtonElement = document.createElement('button');
    deleteButtonElement.innerText = 'Delete';
  
    taskElement.appendChild(titleElement);
    taskElement.appendChild(deleteButtonElement);
    return taskElement;
}
  