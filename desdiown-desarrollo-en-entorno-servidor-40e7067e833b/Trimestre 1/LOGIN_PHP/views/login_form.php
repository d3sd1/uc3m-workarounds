<!DOCTYPE html>
<html>
    <head>
        <title>LOGIN_PHP - Formulario de conexión</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Formulario de conexión</h1>
        <form action="?action=login" method="post">
            Nombre de usuario: <input type="text" name="<?php echo Utils\Constants::PAR_LOGIN_USER ?>"><br>
            Contraseña: <input type="password" name="<?php echo Utils\Constants::PAR_LOGIN_PASSWORD ?>"><br>
            <input type="submit" value="Conectar">
        </form>
    </body>
</html>
