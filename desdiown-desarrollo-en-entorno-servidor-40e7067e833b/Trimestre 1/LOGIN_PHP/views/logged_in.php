<!DOCTYPE html>
<html>
    <head>
        <title>LOGIN_PHP - Conectado</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Estás conectado: <?php echo @$_SESSION[Utils\Constants::SESS_LOGIN] ?></h1>
        <div><a href="?action=logout">Pulsa aquí para desconectarte</a></div>
    </body>
</html>
