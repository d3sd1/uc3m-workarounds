<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<a href="/panel">VOLVER AL INICIO</a></br>
<c:if test = "${agregado != null && agregado}">
    Producto agregado correctamente.</br>
</c:if>
<c:if test = "${agregado != null && !agregado}">
    Producto NO agregado.</br>
</c:if>
<c:if test = "${actualizado != null && actualizado}">
    Producto actualizado correctamente.</br>
</c:if>
<c:if test = "${actualizado != null && !actualizado}">
    Producto NO actualizado.</br>
</c:if>
<form id="crud">
    <input type="hidden" name="op" value="add" />
    <input type="text" name="nombre" placeholder="Nombre" />
    <input type="number" name="precio" placeholder="Precio" />
    <input type="number" name="unidades" placeholder="Unidades" />
    <input type="text" name="categoria" placeholder="Categoría" />
    <input type="button" value="Agregar" id="agregar">
    <input type="button" value="Actualizar" id="actualizar">
</form>
<script>
    document.getElementById("agregar").addEventListener("click",function() {cambiarOp("add")});
    document.getElementById("actualizar").addEventListener("click",function() {cambiarOp("update")});
    function cambiarOp(tipo)
    {
        document.querySelector("input[name='op']").value = tipo;
        document.getElementById("crud").submit();
    }
</script>