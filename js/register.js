document.getElementById("registerForm").addEventListener("submit",function(e){

e.preventDefault()

let user={

name:document.getElementById("name").value,
email:document.getElementById("email").value,
password:document.getElementById("password").value,
phone:document.getElementById("phone").value,
address:document.getElementById("address").value,
city:document.getElementById("city").value,
role:"USER"

}

fetch("http://localhost:8080/users/register",{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify(user)

})

.then(res => {

if(!res.ok){
throw new Error("Email or Phone already exists")
}

return res.json()

})

.then(data=>{

showNotification("Registration Successful","success")

document.getElementById("registerForm").reset()

setTimeout(()=>{
window.location.href="login.html"
},1500)

})

.catch(err=>{
showNotification(err.message,"error")
})

})