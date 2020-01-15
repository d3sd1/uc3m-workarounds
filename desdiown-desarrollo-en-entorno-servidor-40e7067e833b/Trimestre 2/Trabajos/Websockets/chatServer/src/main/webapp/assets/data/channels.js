var actualChannelPass;
var actualChannelId;
var actualChannels = [];
function addChanel()
{
    var name = $("#createChannelForm").find("input[name='channelName']").val(),
            pass = $("#createChannelForm").find("input[name='channelPass']").val(),
            data = new Data("add_channel", new Channel(0, name, user.id, pass));
    if (name != null && pass != null && name != "" && pass != "")
    {
        websocket.send(JSON.stringify(data));
        $("#createChannelForm input").each(function () {
            $(this).val("");
        });
        $("#addChannelModal").modal("close");
        getChannels();
    }
    else
    {
        Materialize.toast('<span>Debes introducir un nombre y una contraseña</span>', 2000, 'rounded');
    }
}
function getChannels()
{
    var data = new Data("all_channels", null);
    websocket.send(JSON.stringify(data));
}
var currentPermissionsRequest;
function askChannelPermissions(data)
{
    var template = $("#grantChannelPermissions p").attr("data-text-template"),
            text = template.replace("{userName}", data.askingUser.email).replace("{channelName}", data.channel.name);
    $("#grantChannelPermissions p").text(text);
    $("#grantChannelPermissions").modal("open");
    currentPermissionsRequest = data;
    $(".responsePermission").bind("click", function () {
        var permissionGranted = $(this).attr("data-resp"),
                data = new Data("grant_permissions_channel", new ChannelPermissions(currentPermissionsRequest.askingUser, currentPermissionsRequest.adminUser, currentPermissionsRequest.channel, permissionGranted));
        websocket.send(JSON.stringify(data));
        $("#grantChannelPermissions").modal("close");
    });
}

function resolveChannelPermissions(data)
{
    if (data.granted)
    {
        Materialize.toast('<span>Se han aceptado tus permisos para el canal: ' + data.channel.id + '</span>', 2000, 'rounded');
        /* Mover de select el canal a suscripciones */
        var channelOption = '<option value="' + data.channel.id + '">' + data.channel.name + '</option>';
        $("#allChannels").find("option[value='" + data.channel.id + "']").remove();
        $("#myChannels").append(channelOption);
    }
    else
    {
        Materialize.toast('<span>Se han denegado tus permisos para el canal: ' + data.channel.id + '</span>', 2000, 'rounded');
    }
    $('select').material_select();
}

function updateChannels(data)
{
    actualChannels[data.id] = data;
    var optionString = '<option value="' + data.id + '">' + data.name + '</option>';
    if (data.actualUserHasPermissions || data.admin_id === user.id)
    {
        $("#myChannels").append(optionString);
    }
    else
    {
        Materialize.toast('<span>Detectado canal: ' + data.name + '</span>', 2000, 'rounded');
        $("#allChannels").append(optionString);
    }

    /* Prevenir duplicados en las listas */
    var foundIds = {};
    $("#allChannels option").each(function () {
        var id = $(this).val();
        if (foundIds[id] && id != 0)
            $(this).remove();
        else
            foundIds[id] = true;
    });
    $("#myChannels option").each(function () {
        var id = $(this).val();
        if (foundIds[id] && id != 0)
            $(this).remove();
        else
            foundIds[id] = true;
    });
    $('select').material_select();
}
/* Cambiar de canal entre sus suscripciones */
function changeChannel()
{
    if (actualChannelId in actualChannels)
    {
        actualChannelId = $("#myChannels").val();
        actualChannelPass = actualChannels[actualChannelId].password;
    }
    if (actualChannelPass == null || actualChannelPass == "")
    {
        actualChannelPass = "0";
    }
}
$("#myChannels").bind("change", function () {
    changeChannel();
    var data = new Data("change_channel", new Channel($("#myChannels").val(), " ", null, " "));
    websocket.send(JSON.stringify(data));
    $("#chatBox").html("");
    filterDates();
});
/* Pedir permisos para suscribirse */
$("#allChannels").bind("change", function () {
    var newChannelId = $("#allChannels").val(),
            newChannelName = $("#allChannels").find("option[value='" + newChannelId + "']").text(),
            data = new Data("subscribe_channel", new Channel(newChannelId, newChannelName, null, " "));
    if (newChannelId != 0)
    {
        websocket.send(JSON.stringify(data));
        Materialize.toast('<span>Se ha enviado la petición de suscripcion al canal ' + newChannelName + '</span>', 2000, 'rounded');
    }
});