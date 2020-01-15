var audio = new Audio('assets/audio/message.mp3'),
    aesUtil = new AesUtil(128, 1000);
function msgToChat(msg)
{
    var details = msg.mensaje.split(":"),
        iv = details[0],
        salt = details[1],
        msgDecrypt = aesUtil.decrypt(salt, iv,actualChannelPass, details[2]);
    audio.play();
    var fechaEnvio = new Date(msg.date_sent),
            actualMsgTimestamp = msg.date_sent,
            msgString = "<li data-timestamp='" + actualMsgTimestamp + "' data-id='" + msg.id + "'><small><span id='msg-date-" + msg.id + "'>" + fechaEnvio.toLocaleString() + "</span> <b>" + msg.sender.email + "</b></small>" + msgDecrypt + "</li>";
    if ($("#chatBox li").length === 0)
    {
        $("#chatBox").append(msgString);
    }
    else
    {
        $("#chatBox li").each(function (index) {
            var $msgTimestamp = $(this).attr("data-timestamp"),
                    $nextMsg = $("#chatBox li").eq(index + 1),
                    $nextMsgTimestamp = $nextMsg.attr("data-timestamp"),
                    $prevMsg = $("#chatBox li").eq(index - 1),
                    $prevMsgTimestamp = $prevMsg.attr("data-timestamp");
            if (actualMsgTimestamp > $msgTimestamp && actualMsgTimestamp < $nextMsgTimestamp) //es posterior al actual
            {
                $(this).after(msgString);
            }
            else if (actualMsgTimestamp < $msgTimestamp && actualMsgTimestamp < $prevMsgTimestamp) //es anterior al actual
            {
                $(this).before(msgString);
            }
            else if ($prevMsg.length === 0)
            {
                $("#chatBox").prepend(msgString);
            }
            else if ($nextMsg.length === 0)
            {
                $("#chatBox").append(msgString);
            }

            /* Eliminar mensajes duplicados */
            var foundIds = {};
            $("#chatBox li").each(function () {
                var id = $(this).attr("data-id");
                if (foundIds[id])
                    $(this).remove();
                else
                    foundIds[id] = true;
            });
        });
    }
    realTimestampMessage(msg.id);
    $("#chatBox").scrollTop($("#chatBox")[0].scrollHeight - $("#chatBox").height());
    Materialize.updateTextFields();
}

function writeMessage(msg, save, propagate = false, type = null) {
    if (msg !== null && msg !== "")
    {
        var iv = CryptoJS.lib.WordArray.random(128 / 8).toString(CryptoJS.enc.Hex),
            salt = CryptoJS.lib.WordArray.random(128 / 8).toString(CryptoJS.enc.Hex),
            msgCrypt = iv + ":" + salt + ":" + aesUtil.encrypt(salt, iv,actualChannelPass, msg);
        var data = new Data("message", new Message(user, save, msgCrypt, propagate, type));
        websocket.send(JSON.stringify(data));
    }
    else
    {
        Materialize.toast('<span>Debes escribir un mensaje.</span>', 2000, 'rounded');
    }
}

function timeSinceDate(date) {
    var seconds = Math.floor((new Date() - date) / 1000);
    var interval = Math.floor(seconds / 31536000);

    if (interval >= 1) {
        return "Hace " + interval + " años";
    }
    interval = Math.floor(seconds / 2592000);
    if (interval >= 1) {
        return "Hace " + interval + " meses";
    }
    interval = Math.floor(seconds / 86400);
    if (interval >= 1) {
        return "Hace " + interval + " días";
    }
    interval = Math.floor(seconds / 3600);
    if (interval >= 1) {
        return "Hace " + interval + " horas";
    }
    interval = Math.floor(seconds / 60);
    if (interval >= 1) {
        return "Hace " + interval + " minutos";
    }
    return "Hace " + Math.floor(seconds) + " segundos";
}

function realTimestampMessage(msgid)
{
    function changeValue() {
        var date = new Date($("#msg-date-" + msgid).parent().parent().attr("data-timestamp"));
        $("#msg-date-" + msgid).text(timeSinceDate(date));
    }
    setInterval(changeValue, 1000);
    changeValue();
}

function filterDates()
{
    $("#chatBox").html("");
    var data = new Data("filter_dates", new FilterDates($("#fecha_inicial").val(), $("#fecha_final").val()));
    websocket.send(JSON.stringify(data));
}