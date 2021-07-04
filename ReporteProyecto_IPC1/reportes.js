const inputJsonConfig = document.getElementById('jsonConfig')
const inputJsonUsers = document.getElementById('jsonUsers')
const inputJsonClients = document.getElementById('jsonClients')
const inputJsonProducts = document.getElementById('jsonProducts')
const inputJsonInvoices = document.getElementById('jsonInvoices')

//Leer JSON

function leerJSON(){
    const fileReader= new FileReader()

    function miOnload(){
        const json = JSON.parse(fileReader.result)
        console.log(json)
    }
    
   fileReader.readAsText(inputJsonConfig.files[0])
   /* fileReader.readAsText(inputJsonUsers.files[0])
    fileReader.readAsText(inputJsonClients.files[0])
    fileReader.readAsText(inputJsonProducts.files[0])
    fileReader.readAsText(inputJsonInvoices.files[0])*/
    fileReader.onload = miOnload;
}
inputJsonProducts.addEventListener('change', leerJSON);
inputJsonUsers.addEventListener('change', leerJSON);
inputJsonConfig.addEventListener('change', leerJSON);
inputJsonClients.addEventListener('change', leerJSON);

inputJsonInvoices.addEventListener('change', leerJSON);

//leer Users
/*function leerJSONUsers(){
    console.log(inputJsonUsers.files)
    const fileReader= new FileReader()

    function miOnload(){
        const jsonUsers = JSON.parse(fileReader.result)
        console.log(jsonUsers)
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
    }

    fileReader.readAsText(inputJsonClients.files[0])
    fileReader.onload = miOnload;
}
inputJsonConfig.addEventListener('change', leerJSONClientes);

//leer Productos
function leerJSONProducts(){
    console.log(inputJsonProducts.files)
    const fileReader= new FileReader()

    function miOnload(){
        const jsonProducts = JSON.parse(fileReader.result)
        console.log(jsonProducts)
    }

    fileReader.readAsText(inputJsonProducts.files[0])
    fileReader.onload = miOnload;
}
inputJsonUsers.addEventListener('change', leerJSONProducts);

//leer facturas
function leerJSONInvoices(){
    console.log(inputJsonInvoices.files)
    const fileReader= new FileReader()

    function miOnload(){
        const jsonFacturas = JSON.parse(fileReader.result)
        console.log(jsonFacturas)
    }

    fileReader.readAsText(inputJsonInvoices.files[0])
    fileReader.onload = miOnload;
}
inputJsonUsers.addEventListener('change', leerJSONInvoices);*/
