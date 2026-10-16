let pricingData=[]

window.onload=function(){

    let name=localStorage.getItem("userName")

if(name){
document.getElementById("username").innerText="Welcome "+name
}

loadPricing()
}

function loadPricing(){

fetch("http://localhost:8080/pricing/all")

.then(res=>res.json())

.then(data=>{
pricingData=data
groupServices()
})

}

function groupServices(){

let grouped={}

pricingData.forEach(item=>{

let clothId=item.clothItem.id

if(!grouped[clothId]){
grouped[clothId]={
clothName:item.clothItem.itemName,
services:[]
}
}

grouped[clothId].services.push({
serviceId:item.serviceType.id,
serviceName:item.serviceType.serviceName,
price:item.price
})

})

display(grouped)

}

function display(grouped){

let container=document.getElementById("servicesContainer")
container.innerHTML=""

Object.keys(grouped).forEach(clothId=>{

let cloth=grouped[clothId]

let servicesHTML=cloth.services.map(service=>`

<div class="service-option">

<input type="checkbox"
data-price="${service.price}"
data-service="${service.serviceId}"
id="chk_${clothId}_${service.serviceId}"
onchange="updateTotal(${clothId})">

<label>${service.serviceName} ₹${service.price}</label>

</div>

`).join("")

let card=`

<div class="col-md-4 mb-4">

<div class="service-box">

<h4>${cloth.clothName}</h4>

${servicesHTML}

<div class="quantity-box">

<button onclick="changeQty(${clothId},-1)">-</button>

<span id="qty_${clothId}">1</span>

<button onclick="changeQty(${clothId},1)">+</button>

</div>

<p class="total" id="total_${clothId}">Total ₹0</p>

<button onclick="addToCart(${clothId})">
Add To Cart
</button>

</div>

</div>

`

container.innerHTML+=card

})

}

function changeQty(clothId,value){

let qtyElement=document.getElementById(`qty_${clothId}`)

let qty=parseInt(qtyElement.innerText)

qty+=value

if(qty<1) qty=1

qtyElement.innerText=qty

updateTotal(clothId)

}

function updateTotal(clothId){

let qty=parseInt(document.getElementById(`qty_${clothId}`).innerText)

let checkboxes=document.querySelectorAll(`input[id^="chk_${clothId}_"]`)

let total=0

checkboxes.forEach(chk=>{
if(chk.checked){
total+=parseFloat(chk.dataset.price)
}
})

total=total*qty

document.getElementById(`total_${clothId}`).innerText="Total ₹"+total

}

function addToCart(clothId){

let userId=localStorage.getItem("userId")

let qty=parseInt(document.getElementById(`qty_${clothId}`).innerText)

let checkboxes=document.querySelectorAll(`input[id^="chk_${clothId}_"]`)

let selected=[]

checkboxes.forEach(chk=>{
if(chk.checked){
selected.push(chk.dataset.service)
}
})

if(selected.length===0){
showNotification("Select service","error")
return
}

selected.forEach(serviceId=>{

let cart={

user:{id:userId},
clothItem:{id:clothId},
serviceType:{id:serviceId},
quantity:qty

}

fetch("http://localhost:8080/cart/add",{

method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify(cart)

})

})

showNotification("Added to cart","success")

}

function goToCart(){
    window.location.href="cart.html"
}

function goServices(){
    window.location.href="services.html"
}

function logout(){
    localStorage.removeItem("userId")
    localStorage.removeItem("userName")
    window.location.href="index.html"
}