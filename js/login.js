document.getElementById("loginForm").addEventListener("submit",function(e){

e.preventDefault()

let user={

email:document.getElementById("email").value,
password:document.getElementById("password").value

}

fetch("http://localhost:8080/users/login",{

method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify(user)

})
.then(res=>{

if(!res.ok){
throw new Error("Invalid Email or Password")
}

return res.json()

})
.then(data=>{

showNotification("Login Successful","success")

localStorage.setItem("userId",data.id)
localStorage.setItem("userName",data.name)

setTimeout(()=>{
window.location.href="services.html"
},1200)

})
.catch(error=>{

showNotification(error.message,"error")

})

})