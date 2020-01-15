var user, websocket;

function wsConnect()
{
    if (user.type == "google")
    {
        websocket = new WebSocket("ws://localhost:8000/chat/" + user.type + "/" + user.email + "/" + user.token, []);
    }
    else
    {
        websocket = new WebSocket("ws://localhost:8000/chat/" + user.type + "/" + user.email + "/" + user.pass, []);
    }
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

function onOpen(evt)
{
    changeChannel();
}
function onClose(evt)
{
    
}
function onMessage(evt) {
    /* Aquí se recibe un objeto Data, que en función del tipo, se hace una acción u otra */
    try
    {
        var data = JSON.parse(evt.data),
                dataObj = JSON.parse(data.data);
        switch (data.type)
        {
            case "message":
                msgToChat(dataObj);
                break;
            case "user":
                userToList(dataObj);
                break;
            case "channel":
                updateChannels(dataObj);
                break;
            case "login":
                reloadUi(dataObj);
                break;
            case "permissions_request":
                if (dataObj.adminOnline)
                {
                    askChannelPermissions(dataObj);
                }
                else
                {
                    Materialize.toast('<span>El administrador del canal ' + dataObj.channel.id + ' está desconectado.</span>', 2000, 'rounded');
                }
                break;
            case "permissions_response":
                resolveChannelPermissions(dataObj);
                break;
        }

    }
    catch (e)
    {
        console.error(e);
    }
}

function onError(evt) {
    $("#chatBox").text("> ERROR: " + evt.data);
}
$("#logoutTrigger").click(function () {
    websocket.close();
    reloadUi({status: false});
});