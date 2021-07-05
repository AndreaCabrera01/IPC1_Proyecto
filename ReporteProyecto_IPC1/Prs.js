const divtodosLosProductos = document.getElementById('todosLosProductos')
const divEncabezado = document.getElementById('encabezado')


    
Encabezado();
var ls = JSON.parse(localStorage.getItem('products'));
CrearTabla(ls)








function CrearTabla(productos){
    let html =``  
    html += `<table class="table table-success table-striped">

    <thead>
        <tr><th>Id</th><th>Name</th><th>Description</th><th>Cost</th><th>Price</th><th></th></tr>
    </thead>`

for (let index = 0; index < productos.length; index++) {
    html +=`
    <tbody>
        <tr><th>${productos[index].id}</th><td>${productos[index].name}</td><td>${productos[index].description}</td><td>${productos[index].cost}</td><td>${productos[index].price}</td><td><button id="ver" style="border-radius: 25px; height: 20px"><a href="Index.html"  class="nav-link text-dark">&nbsp Ver &nbsp</a></button></td></tr>`
}
html +=` </tbody>
</table>`
divtodosLosProductos.innerHTML = html
return html;

}


function Encabezado (){
    var ls = JSON.parse(localStorage.getItem('config'));
    let html =``  
    html += ` ${ls.name} - ${ls.address} - ${ls.phone}`
divEncabezado.innerHTML = html
return html;
}
