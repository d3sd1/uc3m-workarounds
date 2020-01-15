var websocket;
/* Objeto mensaje */
function Mensaje(mensaje,user)
{
    this.fecha = new Date();
    this.mensaje = mensaje;
    this.user = user;
}
function User(name,password)
{
    this.name = name;
    this.password = password;
}
/* Funciones para WS */
function sendMsg(msg)
{
    var mensaje = new Mensaje(msg,user);
    websocket.send(JSON.stringify(mensaje));
}

wsConnect();
function wsConnect()
{
    websocket = new WebSocket("ws://localhost:8000/logs", []);
    websocket.onopen = function (evt) {
        onOpen(evt);
    };
    websocket.onclose = function (evt) {
        onClose(evt);
    };
    websocket.onmessage = function (evt) {
        onMessage(evt);
    };
    websocket.onerror = function (evt) {
        onError(evt);
    };
}
function wsDisconnect()
{
    if(typeof websocket !== "undefined")
    {
        websocket.close();
    }
}

function onOpen(evt)
{
    console.log("WS OPENNED!");
}
function onClose(evt)
{
    console.log("WS CLOSED!");
}
function onMessage(evt) {
    try
    {
        var mensaje = JSON.parse(evt.data);
        $("#mensajes").append((new Date(mensaje.fecha)).toLocaleString() + " / " + mensaje.user.name + " - " + mensaje.mensaje + "</br>");

    }
    catch (e)
    {
        console.error(e);
    }
}

function onError(evt) {
    console.error(evt);
}