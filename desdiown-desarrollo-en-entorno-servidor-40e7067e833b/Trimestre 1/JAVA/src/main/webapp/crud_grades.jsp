<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="utils.Constants" %>
<!DOCTYPE html>
<html>
    <head>
        <title>CRUD Notas</title>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <style>
            .fixDate {
                height: 75% !important
            }
        </style>
            
    </head>

    <body>
        <header>
            <nav>
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo">DAW</a>
                    <ul id="nav-mobile" class="right hide-on-med-and-down">
                        <li><a href="alumnos">Alumnos</a></li>
                        <li><a href="asignaturas">Asignaturas</a></li>
                        <li><a href="#grades">Notas</a></li>
                        <li><a href="logout">Desconectar</a></li>
                    </ul>
                </div>
            </nav>
        </header>
        <div class="parallax-container">
            <div class="parallax"><img src="https://tap350.files.wordpress.com/2012/07/nota-presentacion-examen.png"></div>
        </div>
        <div class="container" style="margin-top: 2em">
            <div class="row">
                <div class="col s12" id="actual_page">

                    <table class="responsive-table centered highlight bordered scrollspy initdatatable" id="grades">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Fecha de nacimiento</th>
                                <th>Mayor de edad</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody>
                        <c:if test = "${alumnos != null}">
                            <c:forEach items="${alumnos}" var="alumno">
                                <tr id="usr-<c:out value="${alumno.id}"/>">
                                    <td><c:out value="${alumno.id}"/></td>
                                    <td><c:out value="${alumno.nombre}"/></td>
                                    <td><fmt:formatDate value="${alumno.fecha_nacimiento}" pattern="dd-MM-yyyy"/></td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${alumno.mayor_edad}">
                                                Mayor de edad.
                                            </c:when>    
                                            <c:otherwise>
                                                Menor de edad.
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <a class='dropdown-button btn' href='#' data-activates='dropdown-user-<c:out value="${alumno.id}"/>'>Seleccionar asignatura</a>

                                        <!-- Dropdown Structure -->
                                        <ul id='dropdown-user-<c:out value="${alumno.id}"/>' class='dropdown-content'>
                                            <c:if test = "${asignaturas != null}">
                                                <c:forEach items="${asignaturas}" var="asignatura">
                                                    <li><a href="#" onclick="manageGrade_OpenModal(<c:out value="${alumno.id}"/>,<c:out value="${asignatura.id}"/>)"><c:out value="${asignatura.nombre}"/></a></li>
                                                </c:forEach>
                                            </c:if>
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

        <!-- MODALS -->
        <div id="gradeManager" class="modal">
            <div class="modal-content">
                <form>
                    <div class="row">
                        <form class="col s12">
                            <div class="row" id="editUsr">
                                <div class="input-field col s12">
                                    <i class="material-icons prefix">spellcheck</i>
                                    <input type="number" min="0" max="10" name="grade">
                                    <label>Puntuación</label>
                                </div>
                            </div>
                        </form>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <a href="#!" onclick="manageGrade_CloseModal()" class="waves-effect waves-green btn-flat">Cancelar</a>
                <a href="#!" onclick="manageGrade_Update()" class="waves-effect waves-green btn-flat ">Confirmar</a>
            </div>
        </div>
        
        <!--Import jQuery before materialize.js-->
        <script>
            var AJAX_UPDATE_PARAM = "<%= Constants.PARAMETER_VALUE_ACTION_UPDATE %>",
            AJAX_ADD_PARAM = "<%= Constants.PARAMETER_VALUE_ACTION_ADD %>",
            AJAX_CHECK_PARAM = "<%= Constants.PARAMETER_VALUE_ACTION_CHECK %>",
            AJAX_DELETE_PARAM = "<%= Constants.PARAMETER_VALUE_ACTION_DELETE %>";
        </script>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>
        <script src="js/constants.js"></script>
        <script src="js/init.js"></script>
        <script src="js/utils.js"></script>
        <script src="js/grades_modal_manage.js"></script>
</html>