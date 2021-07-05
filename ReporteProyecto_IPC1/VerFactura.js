var ls2 = JSON.parse(localStorage.getItem('facIndividual'));
const divTarjeta = document.getElementById('Tarjeta')
const divTabla = document.getElementById('Tabla')
var cl = JSON.parse(localStorage.getItem('clients'));
var pr = JSON.parse(localStorage.getItem('products'));
CrearTarjeta()
CrearTabla()

function CrearTarjeta(){
    console.log(ls2)
    var total = 0
    var id = 0
    var dir = ''
    var tel = ''
    var nit = ''
    var nombre =''
    
        
        for(let i=0;i<cl.length;i++){
            if(cl[i].id == ls2.client){
                id = cl[i].id
                nombre = cl[i].name
                dir = cl[i].address
                tel = cl[i].phone
                nit = cl[i].nit

            }
        }
        
    
    let html =``  
    html +=`<div class="card" style="width: 18rem; float: right">
    <div class="card-header">
      Datos de Factura
    </div>
    <ul class="list-group list-group-flush">
      <li class="list-group-item">Factura # ${ls2.id}</li>
      <li class="list-group-item">Fecha ${ls2.date}</li>
    </ul>
  </div>`
    html += `<div class="card" style="width: 18rem;">
    <div class="card-body">
      <h5 class="card-title">Datos del Cliente: </h5>
    </div>
    <ul class="list-group list-group-flush">
    <li class="list-group-item">Id: ${id}</li>
      <li class="list-group-item">Nombre: ${nombre}</li>
      <li class="list-group-item">Dirección: ${dir}</li>
      <li class="list-group-item">Teléfono: ${tel}</li>
      <li class="list-group-item">NIT: ${nit}</li>
    </ul>

  </div>`
  
  

divTarjeta.innerHTML = html
return html;
}

function CrearTabla(){

    let html =`` 
    var total = 0
    var n = 0 
    html += `<table class="table table-success table-striped">

    <thead>
        <tr><th>Id</th><th>Name</th><th>Description</th><th># Ingredientes</th><th>Price</th></tr>
    </thead>`
    for (let index2 = 0; index2 < ls2["products"].length; index2++) {
        total += ls2["products"][index2].price
    }
    for(let i=0;i<pr.length;i++){
        for(let j = 0; j<ls2["products"].length;j++){
            if(pr[i].name == ls2["products"][j].name){
                var id = pr[i].id
                var nombre = pr[i].name
                var des = pr[i].description
                var pre = pr[i].price
                var cant = pr[i]["ingredients"].length
                html +=`
                <tbody>
                    <tr><th>${id}</th><td>${nombre}</td><td>${des}</td><td>${cant}</td><td>${ls2["products"][j].price}</td>`
        
            
            }
        }
    
    }
    html +=`<tr><th></th><td></td><td></td><td><b>TOTAL</b></td><td>Q${total}</td></tr>`
   
    

for (let index = 0; index < ls2["products"].length; index++) {
}
html +=` </tbody>
</table>`
divTabla.innerHTML = html
return html;
}