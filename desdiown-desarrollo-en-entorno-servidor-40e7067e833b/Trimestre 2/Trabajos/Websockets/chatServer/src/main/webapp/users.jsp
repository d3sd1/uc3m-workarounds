<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
                    <ul class="nav-mobile left">
                        <li><a href="chat" class="modal-trigger">Volver al chat</a></li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="parallax-container valign-wrapper" style="height: 100vh;">
            <div class="parallax"><img alt="Fondo" src="assets/bg1.png"/></div>
            <div class="row center-align" style="width: 50%; z-index: 2">
                <div class="col s12 card-panel blue-grey lighten-5" style="padding: 20px; ">
                    <h2>Usuarios online</h2>
                    <c:if test = "${fn:length(usuariosOnline) > 0}">
                        <ul class="collapsible" data-collapsible="accordion" id="userListOnline">
                            <c:forEach items="${usuariosOnline}" var="user">
                                <li>
                                    <div class="collapsible-header green lighten-3"><i class="material-icons">filter_drama</i><c:out value="${user.getEmail()}"/></div>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:if>

                    <c:if test = "${fn:length(usuariosOnline) == 0}">
                        <h1>Por favor, conéctate primero para poder ver los usuarios.</h1>
                    </c:if>
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
        <script src="assets/models.js"></script>
        <script src="assets/login.js"></script>
        <script src="assets/chat.js"></script>
        <script src="assets/data/users.js"></script>
        <script src="assets/data/channels.js"></script>
        <script src="assets/data/messages.js"></script>
        <script src="assets/websocket.js"></script>
    </body>
</html>
