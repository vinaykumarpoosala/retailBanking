
var myInput1 = document.getElementById("userName")
var myInput = document.getElementById("psw");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
	document.getElementById("messageToDisaplay").innerHTML = " Password must match the following creteria";

}

myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}
myInput.onkeyup = function() {
	document.getElementById("messageToDisaplay").innerHTML = " Password must match the following creteria";

  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }
  
 
  if(myInput.value.length >= 10) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}


myInput1.onfocus = function() {
	  document.getElementById("message").style.display = "block";
		document.getElementById("messageToDisaplay").innerHTML = " UserID must match the following creteria";

	}

	myInput1.onblur = function() {

	  document.getElementById("message").style.display = "none";
	}
	myInput1.onkeyup = function() {
		
		document.getElementById("messageToDisaplay").innerHTML = " UserID must match the following creteria";


	  var upperCaseLetters = /[A-Z]/g;
	  if(myInput1.value.match(upperCaseLetters)) {  
	    capital.classList.remove("invalid");
	    capital.classList.add("valid");
	  } else {
	    capital.classList.remove("valid");
	    capital.classList.add("invalid");
	  }
	  
	 
	  if(myInput1.value.length >= 8) {
	    length.classList.remove("invalid");
	    length.classList.add("valid");
	  } else {
	    length.classList.remove("valid");
	    length.classList.add("invalid");
	  }
	}
