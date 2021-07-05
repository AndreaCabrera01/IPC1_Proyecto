const divtodosLosUsuarios = document.getElementById('todosLosUsuarios')
const divEncabezado = document.getElementById('encabezado')


    
Encabezado();
var ls = JSON.parse(localStorage.getItem('users'));
CrearTabla(ls)



let bb = document.createElement("button")




function CrearTabla(usuarios){
    let html =``  
    html += `<table class="table table-success table-striped">

    <thead>
        <tr><th>#</th><th>Users</th><th>Pass</th><th></th></tr>
    </thead>`

for (let index = 0; index < usuarios.length; index++) {
    html +=`
    <tbody>
        <tr><th>${index+1}</th><td>${usuarios[index].username}</td><td>${usuarios[index].password}</td><td><button id="ver" style="border: 0; background-color:rgba(255,255,255,0.4); border-radius: 25px; height: 36px"><a href="javascript:finestraSecundaria()" target="_blank" class="nav-link text-dark m-1 p-1">&nbsp Ver &nbsp</a></button></td></tr>`
}
html +=` </tbody>
</table>`
divtodosLosUsuarios.innerHTML = html
return html;

}


function Encabezado (){
    var ls = JSON.parse(localStorage.getItem('config'));
    let html =``  
    html += ` ${ls.name} - ${ls.address} - ${ls.phone}`
divEncabezado.innerHTML = html
return html;
}
function finestraSecundaria (){
    window.open("VerUsuIndividual.html", "Usuario", "width=300, height=200")
    }
