
const eventForm = document.getElementById('eventForm')

if(eventForm){
	eventForm.addEventListener('submit', function (event) {
		event.preventDefault(); //prevent the default form submission

		//gather the form data
		const formData = new FormData(event.target);

		//fetch request here
		postToEvents(formData)

		//window.location.href = 'homepage.html';
	})
}

function cancelForm() {
	var form = document.getElementById('eventForm');
	form.reset();
	window.history.back();
}

function postToEvents(FData){
	//setup post request
	const eventName = FData.get("name")
	const eventDate = FData.get("date")
	
	const url = 'http://ec2-3-131-141-24.us-east-2.compute.amazonaws.com:8080/api/events/add?CustomerID=1'
	errorOcc = false

	console.log("make req")

	fetch(url, {
		method: 'POST',
		mode: 'cors',
		body: JSON.stringify({name:eventName, date:eventDate}),
		headers: {
			'Content-Type': 'application/json'
		}
	})
		.catch(function(error){ console.error('Error: ', error); errorOcc = true})
		.then(function (response) {return response.json() })
		.then(function (data) {
			console.log(data.eventId)
			return data
		})
		.then(function (data) {
			if(data.eventId != null){
				postToLocations(FData, data.eventId);
				postToLocations(FData, data.eventId);
				postToTimeline(FData, data.eventId);
			}
		})

	if(!errorOcc){
		alert("Event made!")
		window.location.href = 'homepage.html';
	}
}

function postToLocations(FData, eventID){
	//setup post request
	const locationAddress = FData.get("address")	
	const locationSize = "500sqft"
	const locationMaxCap = 500
	
	const url = 'http://ec2-3-131-141-24.us-east-2.compute.amazonaws.com:8080/api/locations/add?EventID=' + eventID
	console.log(url)
	errorOcc = false

	console.log("make req")

	fetch(url, {
		method: 'POST',
		mode: 'cors',
		body: JSON.stringify({address:locationAddress, size: locationSize, maxCapacity: locationMaxCap}),
		headers: {
			'Content-Type': 'application/json'
		}
	}).catch(function(error){ console.error('Error: ', error); errorOcc = true})

	console.log("end")
}

function postToTimeline(FData, eventID){
	//setup post request
	const timelineStartTime = FData.get("startTime")
	const timelineEndTime = FData.get("endTime")

	const url = 'http://ec2-3-131-141-24.us-east-2.compute.amazonaws.com:8080/api/timeline/add?EventID=' + eventID
	console.log(url)
	errorOcc = false

	console.log("make req")

	fetch(url, {
		method: 'POST',
		mode: 'cors',
		body: JSON.stringify({startTime:timelineStartTime, endTime:timelineEndTime}),
		headers: {
			'Content-Type': 'application/json'
		}
	}).catch(function(error){ console.error('Error: ', error); errorOcc = true})

	console.log("end")
}
