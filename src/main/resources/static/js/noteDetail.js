	const message1 = "Are you sure you want to create this?";
	const message2 = "Are you sure you want to update this?";
	
	// check before submitting
  	function checkSubmit() 
	{
		let noteNo = document.getElementsByName('noteNo')[0].value;
		
		// setting confirm message
		alertMsg ="";
		noteNo == 0 ? alertMsg = message1 : alertMsg = message2;
			
		//　Show confirmation dialog
		if(window.confirm(alertMsg)){ 
			document.getElementsByName("pageType")[0].value = 1;
			return document.getElementById('noteDetailForm').submit(); 
		}
		else{ 
			//　Processing at Cancel
			alert("Canceled."); 
			return false; 
		}
	}
	
	//back page
/*	function backPage(){
			document.getElementsByName("pageType")[0].value = 0;
			return document.getElementById('noteDetailForm').submit(); 
	}
	
	//delete a record
	function checkDelete(){
		//　Show confirmation dialog
		if(window.confirm("Are you sure you want to delete this note?")){ 
			document.getElementsByName('pageType')[0].value = 2;
			return document.getElementById('noteDetailForm').submit(); 
		}
		else{ 
			// Processing at Cancel
			alert("Canceled."); 
			return false; 
		}
	}**/