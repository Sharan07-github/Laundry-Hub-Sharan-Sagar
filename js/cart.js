let cartData=[]

window.onload=function(){

let name=localStorage.getItem("userName")

if(name){
document.getElementById("username").innerText="Welcome "+name
}

loadCart()

}

function loadCart(){

let userId=localStorage.getItem("userId")

fetch(`http://localhost:8080/cart/user/${userId}`)
.then(res=>res.json())
.then(data=>{

cartData=data
displayCart()

})

}

function displayCart(){

let container=document.getElementById("cartContainer")
container.innerHTML=""

let total=0

cartData.forEach(item=>{

let price=item.price
let qty=item.quantity
let subtotal=price*qty

total+=subtotal

let row=`

<div class="cart-item">

<div class="cart-left">
<h5>${item.clothItem.itemName}</h5>
<p>${item.serviceType.serviceName}</p>
</div>

<div class="cart-middle">
<button onclick="changeQty(${item.id},-1)">-</button>
<span>${qty}</span>
<button onclick="changeQty(${item.id},1)">+</button>
</div>

<div class="cart-right">
<p>₹${subtotal}</p>
<button onclick="removeItem(${item.id})">Remove</button>
</div>

</div>

`

container.innerHTML+=row

})

document.getElementById("totalAmount").innerText="Total: ₹"+total

}

function changeQty(cartId,value){

let item=cartData.find(i=>i.id===cartId)

let newQty=item.quantity+value

if(newQty<1)return

item.quantity=newQty

fetch(`http://localhost:8080/cart/update/${cartId}`,{

method:"PUT",

headers:{"Content-Type":"application/json"},

body:JSON.stringify(item)

})
.then(()=>loadCart())

}

function removeItem(id){

fetch(`http://localhost:8080/cart/remove/${id}`,{
method:"DELETE"
})
.then(()=>{
showNotification("Item removed","success")
loadCart()
})

}

function placeOrder(){

let userId=localStorage.getItem("userId")

fetch("http://localhost:8080/orders/place",{

method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify({user:{id:userId}})

})
.then(()=>{

showNotification("Order placed successfully","success")

setTimeout(()=>{
window.location.href="services.html"
},1500)

})

}

function goServices(){
window.location.href="services.html"
}

function goToCart(){
window.location.href="cart.html"
}

function logout(){
localStorage.clear()
window.location.href="index.html"
}