var url = new URL(window.location.href);
var name = url.searchParams.get("name"),
        password = url.searchParams.get("password"),
        user = new User(name,password);
/* Funciones para el rest */
function addCaja()
{
    sendMsg("Añadida caja.");
    var nombreCaja = prompt("Nombre de la caja");
    window.location = "usuario?name=" + name + "&password=" + password + "&op=addcaja&cajanombre=" + nombreCaja;
}
function listarcosas()
{
    sendMsg("Listadas cosas.");
    var nombreCaja = prompt("Nombre de la caja");
    window.location = "usuario?name=" + name + "&password=" + password + "&op=listarcosas&cajanombre=" + nombreCaja;
}
function addcantidad()
{
    sendMsg("Añadida cantidad de cosas.");
    var nombreCaja = prompt("Nombre de la caja"),
            nombreCosa = prompt("Nombre de la cosa"),
            cantidadCosa = prompt("Cantidad de la cosa");
    window.location = "usuario?name=" + name + "&password=" + password + "&op=addcantidad&cajanombre=" + nombreCaja
            + "&cosanombre=" + nombreCosa + "&cosacantidad=" + cantidadCosa;
}
function addCosa()
{
    sendMsg("Añadida cosa.");
    var nombreCaja = prompt("Nombre de la caja"),
            nombreCosa = prompt("Nombre de la cosa"),
            cantidadCosa = prompt("Cantidad de la cosa");
    window.location = "usuario?name=" + name + "&password=" + password + "&op=addcosa&cajanombre=" + nombreCaja
            + "&cosanombre=" + nombreCosa + "&cosacantidad=" + cantidadCosa;
}