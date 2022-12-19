	// check before submitting
  	function checkSubmit() 
	{
		let password = document.getElementById('password').value;
		let password2 = document.getElementById('password2').value;
		
		if(password != password2){
			alert("Password doesn't match.");
			return false;
		}
		else{
			//　Show confirmation dialog
			if(window.confirm("Do you want to register?")){ 
				return document.getElementById('userRegister').submit(); 
			}
			else{ 
				//　Processing at Cancel
				window.alert('Canceled.'); 
				return false; 
			}
		}
	}