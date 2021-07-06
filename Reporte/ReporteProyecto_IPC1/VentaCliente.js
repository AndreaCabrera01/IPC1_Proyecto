var cl = JSON.parse(localStorage.getItem('clients'));
var ls = JSON.parse(localStorage.getItem('facturas'));
var pr = JSON.parse(localStorage.getItem('products'));
const divVentaClientes = document.getElementById('VentaClientes')
let GastoCliente = new Array()
sumarFacturas()
result = BubbleSort(GastoCliente)
Mostrar()
CrearTabla(result)


function CrearTabla(result){
    let html =``  
    html += `<table class="table table-success table-striped">

    <thead>
        <tr><th>Id</th><th>Nombre</th><th>Monto Comprado</th><th></th></tr>
    </thead>`
    for(let i = 0; i < result.length; i++){
        for(let j = 0; j < cl.length; j++){
            if(result[i][0]==cl[j].id){
                var nombre= cl[j].name
            }
        }
        if(result[i][1]!=0){
        html +=`
        <tbody>
        <tr><th>${result[i][0]}</th><td>${nombre}</td><td>${result[i][1]}</td><td><button id="ver" type="button" onclick="verInfo(this.value)" value = ${result[i][0]} style="border: 0; background-color:rgba(255,255,255,0.4); border-radius: 25px; height: 36px">&nbsp Ver &nbsp</button></td></tr>`
        }
    }


    
html +=` </tbody>
</table>`
divVentaClientes.innerHTML = html
return html;

}

function sumarFacturas(){
    
    for(let i = 0; i < cl.length; i++){
        GastoCliente[i]= new Array(2)
        GastoCliente[i][0]=cl[i].id
        GastoCliente[i][1]=0
        for(let j = 0; j < ls.length; j++){
            if(cl[i].id==ls[j].client){
                
                GastoCliente[i][1] += precioTotal(j)
            }
        }
        console.log(i+" "+GastoCliente[i][0] +" "+ GastoCliente[i][1])
    }
    
    
    
}


function precioTotal(index){
        
    var total = 0
    for(let j=0;j<ls[index]["products"].length;j++){
        var cont=0
        for(let i=0;i<pr.length;i++){
            if(pr[i].name == ls[index]["products"][j].name){
              cont ++;
  
                var pre1 = pr[i].price
                total += pre1
            } 
        }
        if (cont==0){
            var pre = ls[index]["products"][j].price;
            total += pre
          }
    }
    
return total
}

function BubbleSort(arr){
    
        const l = arr.length;
        for (let i = 0; i < l; i++ ) {
          for (let j = 0; j < l - 1 - i; j++ ) {
            if ( arr[ j ][1] < arr[ j + 1 ][1] ) {
              [ arr[ j ], arr[ j + 1 ]] = [ arr[ j + 1 ], arr[ j ] ];
            }
          }
        }
      
        return arr;
         
}

//var result = new Array()

function Mostrar(){
    for(let i = 0; i<result.length; i++){
        console.log(i +" "+ result[i])
    }
    
}

function verInfo(id){
    for (let index = 0; index < cl.length; index++) {
        if(cl[index].id==id){
            localStorage.setItem('clientIndividual', JSON.stringify(cl[index]))
        }
        
    }
    window.open('VerClientIndividual.html', '_self');
    var ls2 = JSON.parse(localStorage.getItem('clientIndividual'));
    console.log(ls2)
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