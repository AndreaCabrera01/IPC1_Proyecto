var ls2 = JSON.parse(localStorage.getItem('clientIndividual'));
const divTarjeta = document.getElementById('Tarjeta')
CrearTarjeta()

function CrearTarjeta(){
    console.log(ls2)
    let html =``  
    html += `<center><div class="card" style="width: 18rem;">
    <img src="https://icones.pro/wp-content/uploads/2021/02/icone-utilisateur-orange.png" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">${ls2.name}</h5>
      <p class="card-text">Id: ${ls2.id}</p>
    </div>
    <ul class="list-group list-group-flush">
      <li class="list-group-item">Dirección: ${ls2.address}</li>
      <li class="list-group-item">Teléfono: ${ls2.phone}</li>
      <li class="list-group-item">NIT: ${ls2.nit}</li>
    </ul>
   
  </div></center>`

  

divTarjeta.innerHTML = html
return html;
}