<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<a href="/panel">VOLVER AL INICIO</a></br>
<c:if test = "${agregadoCarrito != null && agregadoCarrito}">
    Producto agregado correctamente al carrito.</br>
</c:if>
<c:if test = "${agregadoCarrito != null && !agregadoCarrito}">
    Producto NO agregado al carrito (fuera de stock).</br>
</c:if>
<form>
    <input type="hidden" name="op" value="buscar" />
    <input type="text" name="cat" placeholder="Categoría" />
    <input type="submit" value="Buscar">
</form>
</br>
<c:if test = "${buscado && fn:length(productos) == 0}">
    No se han encontrado productos.
</c:if>
<c:if test = "${productos != null}">
    <c:forEach items="${productos}" var="producto">
        <div>
            ------- PRODUCTO ---------- </br>
            Nombre <c:out value="${producto.nombre}"/> </br>
            Precio <c:out value="${producto.precio}"/> </br>
            Stock <c:out value="${producto.unidades}"/> </br>
            Categoría <c:out value="${producto.categoria}"/> </br>
            Quiero la cantidad... <input type="number" name="cantidad-${producto.nombre}" value="0"/></br>
            <button class="addcarrito" onclick="addToCarrito('${producto.nombre}')">AÑADIR AL CARRITO</button></br>
            ---------------------------
        </div>
    </c:forEach>
</c:if>
<script>
    function addToCarrito(nombreProducto)
    {
        var cantidad = document.querySelector("input[name='cantidad-" + nombreProducto + "']").value;
        window.location = "addproductos?op=addcarrito&nombre_producto=" + nombreProducto + "&cantidad=" + cantidad;
    }
</script>