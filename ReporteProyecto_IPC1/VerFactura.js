var ls2 = JSON.parse(localStorage.getItem('facIndividual'));
const divTarjeta = document.getElementById('Tarjeta')
const divTabla = document.getElementById('Tabla')
var cl = JSON.parse(localStorage.getItem('clients'));
var pr = JSON.parse(localStorage.getItem('products'));
var ls = JSON.parse(localStorage.getItem('config'));
const divEncabezado = document.getElementById('encabezado')


var arrProd = new Array (10)
FiltrarProductosRepetidos()

var uniqs = arrProd.filter(function(item, index, array) {
  return array.indexOf(item) === index;
})

CrearTarjeta()
CrearTabla()
Encabezado()

function Encabezado (){
  var ls = JSON.parse(localStorage.getItem('config'));
  let html =``  
  html += ` ${ls.name} - ${ls.address} - ${ls.phone}`
divEncabezado.innerHTML = html
return html;
}

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

    html += `<div class="card" style="width: 18rem; float: left; background-color: #d1e4dc">
    <div class="card-body">
      <h5 class="card-title"><b>Datos del Cliente: </b></h5>
    </div>
    <ul class="list-group list-group-flush">
    <li class="list-group-item" style="background-color: #c7d9d2">Id: ${id}</li>
      <li class="list-group-item" style="background-color: #d1e4dc">Nombre: ${nombre}</li>
      <li class="list-group-item" style="background-color: #c7d9d2">Dirección: ${dir}</li>
      <li class="list-group-item" style="background-color: #d1e4dc">Teléfono: ${tel}</li>
      <li class="list-group-item" style="background-color: #c7d9d2">NIT: ${nit}</li>
    </ul>

  </div><br><br><br><br><br><br>`
  html +=`<div class="card" style="width: 18rem; float: right; background-color: #d1e4dc">
    <div class="card-header">
    
      <b>Datos de Factura</b>
    </div>
    <ul class="list-group list-group-flush">
      <li class="list-group-item" style="background-color: #c7d9d2">Factura # ${ls2.id}</li>
      <li class="list-group-item" style="background-color: #d1e4dc">Fecha ${ls2.date}</li>
    </ul>
  </div>`
    
  
  

divTarjeta.innerHTML = html
return html;
}


function CantidadDeProductos(nombreProduct){
let cont=0;
    for (let j=0; j< ls2["products"].length; j++) {
      if(nombreProduct==ls2["products"][j].name){
        cont ++
    }
  }
  return cont;
}



function FiltrarProductosRepetidos (){
  for (let i=0; i< ls2["products"].length; i++) {
        arrProd[i]=ls2["products"][i].name
        
    }
}


function CrearTabla(){
   
    let html =`` 
    var total = 0
    var n = 0 
    html += `<table class="table table-success table-striped">

    <thead>
        <tr><th>Id</th><th>Name</th><th>Description</th><th>Cantidad</th><th>Price</th><th>Total Price</th></tr>
    </thead>`
  //  for (let index2 = 0; index2 < ls2["products"].length; index2++) {
  //      total += ls2["products"][index2].price
  //  }
        for(let j = 0; j<uniqs.length;j++){
          var cont=0
          for(let i=0;i<pr.length;i++){

            if(pr[i].name == uniqs[j]){
              cont ++;
                var id = pr[i].id
                var nombre = pr[i].name
                var des = pr[i].description
                var pre1 = pr[i].price
                

                

                var cant = CantidadDeProductos(uniqs[j])
                var pre = pr[i].price*cant;
                total += pre
                html +=`
                <tbody>
                    <tr><th>${id}</th><td>${nombre}</td><td>${des}</td><td>${cant}</td><td>${pre1}</td><td>${pre}</td>`
        
            
            } 
        }
        if (cont==0){
          var cant = CantidadDeProductos(uniqs[j])
            var pre = ls2["products"][j].price*cant;
            total += pre
          html +=`
          <tbody>
              <tr><th></th><td>${uniqs[j]}</td><td></td><td>${cant}</td><td>${ls2["products"][j].price}</td><td>${pre}</td>`
        }
    
    }
    html +=`<tr><th></th><td></td><td></td><td></td><td><b>TOTAL</b></td><td>Q${total}</td></tr>`
   
    

for (let index = 0; index < ls2["products"].length; index++) {
}
html +=` </tbody>
</table>`
divTabla.innerHTML = html
return html;
}