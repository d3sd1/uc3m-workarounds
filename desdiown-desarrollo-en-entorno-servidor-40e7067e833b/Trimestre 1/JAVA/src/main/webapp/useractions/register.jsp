<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="utils.Constants" %>
<!DOCTYPE html>
<html>
    <head>
        <title>CRUD - Registro</title>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    </head>

    <body>
        <header>
            <nav>
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo">DAW</a>
                    <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="useractions">Conexión</a></li>
                        <li><a href="#register_form">Registro</a></li>
                    </ul>
                </div>
            </nav>
        </header>
        <div class="parallax-container">
            <div class="parallax"><img src="http://ak4.picdn.net/shutterstock/videos/6165014/thumb/1.jpg"></div>
        </div>
        <div class="container" style="margin-top: 2em">
            <div class="row">
                <form class="col s12 scrollspy" id="register_form">
                    <div class="center-align">
                        <h1>Formulario de registro</h1>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">account_circle</i>
                            <input id="icon_prefix" type="text" name="name" class="validate">
                            <label for="icon_prefix" class="">Nombre y apellidos</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <i class="material-icons prefix">email</i>
                            <input id="icon_prefix" type="email" name="email" class="validate">
                            <label for="icon_prefix" class="">Email</label>
                        </div>
                        <div class="input-field col s6">
                            <i class="material-icons prefix">lock_outline</i>
                            <input id="icon_prefix" type="password" name="pass" class="validate">
                            <label for="icon_prefix" class="">Contraseña</label>
                        </div>
                    </div>
                    <div class="center-align">
                        <a class="waves-effect waves-light btn" id="registerTrigger"><i class="material-icons right">arrow_forward</i>Finalizar registro</a>
                    </div>
                </form>
            </div>
        </div>
        <footer class="page-footer">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">CRUD Alumnos, asignaturas y notas</h5>
                        <p class="grey-text text-lighten-4">Creado para el IES Tierno Galván, Madrid.</p>
                    </div>
                </div>
            </div>
            <div class="footer-copyright">
                <div class="container">
                    © 2017 Andrei García Cuadra
                </div>
            </div>
        </footer>

        
        <!-- MODAL LOADING -->
        <div id="loading" class="modal">
            <div class="modal-content center-align">
                <h4>Registrando...</h4>
                <p>
                    <div class="progress">
                        <div class="indeterminate"></div>
                    </div>
                </p>
            </div>
        </div>

        <!-- MODALS -->
        <div id="verifyAccount" class="modal">
            <div class="modal-content">
                <h4>Verificación necesaria</h4>
                <p>Introduce el código de verificación que recibiste en el correo electrónico.</p>
                <form>
                    <div class="row">
                            <div class="row">
                                <div class="input-field col s12">
                                    <i class="material-icons prefix">spellcheck</i>
                                    <input type="text" name="activationCode">
                                    <label>Código</label>
                                </div>
                            </div>
                        </form>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Cancelar</a>
                <a href="#!" onclick="checkActivationCode()" class="waves-effect waves-green btn-flat ">Confirmar</a>
            </div>
        </div>
        
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
        <script src="js/register.js"></script>
</html>