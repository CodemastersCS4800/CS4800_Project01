
window.onload = function() {
	//get url parameter
	const params = new URLSearchParams(window.location.search);
	const eventId = params.get('event_id'); // "123" in this code
	//use eventId to load event detail 		
	const url = 'http://ec2-3-131-141-24.us-east-2.compute.amazonaws.com:8080/api/events/'+eventId
	const response = fetch (url)
		.then((response) => response.json())
		.then(function (data) {
			//code to display here
			const eventCard = document.getElementById("general-info")

			eventCard.innerHTML = `
				<div class="event-info">Organizer: Alice</div>
				<div class="event-info">Date and Time: ${data.date} at ${data.timeline.startTime}</div>
				<div class="event-info">Location: ${data.location.address}</div>
				<div class="event-info">Number of People Joined: ${data.location.size}</div>
			`
			
			const eventDesc = document.getElementById("about-event")
			eventDesc.innerHTML = ``
		})
};

function shareEvent() {
	const currentUrl = window.location.href;
	navigator.clipboard.writeText(currentUrl).then(() => {
		alert("Event URL copied to clipboard!");
	}, (err) => {
		console.error('Error copying URL: ', err);
	});
}
function joinEvent(eventId) {
	alert('You have successfully joined the event!');
}
function saveEvent(eventId) {
	//check if saved Events exists in local storage
	let savedEvents = localStorage.getItem('savedEvents');
	savedEvents = savedEvents ? JSON.parse(savedEvents) : [];

	//add the eventID to the array if not already present
	if (!savedEvents.includes(eventId)) {
		savedEvents.push(eventId);
		localStorage.setItem('savedEvents', JSON.stringify(savedEvents));
		alert('Event saved!');
	} else {
		alert('Event already saved.');
	}
}
function editEvent(eventId) {
	window.location.href = 'edit_event_page.html?event_id=' + eventId;
}
function goBack() {
	window.history.back();
}

