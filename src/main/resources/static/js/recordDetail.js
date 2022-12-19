	const message1 = "Are you sure you want to create this?";
	const message2 = "Are you sure you want to update this?";
	
	
	// onload
	window.onload = function(){
		const status = document.getElementsByName("status")[0].value;
		switch(status)
		{
			case "1":
				document.getElementById("status1").checked = true;
			break;
			case "2":
				document.getElementById("status2").checked = true;
			break;
			case "3":
				document.getElementById("status3").checked = true;
			break;
		}
	}

	//select one from checkbox
	function chbx(obj) 
	{
		let that = obj;
		if (document.getElementById(that.id).checked == true)
		{
			let boxes = document.querySelectorAll('input[type="checkbox"]');
			for(let i = 0; i < boxes.length; i++)
			{
				boxes[i].checked = false;
			}
			document.getElementById(that.id).checked = true;
			document.getElementsByName('status')[0].value = document.getElementById(that.id).value;
		}
	} 
	
	// check before submitting
  	function checkSubmit() 
	{
		let startDate = document.getElementById('startDate').value;
		let endDate = document.getElementById('endDate').value;
		let status = document.getElementsByName('status')[0].value;
		let recordNo = document.getElementsByName('recordNo')[0].value;
		let check = false;
		
		switch(status){
			case "1":
			case "2":
				if(startDate == "")
					alert("select start date.");
				else if(endDate != "")
					alert("Don't select end date.");
				else
					check = true;
				break;
			
			case "3":
				if(startDate == "" || endDate == "")
				{
					alert("Date period is incorrect.");
				}else
				{
					// change date type
					date1 = new Date(startDate);
					date2 = new Date(endDate);
					
					if(date1 > date2)
						alert("Date period is incorrect.");
					else if(status == 0)
						alert("please select status.");
					else
						check = true;
				}
				break;
			default:
				alert("please select status.");
			break;
		}
		
		if(!check){
			return false;
		}
		else{
				// setting confirm message
				alertMsg ="";
				recordNo == 0 ? alertMsg = message1 : alertMsg = message2;
				
			//　Show confirmation dialog
			if(window.confirm(alertMsg)){ 
				document.getElementsByName("pageType")[0].value = 1;
				return document.getElementById('recordDetailForm').submit(); 
			}
			else{ 
				//　Processing at Cancel
				alert("Canceled."); 
				return false; 
			}
		}
	}
	//back page
	/*function backPage(){
			document.getElementsByName("pageType")[0].value = 0;
			return document.getElementById('recordDetailForm').submit(); 
	}
	
	//delete a record
	function checkDelete(){
		//　Show confirmation dialog
		if(window.confirm("Are you sure you want to delete this record?")){ 
			document.getElementsByName('pageType')[0].value = 2;
			return document.getElementById('recordDetailForm').submit(); 
		}
		else{ 
			// Processing at Cancel
			alert("Canceled."); 
			return false; 
		}
	}*/