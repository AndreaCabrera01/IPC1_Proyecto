const divtodosLosProductos = document.getElementById('todosLosProductos')
const divEncabezado = document.getElementById('encabezado')




    
Encabezado();
var ls = JSON.parse(localStorage.getItem('products'));
CrearTabla(ls)








function CrearTabla(productos){
    var n = 0
    let html =``  
    html += `<table class="table table-success table-striped">

    <thead>
        <tr><th>Id</th><th>Name</th><th>Description</th><th>Cost</th><th>Price</th><th># Ingredientes</th><th></th></tr>
    </thead>`
    

for (let index = 0; index < productos.length; index++) {
    html +=`
    <tbody>
        <tr><th>${productos[index].id}</th><td>${productos[index].name}</td><td>${productos[index].description}</td><td>${productos[index].cost}</td><td>${productos[index].price}</td><td>${productos[index]["ingredients"].length}</td><td><button id="ver" type="button" onclick="verInfo(this.value)" value = ${index} style="border: 0; background-color:rgba(255,255,255,0.4); border-radius: 25px; height: 36px">&nbsp Ver &nbsp</button></td></tr>`
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

function verInfo(id){
    for (let index = 0; index < ls.length; index++) {
        if(index==id){
            localStorage.setItem('produIndividual', JSON.stringify(ls[index]))
        }
        
    }
    window.open('VerPrsIndividual.html', '_self');
    var ls2 = JSON.parse(localStorage.getItem('produIndividual'));
    console.log(ls2)
}


