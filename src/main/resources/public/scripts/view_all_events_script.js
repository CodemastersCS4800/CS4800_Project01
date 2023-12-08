console.log("start")

getEventsData()


async function getEventsData(){
        const url = 'http://ec2-3-131-141-24.us-east-2.compute.amazonaws.com:8080/api/events/all'
	const response = await fetch (url)
	const data = await response.json()

	displayAllResults(data)
}

function displayAllResults(data) {
	//clear existing results
	const resultsContainer = document.querySelector('.events-container');
	resultsContainer.innerHTML = '';

	//loop through data and create html for each event
	data.forEach(event => {
		const eventCard = document.createElement('div');
		eventCard.className = 'event-card';
		eventCard.innerHTML = `
        <a href="event_detail_page.html?event_id=${event.eventId}">
          <div class="event-name">${event.name}</div>
        </a>
        <div class="event-info"><strong>Organizer:</strong> Alice</div>
        <div class="event-info"><strong>Date & Time:</strong> ${event.date}</div>
        <div class="event-info"><strong>Location:</strong> ${event.location.address}</div>
        <div class="event-info"><strong>Attendees:</strong> ${event.location.size} people joined</div>
      	`;
		resultsContainer.appendChild(eventCard);
    });
}

function toggleSave(element) {
	element.classList.toggle('active');
}
