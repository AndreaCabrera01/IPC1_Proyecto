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
        <tr><th>#</th><th>Users</th><th>Pass</th></tr>
    </thead>`

for (let index = 0; index < usuarios.length; index++) {
    html +=`
    <tbody>
        <tr><th>${index+1}</th><td>${usuarios[index].username}</td><td>${usuarios[index].password}</td></tr>`
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

