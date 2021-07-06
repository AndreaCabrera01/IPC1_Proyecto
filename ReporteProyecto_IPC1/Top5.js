
var ls = JSON.parse(localStorage.getItem('facturas'));
var pr = JSON.parse(localStorage.getItem('products'));

const divTop = document.getElementById('Top')
let TopProducto = new Array()
ContarCant()
result = BubbleSort(TopProducto)
Mostrar()
CrearTarjeta()

function CrearTarjeta(){
    let html =``  
    html += `<center><div class="card" style="width: 18rem; background-color: #f5d056">
    <center><img src="extra/1.png" style="width: 64px; height: 64px" class="card-img-top" alt="..."></center>
    <div class="card-body">
      <h5 class="card-title">${result[0][1]}</h5>
      <p class="card-text">Id: ${result[0][0]}</p>
    </div>
    <ul class="list-group list-group-flush">
      <li class="list-group-item">Se ha vendido: ${result[0][2]} veces</li>
    </ul>
   
  </div></center>`

  html += `<center><div class="card" style="width: 18rem; background-color: #f5d056">
    <center><img src="extra/2.png" style="width: 64px; height: 64px" class="card-img-top" alt="..."></center>
    <div class="card-body">
      <h5 class="card-title">${result[1][1]}</h5>
      <p class="card-text">Id: ${result[1][0]}</p>
    </div>
    <ul class="list-group list-group-flush">
      <li class="list-group-item">Se ha vendido: ${result[1][2]} veces</li>
    </ul>
   
  </div></center>`

  html += `<center><div class="card" style="width: 18rem; background-color: #f5d056">
    <center><img src="extra/3.png" style="width: 64px; height: 64px" class="card-img-top" alt="..."></center>
    <div class="card-body">
      <h5 class="card-title">${result[2][1]}</h5>
      <p class="card-text">Id: ${result[2][0]}</p>
    </div>
    <ul class="list-group list-group-flush">
      <li class="list-group-item">Se ha vendido: ${result[2][2]} veces</li>
    </ul>
   
  </div></center>`

  html += `<center><div class="card" style="width: 18rem; background-color: #f5d056">
    <center><img src="extra/4.png" style="width: 64px; height: 64px" class="card-img-top" alt="..."></center>
    <div class="card-body">
      <h5 class="card-title">${result[3][1]}</h5>
      <p class="card-text">Id: ${result[3][0]}</p>
    </div>
    <ul class="list-group list-group-flush">
      <li class="list-group-item">Se ha vendido: ${result[3][2]} veces</li>
    </ul>
   
  </div></center>`

  html += `<center><div class="card" style="width: 18rem; background-color: #f5d056">
    <center><img src="extra/5.png" style="width: 64px; height: 64px" class="card-img-top" alt="..."></center>
    <div class="card-body">
      <h5 class="card-title">${result[4][1]}</h5>
      <p class="card-text">Id: ${result[4][0]}</p>
    </div>
    <ul class="list-group list-group-flush">
      <li class="list-group-item">Se ha vendido: ${result[4][2]} veces</li>
    </ul>
   
  </div></center>`

  

divTop.innerHTML = html
return html;
}

function ContarCant(){
    for(let i = 0; i<pr.length; i++){
        TopProducto[i]= new Array(3)
        TopProducto[i][0]=pr[i].id
        TopProducto[i][1]=pr[i].name
        TopProducto[i][2]=0
        var c=0
        for(let j = 0; j < ls.length; j++){
            for(let k=0; k<ls[j]["products"].length;k++){
                if(pr[i].name==ls[j]["products"][k].name){
                    c++
                    
                }
            }
        }
        TopProducto[i][2]=c
        console.log(i+" "+TopProducto[i][0] +" "+ TopProducto[i][1]+" "+ TopProducto[i][2])
    }

    
}

function BubbleSort(arr){

    const l = arr.length;
    for (let i = 0; i < l; i++ ) {
      for (let j = 0; j < l - 1 - i; j++ ) {
        if ( arr[ j ][2] < arr[ j + 1 ][2] ) {
          [ arr[ j ], arr[ j + 1 ]] = [ arr[ j + 1 ], arr[ j ] ];
        }
      }
    }
  
    return arr;
     
}

function Mostrar(){
    for(let i = 0; i<result.length; i++){
        console.log(i +" "+ result[i])
    }
    
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