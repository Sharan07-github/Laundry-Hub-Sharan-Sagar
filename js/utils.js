function showNotification(message,type){

let notify=document.createElement("div")

notify.classList.add("notification",type)

notify.innerText=message

document.body.appendChild(notify)

setTimeout(()=>{
notify.classList.add("show")
},100)

setTimeout(()=>{
notify.classList.remove("show")
notify.remove()
},3000)

}