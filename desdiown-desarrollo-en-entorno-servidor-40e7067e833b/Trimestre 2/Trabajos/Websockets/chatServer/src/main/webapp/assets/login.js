$(document).ready(function () {
    $('.parallax').parallax();
    $('.modal').modal({
        dismissible: false
    });
});
$("#loginTrigger").click(function () {
    var type = "db",
            email = $("#loginForm").find("input[name='email']").val(),
            password = $("#loginForm").find("input[name='pass']").val();
    tryLogin(email, password, null, "db");
});
var googleLogginOn;
$(".g-signin2").click(function () {
    googleLogginOn = true;
});
function tryLogin(email, password, token, type)
{
    Materialize.toast('<span>Cargando conexión...</span>', 1000, 'rounded');
    user = new User(0, email, password, token, type);
    wsConnect();
}
function googleLogin(googleUser) {
    if (googleLogginOn)
    {
        var profile = googleUser.getBasicProfile();
        tryLogin(profile.getEmail(), null, googleUser.getAuthResponse().id_token, "google");
        googleLogginOn = false;
    } else
    {
        gapi.auth2.getAuthInstance().signOut();
    }

}
function reloadUi(userLogin)
{
    if (userLogin.status)
    {
        Materialize.toast('<span>Te has conectado correctamente.</span>', 5000, 'rounded');
        user = userLogin.user;
        $("#formLogin").css("display", "none");
        $("#formChat").css("display", "");
        $(".nav-mobile").css("display", "");
        $("#actualUserDisplay").text(user.email);
        getAllUsers();
        onOpenExtra();
    } 
    else if (user.id == 0 && !userLogin.status)
    {
        Materialize.toast('<span>Error al conectar</span>', 5000, 'rounded');
    }
    else
    {
        Materialize.toast('<span>Te has desconectado.</span>', 5000, 'rounded');
        $("#formLogin").css("display", "");
        $("#formChat").css("display", "none");
        $(".nav-mobile").css("display", "none");
        $("#actualUserDisplay").text("");
    }
}