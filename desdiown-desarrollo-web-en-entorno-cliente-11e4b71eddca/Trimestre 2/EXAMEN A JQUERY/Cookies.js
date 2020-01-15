var lati = 0;
var long = 0;
var opc = {
    enableHighAccuracy: true,
    timeout: 10000,
    maximumAge: 30000
};

var texto = "";

$(document).ready(cargar_eventos);

function cargar_eventos(evento) {
    leerDatos();
    control_imagen();
    $("input[name='regalo']").each(function (index, el) {
        $(this).bind('change', control_imagen);
    });
    $("img").bind("click", enviar);
}
function control_imagen() {
    if (contar() > 0) {
        $("img").css({'display': 'block'});
    }
    else {
        $("img").css({'display': 'none'});
    }
}
function contar() {
    var opcion = 0;
    $("input[name='regalo']").each(function (index, el) {
        if ($(this).prop("checked")) {
            opcion += 1;
        }
    });
    return opcion;
}
function enviar() {
    if (contar() == 2) {
        guardarDatos();
        $("#cargando").css({'display': 'block'});
        $("#datos").load("server.php", {}, function () {
            $("#cargando").css({'display': 'none'});
        })
    }
    else {
        $("#cargando").css({'display': 'block'});
        setTimeout(ocultar, 5000);
    }
}
function ocultar() {
    $("#error").css({'display': 'none'});
}
function leerDatos() {
    if (document.cookie.length > 0) {
        var sep1 = new RegExp("; ", "g");
        var sep2 = new RegExp("=", "g");
        var listaCookies = document.cookie.split(sep1);
        for (var i = 0; i < listaCookies.length; i++) {
            var cookie = listaCookies[i].split(sep2);
            if (cookie[0] == "visita") {
                texto = cookie[1];
            }
            if (cookie[0] == "latitud") {
                texto = texto + "<br>" + "Desde la posición: Latitud.- " + cookie[1];
            }
            if (cookie[0] == "longitud") {
                texto = texto + " Longitud.- " + cookie[1];
            }
        }
        $("#ultima_visita").html(texto);
        var opciones = 0;
        if (typeof (Storage) !== "undefined") {
            if (localStorage.getItem("opciones") !== null) {
                var opciones = parseInt(localStorage.getItem("opciones"));
            }
        }
        else {
            alert("Sintiendolo mucho tu navegador no soporta Web Storage");
        }
        $("input[name='regalo']").each(function (index, el) {
            if (opciones >= Math.pow(2, index)) {
                opciones -= Math.pow(2, index);
                $(this).prop("checked", true);
            }
            else {
                $(this).prop("checked", false);
            }
        });
    }
}
function guardarDatos() {
    var meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
            fecha = new Date(),
            cadena = "Fecha última visita: " + fecha.getDate() + " de " + meses[fecha.getMonth()] + " de " + fecha.getFullYear();
    fecha.setTime(fecha.getTime() + 1000 * 60 * 5);
    navigator.geolocation.getCurrentPosition(localizado, no_localizado, opc);
    var opcion = 0;
    $("input[name='regalo']").each(function (index, el) {
        if ($(this).prop("checked"))
        {
            opcion += Math.pow(2, i);
        }
    });
    document.cookie = "visita=" + cadena + ";expires=" + fecha.toUTCString();
    document.cookie = "latitud=" + lati + ";expires=" + fecha.toUTCString();
    document.cookie = "longitud=" + long + ";expires=" + fecha.toUTCString();
    if (typeof (Storage) !== "undefined") {
        localStorage.setItem("opciones", opcion);
    }
    else {
        alert("Sintiendolo mucho tu navegador no soporta Web Storage");
    }
}
function localizado(objeto) {
    alert("Localizado");
    lati = objeto.coords.latitude;
    long = objeto.coords.longitude;
}
function no_localizado() {
    alert("No localizado");
    lati = 0;
    long = 0;
}
