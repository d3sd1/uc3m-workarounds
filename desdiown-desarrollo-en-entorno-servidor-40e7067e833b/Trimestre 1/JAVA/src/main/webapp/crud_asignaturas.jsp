<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="utils.Constants" %>
<!DOCTYPE html>
<html>
    <head>
        <title>CRUD Asignaturas</title>
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
                        <li><a href="alumnos">Alumnos</a></li>
                        <li><a href="#asignaturas">Asignaturas</a></li>
                        <li><a href="notas">Notas</a></li>
                        <li><a href="logout">Desconectar</a></li>
                    </ul>
                </div>
            </nav>
        </header>
        <div class="parallax-container">
            <div class="parallax"><img src="http://conceptodefinicion.de/wp-content/uploads/2016/04/Asignaturas.jpg"></div>
        </div>
        <div class="container" style="margin-top: 2em">
            <div class="row">
                <div class="col s12">
                    <a class="waves-effect waves-light btn right" onclick="manageasg_OpenModal(-1)"><i class="material-icons right">person_add</i>Agregar asignatura</a>
                </div>
                <div class="col s12" id="actual_page">

                    <table class="responsive-table centered highlight bordered scrollspy initdatatable" id="asignaturas">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Curso</th>
                                <th>Ciclo</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody>
                        <c:if test = "${asignaturas != null}">
                            <c:forEach items="${asignaturas}" var="asignatura">
                                <tr id="asg-<c:out value="${asignatura.id}"/>">
                                    <td><c:out value="${asignatura.id}"/></td>
                                    <td><c:out value="${asignatura.nombre}"/></td>
                                    <td><c:out value="${asignatura.curso}"/></td>
                                    <td><c:out value="${asignatura.ciclo}"/></td>
                                    <td>
                                        <a class='dropdown-button btn' href='#' data-activates='dropdown-asg-<c:out value="${asignatura.id}"/>'>Acciones</a>

                                        <!-- Dropdown Structure -->
                                        <ul id='dropdown-asg-<c:out value="${asignatura.id}"/>' class='dropdown-content'>
                                            <li><a href="#" onclick="delasgConfirm_OpenModal(<c:out value="${asignatura.id}"/>)">Eliminar</a></li>
                                            <li><a href="#" onclick="manageasg_OpenModal(<c:out value="${asignatura.id}"/>)">Editar</a></li>
                                        </ul>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>
                </div>
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
        <!-- Shortcut menu -->
        <div class="fixed-action-btn horizontal click-to-toggle">
            <a class="btn-floating btn-large red">
                <i class="material-icons">menu</i>
            </a>
            <ul>
                <li><a class="btn-floating red" onclick="manageasg_OpenModal(-1)"><i class="material-icons">person_add</i></a></li>
                <li><a class="btn-floating yellow darken-1" href="notas"><i class="material-icons">library_books</i></a></li>
            </ul>
        </div>

        <!-- MODALS -->
        <div id="manageasg" class="modal">
            <div class="modal-content">
                <form>
                    <div class="row">
                        <form class="col s12">
                            <div class="row" id="editasg">
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">assignment_ind</i>
                                    <input type="number" readonly="readonly" name="id">
                                    <label>ID</label>
                                </div>
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">account_circle</i>
                                    <input id="input_text" type="text" class="validate" data-length="250" required name="name" autocomplete="off">
                                    <label for="input_text" data-error="wrong" data-success="right">Nombre</label>
                                </div>
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">access_time</i>
                                    <input id="input_text" type="text" class="validate" data-length="250" required name="course" autocomplete="off">
                                    <label for="input_text" data-error="wrong" data-success="right">Curso</label>
                                </div>
                                <div class="input-field col s6">
                                    <i class="material-icons prefix">ac_unit</i>
                                    <input id="input_text" type="text" class="validate" data-length="250" required name="cicle" autocomplete="off">
                                    <label for="input_text" data-error="wrong" data-success="right">Ciclo</label>
                                </div>
                            </div>
                        </form>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <a href="#!" onclick="manageasg_CloseModal()" class="waves-effect waves-green btn-flat">Cancelar</a>
                <a href="#!" onclick="manageasg_CheckAction()" class="waves-effect waves-green btn-flat ">Confirmar</a>
            </div>
        </div>

        <div id="delConfirm" class="modal">
            <div class="modal-content">
                <h4>Solicitud de confirmación</h4>
                <p>¿Estás segur@ de que deseas eliminar la asignatura? Esta acción no se puede revertir.</p>
            </div>
            <div class="modal-footer">
                <a href="#!" onclick="delasgConfirm_CloseModal()" class="waves-effect waves-green btn-flat">Cancelar</a>
                <a href="#!" onclick="delasgConfirm_RemoveUser()" class="waves-effect waves-green btn-flat ">Eliminar asignatura</a>
            </div>
        </div>
        <div id="delConfirmWithNotes" class="modal">
            <div class="modal-content">
                <h4>Solicitud de confirmación</h4>
                <p>Se ha producido un error al eliminar, la asignatura tiene notas.... ¿Estás segur@ de que deseas eliminar la asignatura y sus notas?</p>
            </div>
            <div class="modal-footer">
                <a href="#!" onclick="delAsgWithNotesConfirm_CloseModal()" class="waves-effect waves-green btn-flat">Cancelar</a>
                <a href="#!" onclick="delAsgWithNotesConfirm_RemoveUser()" class="waves-effect waves-green btn-flat ">Eliminar asignatura</a>
            </div>
        </div>
        <!--Import jQuery before materialize.js-->
        <script>
            var AJAX_UPDATE_PARAM = "<%= Constants.PARAMETER_VALUE_ACTION_UPDATE %>",
            AJAX_ADD_PARAM = "<%= Constants.PARAMETER_VALUE_ACTION_ADD %>",
            AJAX_FORCE_DELETE_PARAM = "<%= Constants.PARAMETER_VALUE_ACTION_FORCEDELETE %>",
            AJAX_DELETE_PARAM = "<%= Constants.PARAMETER_VALUE_ACTION_DELETE %>";
        </script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>
        <script src="js/constants.js"></script>
        <script src="js/init.js"></script>
        <script src="js/utils.js"></script>
        <script src="js/asigs_modal_manage.js"></script>
        <script src="js/asigs_modal_delete.js"></script>
</html>