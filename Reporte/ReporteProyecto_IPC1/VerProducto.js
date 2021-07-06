var ls2 = JSON.parse(localStorage.getItem('produIndividual'));
const divTarjeta = document.getElementById('Tarjeta')
CrearTarjeta()

function CrearTarjeta(){
    console.log(ls2)
    let html =``  
    html += `<center><div class="card" style="width: 18rem;">
    <img src="extra/fork.png" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">${ls2.name}</h5>
      <p class="card-text">Id: ${ls2.id}</p>
    </div>
    <ul class="list-group list-group-flush">
      <li class="list-group-item">${ls2.description}</li>
      <li class="list-group-item">Costo: Q${ls2.cost}</li>
      <li class="list-group-item">Precio: Q${ls2.price}</li>
    </ul>
   
  </div><h3>Ingredientes:</h3>`

  for (let index = 0; index < ls2["ingredients"].length; index++) {
        html+=`<div class="card" style="width: 18rem;">
        <div class="card-header">
          ${ls2["ingredients"][index].name}
        </div>
        <ul class="list-group list-group-flush">
          <li class="list-group-item">Cantidad: ${ls2["ingredients"][index].quantity}</li>
          <li class="list-group-item">Unidades: ${ls2["ingredients"][index].units}</li>
        </ul>
      </div>`
  }
  html+=`</center>`
  

divTarjeta.innerHTML = html
return html;
}

const divEncabezado = document.getElementById('encabezado')    
Encabezado();
function Encabezado (){
    var ls = JSON.parse(localStorage.getItem('config'));
    let html =``  
    html += ` ${ls.name} - ${ls.address} - ${ls.phone}`
divEncabezado.innerHTML = html
return html;
}