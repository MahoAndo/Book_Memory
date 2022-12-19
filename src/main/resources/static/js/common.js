//back page
function backPage(form){
		document.getElementsByName("pageType")[0].value = 0;
		return document.getElementById(form).submit(); 
}

//create New
function createNew(form){
		document.getElementsByName("pageType")[0].value = 1;
		return document.getElementById(form).submit(); 
}

//get a csv file
function getCsv(form){
	//　Show confirmation dialog
	if(window.confirm("Are you sure you want to get a CSV file?")){ 
		document.getElementsByName("pageType")[0].value = 2;
		return document.getElementById(form).submit(); 
	}
	else{ 
		// Processing at Cancel
		alert("Canceled."); 
		return false; 
	}
}

//delete a record
function checkDelete(form){
	//　Show confirmation dialog
	if(window.confirm("Are you sure you want to delete this note?")){ 
		document.getElementsByName('pageType')[0].value = 2;
		return document.getElementById(form).submit(); 
	}
	else{ 
		// Processing at Cancel
		alert("Canceled."); 
		return false; 
	}
}