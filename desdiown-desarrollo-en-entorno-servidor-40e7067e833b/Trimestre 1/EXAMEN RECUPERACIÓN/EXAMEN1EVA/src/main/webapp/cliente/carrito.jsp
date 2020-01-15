<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<a href="/panel">VOLVER AL INICIO</a></br>
<a href="/cliente/carrito?op=checkout">COMPRAR</a></br>
<c:if test = "${compraOK != null && !compraOK}">
    La compra no se ha podido procesar.</br>
</c:if>
<c:if test = "${compraOK != null && compraOK}">
    La compra se procesó correctamente.</br>
</c:if>
<c:if test = "${cuentaSinFondosMsg != null && cuentaSinFondosMsg}">
    ¡NO TIENES FONDOS SUFICIENTES PARA REALIZAR DICHA COMPRA!</br>
</c:if>
    
<c:if test = "${fn:length(productos) == 0}">
    No se han encontrado productos en el carrito.
</c:if>
<c:if test = "${fn:length(productos) > 0}">
    </br>
    Precio total: <c:out value="${precioTotal}"/> €
    </br>
    <c:forEach items="${productos}" var="producto">
        <div>
            ------- PRODUCTO ---------- </br>
            Nombre: <c:out value="${producto.nombre}"/> </br>
            Precio: <c:out value="${producto.precio}"/> </br>
            Categoría: <c:out value="${producto.categoria}"/> </br>
            Cantidad: <c:out value="${producto.unidades}"/> </br>
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