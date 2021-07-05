const divtodosLosClientes = document.getElementById('todosLosClientes')
const divEncabezado = document.getElementById('encabezado')


    
Encabezado();
var ls = JSON.parse(localStorage.getItem('clients'));
CrearTabla(ls)








function CrearTabla(clientes){
    let html =``  
    html += `<table class="table table-success table-striped">

    <thead>
        <tr><th>Id</th><th>Name</th><th>Address</th><th>Phone</th><th>Nit</th><th></th></tr>
    </thead>`

for (let index = 0; index < clientes.length; index++) {
    html +=`
    <tbody>
        <tr><th>${clientes[index].id}</th><td>${clientes[index].name}</td><td>${clientes[index].address}</td></td><td>${clientes[index].phone}</td></td><td>${clientes[index].nit}</td><td><button id="ver" style="border-radius: 25px; height: 20px"><a href="Index.html"  class="nav-link text-dark">&nbsp Ver &nbsp</a></button></td></tr>`
}
html +=` </tbody>
</table>`
divtodosLosClientes.innerHTML = html
return html;

}


function Encabezado (){
    var ls = JSON.parse(localStorage.getItem('config'));
    let html =``  
    html += ` ${ls.name} - ${ls.address} - ${ls.phone}`
divEncabezado.innerHTML = html
return html;
}
