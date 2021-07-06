const divtodasLasFacturas = document.getElementById('todasLasFacturas')
const fecha1 = document.getElementById('inicio')
const fecha2 = document.getElementById('fin')
const ver = document.getElementById('ver')
var pr = JSON.parse(localStorage.getItem('products'));
var cl = JSON.parse(localStorage.getItem('clients'));
var ls = JSON.parse(localStorage.getItem('facturas'));
var FechaOb1 =""
var FechaOb2=""
fecha1.addEventListener('change',obtenerFechaInicio)
fecha2.addEventListener('change',obtenerFechaFin)
ver.addEventListener('click', ActTabla)
//ActTabla()


var ls = JSON.parse(localStorage.getItem('facturas'));
var cl = JSON.parse(localStorage.getItem('clients'));
//CrearTabla(ls)



function obtenerFechaInicio(){
    const fecha=document.getElementById("inicio").value;
    var resFecha = fecha.split("/");
    var reversedFecha = resFecha.reverse(); 
    FechaOb1=reversedFecha.join('/');
   // alert(FechaOb1);

}
function obtenerFechaFin(){
    const fecha=document.getElementById("fin").value;
    var resFecha = fecha.split("/");
    var reversedFecha = resFecha.reverse(); 
    FechaOb2=reversedFecha.join('/');
  //  alert(FechaOb2);

}

function ActTabla(){
    let html =`` 
    html += `<table class="table table-success table-striped">

    <thead>
        <tr><th>Id</th><th>Client</th><th>Date</th><th>Total</th><th></th></tr>
    </thead>`

    var fechaInicio = Date.parse(FechaOb1)
    var fechaFin = Date.parse(FechaOb2)
    for(let i=0; i<ls.length;i++){
        var fechaFac = Date.parse(ls[i].date)
        var nombre =''
        for(let j=0;j<cl.length;j++){
            if(cl[j].id == ls[i].client){
                nombre = cl[j].name
            }
        }
        var total = precioTotal(i)
        

        if(fechaFac >= fechaInicio && fechaFac <= fechaFin){
            html +=`
    <tbody>
    
        <tr><th>${ls[i].id}</th><td>${nombre}</td><td>${ls[i].date}</td><td>${total}</td><td><button id="ver" type="button" onclick="verInfo(this.value)" value = ${i} style="border: 0; background-color:rgba(255,255,255,0.4); border-radius: 25px; height: 36px">&nbsp Ver &nbsp</button></td></tr>`

        }
    }
    html +=` </tbody>
    </table>`
    divtodasLasFacturas.innerHTML = html
    return html;
}





function CrearTabla(facturas){
    let html =``  
    html += `<table class="table table-success table-striped">

    <thead>
        <tr><th>Id</th><th>Client</th><th>Date</th><th>Total</th><th></th></tr>
    </thead>`

for (let index = 0; index < facturas.length; index++) {
    
    var nombre =''
    for(let i=0;i<cl.length;i++){
        if(cl[i].id == facturas[index].client){
            nombre = cl[i].name
        }
    }
    var total = precioTotal(index)
    html +=`
    <tbody>
    
        <tr><th>${facturas[index].id}</th><td>${nombre}</td><td>${facturas[index].date}</td><td>${total}</td><td><button id="ver" type="button" onclick="verInfo(this.value)" value = ${index} style="border: 0; background-color:rgba(255,255,255,0.4); border-radius: 25px; height: 36px">&nbsp Ver &nbsp</button></td></tr>`
}
html +=` </tbody>
</table>`
divtodasLasFacturas.innerHTML = html
return html;

}





function verInfo(id){
    for (let index = 0; index < ls.length; index++) {
        if(index==id){
            localStorage.setItem('facIndividual', JSON.stringify(ls[index]))
        }
        
    }
    window.open('VerFacIndividual.html', '_self');
    var ls2 = JSON.parse(localStorage.getItem('facIndividual'));
    console.log(ls2)
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

const divEncabezado = document.getElementById('encabezado')    
Encabezado();
function Encabezado (){
    var ls = JSON.parse(localStorage.getItem('config'));
    let html =``  
    html += ` ${ls.name} - ${ls.address} - ${ls.phone}`
divEncabezado.innerHTML = html
return html;
}