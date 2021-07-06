const inputJsonConfig = document.getElementById('jsonConfig')
const inputJsonUsers = document.getElementById('jsonUsers')
const inputJsonClients = document.getElementById('jsonClients')
const inputJsonProducts = document.getElementById('jsonProducts')
const inputJsonInvoices = document.getElementById('jsonInvoices')
const divEncabezado = document.getElementById('encabezado')









//Leer JSON

function leerJSON(){
    const fileReader= new FileReader()

    function miOnload(){
        const config = fileReader.result
        const json = JSON.parse(fileReader.result)
        console.log(json)

        localStorage.setItem('config', JSON.stringify(json))
        alert('Se ha cargado el archivo "config"')

    }
    
   fileReader.readAsText(inputJsonConfig.files[0])
   fileReader.onload = miOnload;

/*localStorage.setItem('testObject', JSON.stringify(testObject));
var retrievedObject = localStorage.getItem('testObject');
console.log('retrievedObject: ', JSON.parse(retrievedObject));*/

}
inputJsonConfig.addEventListener('change', leerJSON);




//leer Users
function leerJSONUsers(){
    console.log(inputJsonUsers.files)
    const fileReader= new FileReader()

    function miOnload(){
        const jsonUsers = JSON.parse(fileReader.result)
        console.log(jsonUsers)

        localStorage.setItem('users', JSON.stringify(jsonUsers))
        alert('Se ha cargado el archivo "Users"')

    }

    fileReader.readAsText(inputJsonUsers.files[0])
    fileReader.onload = miOnload;
}
inputJsonUsers.addEventListener('change', leerJSONUsers);



//leer Clientes
function leerJSONClientes(){
    console.log(inputJsonClients.files)
    const fileReader= new FileReader()

    function miOnload(){
        const jsonClients = JSON.parse(fileReader.result)
        console.log(jsonClients)

        localStorage.setItem('clients', JSON.stringify(jsonClients))
        alert('Se ha cargado el archivo "Clients"')

    }

    fileReader.readAsText(inputJsonClients.files[0])
    fileReader.onload = miOnload;
}
inputJsonClients.addEventListener('change', leerJSONClientes);




//leer Productos
function leerJSONProducts(){
    console.log(inputJsonProducts.files)
    const fileReader= new FileReader()

    function miOnload(){
        const jsonProducts = JSON.parse(fileReader.result)
        console.log(jsonProducts)

        localStorage.setItem('products', JSON.stringify(jsonProducts))
        alert('Se ha cargado el archivo "Products"')

    }

    fileReader.readAsText(inputJsonProducts.files[0])
    fileReader.onload = miOnload;
}
inputJsonProducts.addEventListener('change', leerJSONProducts);




//leer facturas
function leerJSONInvoices(){
    console.log(inputJsonInvoices.files)
    const fileReader= new FileReader()

    function miOnload(){
        const jsonFacturas = JSON.parse(fileReader.result)
        console.log(jsonFacturas)

        localStorage.setItem('facturas', JSON.stringify(jsonFacturas))
        alert('Se ha cargado el archivo "Invoices"')

    }

    fileReader.readAsText(inputJsonInvoices.files[0])
    fileReader.onload = miOnload;
}

inputJsonInvoices.addEventListener('change', leerJSONInvoices)


var ls = JSON.parse(localStorage.getItem('config'));
Encabezado();

function Encabezado (){
    let html =``  
    html += ` ${ls.name} - ${ls.address} - ${ls.phone}`
divEncabezado.innerHTML = html
return html;
}







