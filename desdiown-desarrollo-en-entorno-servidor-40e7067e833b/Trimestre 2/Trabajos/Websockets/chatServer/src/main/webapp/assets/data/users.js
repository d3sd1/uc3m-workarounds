function getAllUsers()
{
    var data = new Data("all_users", null);
    websocket.send(JSON.stringify(data));
}
function userToList(user)
{
    var userChannelsFormatted = "";
    if (user.subscribedChannels instanceof Array && user.subscribedChannels.length > 0)
    {
        user.subscribedChannels.forEach(function (channel) {
            userChannelsFormatted += "<p>" + channel.name + "</p>";
        });
    }
    else
    {
        userChannelsFormatted = "<p class='red-text text-darken-4'>Sin canales.</p>";
    }
    var userBgColor = user.online ? "green lighten-3" : "red lighten-2",
            userIcon = user.online ? "public" : "power_settings_new",
            userEntry = `<li id="user-status-${user.id}">
                        <div class="collapsible-header ${userBgColor}">
                            <i class="material-icons">arrow_drop_down_circle</i>
                            ${user.email}
                            <span class="badge"><i class="material-icons">${userIcon}</i></span></div>
                        <div class="collapsible-body"><h5>Subscripción a canales</h5>${userChannelsFormatted}</div>
                    </li>`;
    $("#user-status-" + user.id).remove();
    if (user.online)
    {
        $("#userListOnline").append(userEntry);
    } else
    {
        $("#userListOffline").append(userEntry);
    }
}