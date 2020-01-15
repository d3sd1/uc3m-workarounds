<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumnos List</title>
        <style>
            body {text-align: center}
            table {
                margin-left: auto;
                margin-right: auto;
            }
            .container {
                margin: 0 auto;
                text-align: center;
                width: 100%;
            }
            .container a {
                padding-left: 20px;
                font-size: 1.5em;
            }
        </style>
        <link rel="stylesheet" href="assets/vendors/jquery/jquery-ui.css">
        <script src="assets/vendors/jquery/jquery-1.10.2.js"></script>
        <script src="assets/vendors/jquery/jquery-ui.js"></script>

    </head>
    <body>
        <h1><c:out value="${message}"></c:out></h1>
        <h1>Añadir coche</h1>
        <form id="formulario" name="formulario" action = "crud" method="POST">
            <input type="hidden" name="action" value="insert" />
            <input type="hidden" name="idcoche" />
            <input type="text" name="coche" placeholder="Nombre del coche"/>
            <select name="comprado">
                <option value="yes">Si</option>
                <option value="no">No</option>
            </select>
            <input type="date" name="fecha_compra" placeholder="Fecha de compra"/>
            <input type="number" name="km" placeholder="Kilómetros">
            <br>
            <br>
            <button onclick="">Insertar</button>
            <button href="">Actualizar</button>
        </form>
        <table class="table table-striped">
            <tr style="font-weight: bold">
                <td>COCHE</td>
                <td>COMPRADO</td>
                <td>FECHA DE COMPRA</td>
                <td>KILOMETROS</td>
                <td>DESCUENTO</td>
                <td></td>
            </tr>
            <c:forEach items="${cars}" var="car">  
                <tr>
                    <td>${car.coche}</td>
                    <td><c:if test="${car.comprado}" >Sí</c:if> <c:if test="${!car.comprado}" >No</c:if></td>
                    <td><fmt:formatDate value="${car.fecha_compra}" pattern="dd-MM-yyyy"/></td>
                    <td>${car.km}</td>
                    <td>${car.descuento}</td>
                    <td><a onclick="cargarCoche(${car.id},'${car.coche}',${car.comprado},'${car.fecha_compra}',${car.km})" style="blue">Editar</a> <a href="/crud?delete=${car.id}" style="color:red">Eliminar</a></td>
                </tr>
            </c:forEach>                   
        </table>


        <p>Nº Coches: 
            <c:out value="${fn:length(cars)}"/>
        </p>

        <script>
            function cargarCoche(id,coche,comprado,fecha,km)
            {
                $("#formulario").find("input[name='idcoche']").val(id);
                $("#formulario").find("input[name='coche']").val(coche);
                $("#formulario").find("input[name='comprado']").val(comprado);
                $("#formulario").find("input[name='fecha_compra']").val(fecha);
                $("#formulario").find("input[name='km']").val(km);
            }
            function actualizar()
            {
                $("#formulario").find("input[name='action']").val("update");
                document.formulario.submit();
            }
            function insertar()
            {
                $("#formulario").find("input[name='action']").val("insert");
                document.formulario.submit();
            }
        </script>
    </body>
</html>
