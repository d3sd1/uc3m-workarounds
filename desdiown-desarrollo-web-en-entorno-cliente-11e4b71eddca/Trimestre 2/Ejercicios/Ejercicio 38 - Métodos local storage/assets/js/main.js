if (typeof (Storage) === "undefined") {
    alert("WebStorage no permitido");
}
function delCookie()
{
    var cokname = prompt("Introduce la cookie a eliminar", "user");
    localStorage.removeItem(cokname);
    if (localStorage.getItem(cokname) == null)
    {
        alert("Eliminada correctamente.");
    } else
    {
        alert("No se pudo eliminar.");
    }
}
function saveCookie()
{
    var cokname = prompt("Introduce el nombre de la cookie", "user"),
            cokval = prompt("Introduce el valor de la cookie", "ANDREI");
    localStorage.setItem(cokname, cokval);
    if(localStorage.getItem(cokname))
    {
        alert("Guardada correctamente.");
    }
    else
    {
        alert("No se pudo guardar.");
    }
}
function getCookie()
{
    var cokname = prompt("Introduce el nombre de la cookie", "user"),
            val = localStorage.getItem(cokname);
    if(val)
    {
        alert("Valor: " + val);
    }
    else
    {
        alert("Variable no encontrada.");
    }
}
function listCookies()
{
    var finalValues = "";
    for (var i in localStorage)
    {
        finalValues += "Nombre de la cookie: " + i + ", valor: " + localStorage[i] + "\n";
    }
    alert(finalValues);
}
function delAllCookies()
{
    var status = localStorage.clear();
    if(status)
    {
        alert("Todas las cookies borradas.");
    }
    else
    {
        alert("No se pudieron borrar todas las cookies.");
    }
}