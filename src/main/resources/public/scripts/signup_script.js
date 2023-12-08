const signupForm = document.getElementById('signup_form')
console.log("start")

if(signupForm){
	console.log("Hi")
	signupForm.addEventListener('submit', function (event) {
		event.preventDefault(); //prevent the default form submission

		//gather the form data
		const formData = new FormData(event.target);
		
		const CustomerData = {
			name: formData.get("name"),
			email: formData.get("email"),
			password: formData.get("pass")
		}
		const url = 'http://ec2-3-131-141-24.us-east-2.compute.amazonaws.com:8080/api/customer/add'

		errorOcc = false

		console.log("make req")

		fetch(url, {
			method: 'POST',
 			mode: 'cors',
			body: JSON.stringify(CustomerData),
			headers: {
				'Content-Type': 'application/json'
			}
		}).catch(function(error){ console.error('Error: ', error); errorOcc = true})
		

		if(!errorOcc){
			window.location.href = 'homepage.html';
		}

		console.log("end")
	})
}

