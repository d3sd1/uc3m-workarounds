function addUser()
{
    var userName = prompt("Introduce el nombre del usuario"),
            userPass = prompt("Introduce la contraseña del usuario");
    window.location = "funcionalidad?op=adduser&name=" + userName + "&password=" + userPass;
}
function updUser()
{
    var userName = prompt("Introduce el nombre del usuario"),
            userPass = prompt("Introduce la nueva contraseña del usuario");
    window.location = "funcionalidad?op=upduser&name=" + userName + "&password=" + userPass;
}
function delUser()
{
    var userName = prompt("Introduce el nombre del usuario");
    window.location = "funcionalidad?op=deluser&name=" + userName;
}
function fDelUser()
{
    var userName = prompt("Introduce el nombre del usuario");
    window.location = "funcionalidad?op=fdeluser&name=" + userName;
}
function irAUsuario()
{
    var userName = prompt("Introduce el nombre del usuario"),
            userPass = prompt("Introduce la contraseña del usuario");
    window.location = "usuario?name=" + userName + "&password=" + userPass;
}