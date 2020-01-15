function checkRecentLogout(){
    var results = new RegExp('[\?&]logout=([^&#]*)').exec(window.location.href);
    if (results!==null){
       Materialize.toast('<span>Te has desconectado correctamente.</span>', 5000, 'rounded');
    }
}
function checkRecentActivate(){
    var results = new RegExp('[\?&]activated=([^&#]*)').exec(window.location.href);
    if (results!==null){
       Materialize.toast('<span>La solicitud de activación de cuenta se llevo a cabo satisfactoriamente.</span>', 5000, 'rounded');
    }
}
$(document).ready(function () {
    $('.modal').modal({
        dismissible: false
    });
    
    $('.parallax').parallax();
    $('.scrollspy').scrollSpy();
    checkRecentLogout();
    checkRecentActivate();
});
$("#loginTrigger").click(function () {
    $('#loading').modal('open');
    $.ajax({
        url: "useractions",
        type: "POST",
        data: {
            "action": "send",
            "type": "login",
            "email": $("#login_form").find("input[name='email']").val(),
            "pass": $("#login_form").find("input[name='pass']").val()
        },
        error: function (data)
        {
            var info = JSON.parse(data);
            Materialize.toast('<span>Ha ocurrido un error al conectar: ' + info["reason"] + '</span>', 5000, 'rounded');
        },
        success: function (data) {
            var info = JSON.parse(data);
            if (info['success'])
            {
                Materialize.toast('<span>Te has conectado correctamente. Estás siendo redireccionado...</span>', 5000, 'rounded');
                window.setTimeout(function () {
                    window.location.href = "alumnos";
                }, 3000);
            }
            else
            {
                Materialize.toast('<span>Ha ocurrido un error al conectar: ' + info["reason"] + '</span>', 5000, 'rounded');
            }
        },
        complete: function ()
        {
            $('#loading').modal('close');
        }
    });
});
