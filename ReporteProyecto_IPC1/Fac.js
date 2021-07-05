const divtodasLasFacturas = document.getElementById('todasLasFacturas')
const divEncabezado = document.getElementById('encabezado')


    
Encabezado();
var ls = JSON.parse(localStorage.getItem('facturas'));
var cl = JSON.parse(localStorage.getItem('clients'));
CrearTabla(ls)








function CrearTabla(facturas){
    let html =``  
    html += `<table class="table table-success table-striped">

    <thead>
        <tr><th>Id</th><th>Client</th><th>Date</th><th>Total</th><th></th></tr>
    </thead>`

for (let index = 0; index < facturas.length; index++) {
    var total = 0
    var nombre =''
    for(let i=0;i<cl.length;i++){
        if(cl[i].id == facturas[index].client){
            nombre = cl[i].name
        }
    }
    for (let index2 = 0; index2 < facturas[index]["products"].length; index2++) {
        total += facturas[index]["products"][index2].price
    }

    html +=`
    <tbody>
    
        <tr><th>${facturas[index].id}</th><td>${nombre}</td><td>${facturas[index].date}</td><td>${total}</td><td><button id="ver" type="button" onclick="verInfo(this.value)" value = ${index} style="border: 0; background-color:rgba(255,255,255,0.4); border-radius: 25px; height: 36px">&nbsp Ver &nbsp</button></td></tr>`
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