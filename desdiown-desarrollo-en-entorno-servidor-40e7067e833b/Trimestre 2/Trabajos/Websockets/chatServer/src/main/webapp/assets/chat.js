$(document).ready(function () {
    $('.parallax').parallax();
    $('.modal').modal({
        dismissible: false
    });
    $('select').material_select();
    var d = new Date();
    
    /* Poner fechas iniciales para que se muestren unos cuantos mensajes al inicio */
    $("#fecha_inicial").val(d.getFullYear() + "-" + ("0" + (d.getMonth()+1)).slice(-2) + "-" + ("0" + (d.getDate()-20)).slice(-2));
    $("#fecha_final").val(d.getFullYear() + "-" + ("0" + (d.getMonth()+1)).slice(-2) + "-" + ("0" + (d.getDate()+1)).slice(-2));
});
$("input[name='message']").bind("keypress",function(e){
    if(e.which === 8) {
        $("input[name='message']").val($("input[name='message']").val().slice(0, -1)); 
    }
    else if(e.which !== 13) {
        $("input[name='message']").val($("input[name='message']").val() + e.key); 
    }
    else
    {
        $("#sendMessage").click();
    }
    e.preventDefault();
    e.stopPropagation();
});
$("#sendMessage").click(function (e) {
    writeMessage($("#userUI").find("input[name='message']").val(), $("#userUI").find("#saveMessages").prop('checked'));
    $("#userUI").find("input[name='message']").val("");
    e.preventDefault();
});
$("#dateFilter").click(function (e) {
    filterDates();
    e.preventDefault();
});
$("#createChannelSend").click(function(e){
    addChanel();
    e.preventDefault();
});
$('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15, // Creates a dropdown of 15 years to control year,
    today: 'Today',
    clear: 'Clear',
    close: 'Ok',
    closeOnSelect: false,
    format: 'yyyy-mm-dd'
});
function onOpenExtra() {
    filterDates();
    getChannels();
}