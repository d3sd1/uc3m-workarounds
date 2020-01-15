$(document).ready(function () {
    $('.modal').modal({
        dismissible: false
    });

    $('.parallax').parallax();
    $('.scrollspy').scrollSpy();
});
var email = null;
$("#registerTrigger").click(function () {
    email = $("#register_form").find("input[name='email']").val();
    $('#loading').modal('open');
    $.ajax({
        url: "useractions",
        type: "POST",
        data: {
            "action": "send",
            "type": "register",
            "name": $("#register_form").find("input[name='name']").val(),
            "email": $("#register_form").find("input[name='email']").val(),
            "pass": $("#register_form").find("input[name='pass']").val()
        },
        error: function (data)
        {
            var info = JSON.parse(data);
            Materialize.toast('<span>Ha ocurrido un error al registrar: ' + info["reason"] + '</span>', 5000, 'rounded');
        },
        success: function (data) {
            var info = JSON.parse(data);
            $('#loading').modal('close');
            if (info['success'])
            {
                $('#verifyAccount').modal('open');
            } else
            {
                Materialize.toast('<span>Ha ocurrido un error al registrar: ' + info["reason"] + '</span>', 5000, 'rounded');
            }
        }
    });
});
function checkActivationCode() {
    $('#verifyAccount').modal('close');
    $('#loading').modal('open');
    $.ajax({
        url: "useractions",
        type: "POST",
        data: {
            "action": "send",
            "type": "verify",
            "email": email,
            "code": $("#verifyAccount").find("input[name='activationCode']").val()
        },
        error: function (data)
        {
            var info = JSON.parse(data);
            Materialize.toast('<span>Ha ocurrido un error al verificar la cuenta: ' + info["reason"] + '</span>', 5000, 'rounded');
        },
        success: function (data) {
            var info = JSON.parse(data);
            $('#loading').modal('close');
            if (info['success'])
            {
                Materialize.toast('<span>Registro finalizado correctamente, ya puedes conectarte. Espera unos segundos...</span>', 5000, 'rounded');
                window.setTimeout(function () {
                    window.location.href = "useractions";
                }, 3000);
            }
            else
            {
                Materialize.toast('<span>Ha ocurrido un error al verificar la cuenta: ' + info["reason"] + '</span>', 5000, 'rounded');
            }
        }
    });
}