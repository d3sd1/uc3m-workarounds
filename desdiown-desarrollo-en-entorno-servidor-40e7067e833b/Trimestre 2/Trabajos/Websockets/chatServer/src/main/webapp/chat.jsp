<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Websockets full life</title>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="641900947896-8ah99d90gu20636acqsmjnof06avsb40.apps.googleusercontent.com">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
        <link rel="stylesheet" href="assets/custom.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
    </head>
    <body>
        <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper blue lighten-1">
                    <a href="" class="brand-logo center"><img alt="Logo" src="https://image.ibb.co/fXxOcG/logo.png" style="height: 50px"/></a>
                    <ul class="nav-mobile left" style="display:none">
                        <li><a href="#admin_users" class="modal-trigger">Administración de usuarios (WS)</a></li>
                        <li><a href="users" target="onlineusers" class="modal-trigger">Administración de usuarios (JSP)</a></li>
                        <li><a id="logoutTrigger">Desconectar</a></li>
                    </ul>
                    <ul class="nav-mobile right" style="display:none">
                        <li id="actualUserDisplay"></li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="parallax-container valign-wrapper" style="height: 100vh;">
            <div class="parallax"><img alt="Fondo" src="assets/bg1.png"/></div>

            <!-- LOGIN PARA USUARIOS DESCONECTADOS -->
            <div class="row center-align" style="width: 50%; z-index: 2" id="formLogin">
                <div class="col s12 card-panel blue-grey lighten-5" style="padding: 20px; ">
                    <form id="loginForm">
                        <div class="row">
                            <div class="input-field col s12">
                                <input name="email" type="text" class="validate">
                                <label>Email</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input name="pass" type="password" class="validate">
                                <label>Contraseña</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <div class="g-signin2 col s6" data-onsuccess="googleLogin" data-onerror="googleLoginError"></div>
                                <a class="light-blue accent-2 waves-effect waves-light btn col s6" id="loginTrigger"><i class="material-icons right">arrow_forward</i>Conectar</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- CHAT PARA USUARIOS CONECTADOS -->
            <div id="admin_users" class="modal">
                <div class="modal-content">
                    <h1>Usuarios</h1>
                    <ul class="collapsible" data-collapsible="accordion" id="userListOnline">
                    </ul>
                    <ul class="collapsible" data-collapsible="accordion" id="userListOffline">
                    </ul>
                </div>
                <div class="modal-footer">
                    <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">¡Entendido!</a>
                </div>
            </div>
            <!-- CHAT PARA USUARIOS CONECTADOS -->
            <div class="row center-align" style="width: 50%; z-index: 2; display:none" id="formChat">
                <div class="col s12 card-panel blue-grey lighten-5" style="padding: 20px; ">
                    <form class="col s12" id="userUI">
                        <div class="row">
                            <div class="input-field col s3">
                                <input type="checkbox" id="saveMessages" checked="checked" />
                                <label for="saveMessages" style="pointer-events: auto;">Guardar mensajes en DB</label>
                            </div>
                            <div class="input-field col s3">
                                <select id="allChannels">
                                    <option value="0" selected disabled>Canal principal</option>
                                </select>
                                <label>Todos los canales</label>
                            </div>
                            <div class="input-field col s3">
                                <select id="myChannels">
                                    <option value="0" selected>Canal principal</option>
                                </select>
                                <label>Mis canales</label>
                            </div>
                            <div class="input-field col s3">
                                <button id="addChannel" class="waves-effect waves-light btn modal-trigger" href="#addChannelModal"><i class="material-icons right">add_box</i>Crear canal</button>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s8">
                                <input name="message" type="text" autocomplete="off">
                                <label>Mensaje</label>
                            </div>
                            <div class="input-field col s4">
                                <button id="sendMessage" class="waves-effect waves-light btn"><i class="material-icons right">arrow_forward</i>Enviar</button>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s4">
                                <input type="text" class="datepicker" id="fecha_inicial">
                                <label>Fecha de inicio</label>
                            </div>
                            <div class="input-field col s4">
                                <input type="text" class="datepicker" id="fecha_final">
                                <label>Fecha final</label>
                            </div>
                            <div class="input-field col s4">
                                <button id="dateFilter" class="waves-effect waves-light btn"><i class="material-icons right">sort_by_alpha</i>Filtrar</button>
                            </div>
                        </div>
                    </form>
                    <div class="row">
                        <div class="input-field col s12">
                            <ul id="chatBox"></ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="page-footer cyan accent-4">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">Websockets con oscar</h5>
                        <p class="grey-text text-lighten-4">Realizado por Andrei García Cuadra.</p>
                    </div>
                </div>
            </div>
            <div class="footer-copyright">
                <div class="container">
                    © 2018 Óscar nos jode la primavera
                </div>
            </div>
        </footer>
        <div id="addChannelModal" class="modal">
            <div class="modal-content">
                <div class="row">
                    <form class="col s12" id="createChannelForm">
                        <div class="row">
                            <div class="input-field col s6">
                                <input name="channelName" type="text" class="validate">
                                <label for="channelName">Nombre del canal</label>
                            </div>
                            <div class="input-field col s6">
                                <input name="channelPass" type="password" class="validate">
                                <label for="channelPass">Contraseña del canal</label>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Cancelar</a>
                <a href="#!" id="createChannelSend" class="waves-effect waves-green btn-flat">Crear</a>
            </div>
        </div>
        <div id="grantChannelPermissions" class="modal">
            <div class="modal-content">
                <h4>Petición de permisos</h4>
                <p data-text-template="El usuario {userName} te ha solicitado permisos para el canal {channelName}."></p>
            </div>
            <div class="modal-footer">
                <a href="#!" data-resp="false" class="responsePermission waves-effect waves-green btn-flat">Denegar</a>
                <a href="#!" data-resp="true" class="responsePermission waves-effect waves-green btn-flat">Aceptar</a>
            </div>
        </div>
        <script type="text/javascript" src="assets/crypt/lib/aes.js"></script>
        <script type="text/javascript" src="assets/crypt/lib/pbkdf2.js"></script>
        <script type="text/javascript" src="assets/crypt/AesUtil.js"></script>
        <script src="assets/models.js"></script>
        <script src="assets/login.js"></script>
        <script src="assets/chat.js"></script>
        <script src="assets/data/users.js"></script>
        <script src="assets/data/channels.js"></script>
        <script src="assets/data/messages.js"></script>
        <script src="assets/websocket.js"></script>
    </body>
</html>
