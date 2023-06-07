document.getElementById("user").innerHTML = window.localStorage.getItem('user')
function submitform() {
  var saveme = document.getElementById("saveme").checked;
  var username = document.getElementById("username").value;
  if(saveme){
      localStorage.removeItem('user')
      localStorage.setItem("user",username);
  }
}