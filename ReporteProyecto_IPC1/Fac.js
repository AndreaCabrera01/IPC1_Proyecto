const divtodasLasFacturas = document.getElementById('todasLasFacturas')
const divEncabezado = document.getElementById('encabezado')


    
Encabezado();
var ls = JSON.parse(localStorage.getItem('facturas'));
CrearTabla(ls)








function CrearTabla(facturas){
    let html =``  
    html += `<table class="table table-success table-striped">

    <thead>
        <tr><th>Id</th><th>Client</th><th>Date</th><th>Total</th><th></th><th></th></tr>
    </thead>`

for (let index = 0; index < facturas.length; index++) {
    html +=`
    <tbody>
        <tr><th>${facturas[index].id}</th><td>${facturas[index].client}</td><td>${facturas[index].date}</td><td><button id="ver" style="border-radius: 25px; height: 20px"><a href="Index.html"  class="nav-link text-dark">&nbsp Ver &nbsp</a></button></td></tr>`
}
html +=` </tbody>
</table>`
divtodasLasFacturas.innerHTML = html
return html;

}


function Encabezado (){
    var ls = JSON.parse(localStorage.getItem('config'));
    let html =``  
    html += ` ${ls.name} - ${ls.address} - ${ls.phone}`
divEncabezado.innerHTML = html
return html;
}
