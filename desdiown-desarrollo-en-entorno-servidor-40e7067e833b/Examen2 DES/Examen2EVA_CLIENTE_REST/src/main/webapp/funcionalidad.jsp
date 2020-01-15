<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Funcionalidad de usuarios</title>
        <script src="assets/js/funcionalidad.js"></script>
    </head>

    <body>
        <h1>Usuarios</h1>
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Contraseña</th>
                </tr>
            </thead>

            <tbody>
                <c:if test = "${usuarios != null}">
                    <c:forEach items="${usuarios}" var="usuario">
                        <tr>
                            <td><c:out value="${usuario.name}"/></td>
                            <td><c:out value="${usuario.password}"/></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
        <button onclick="addUser()">Añadir usuario</button>
        <button onclick="updUser()">Actualizar usuario</button>
        <button onclick="delUser()">Borrar usuario</button>
        <button onclick="fDelUser()">Forzar borrado usuario</button>
        <button onclick="irAUsuario()">Acciones de usuario (ap. 2)</button>
    </body>
</html>