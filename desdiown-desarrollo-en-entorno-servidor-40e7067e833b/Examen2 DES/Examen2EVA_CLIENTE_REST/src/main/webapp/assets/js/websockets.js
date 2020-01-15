var websocket;
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
    console.log("open");
}
function onClose(evt)
{
    
}
function onMessage(evt) {
    /* Aquí se recibe un objeto Data, que en función del tipo, se hace una acción u otra */
    try
    {
        var data = JSON.parse(evt.data),
        date = new Date();
        $("#mensajes").append(date.toLocaleString() + " / " + data.user.name + " - " + data.msg);

    }
    catch (e)
    {
        console.error(e);
    }
}

function onError(evt) {
    console.error(evt);
}