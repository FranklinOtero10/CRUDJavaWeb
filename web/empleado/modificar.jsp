<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar empleado</title>
        <link rel="stylesheet" href="static/css/estilos.css"/>
    </head>
    <body>
        <h1 class="titulo">Actualizar empleado</h1>
        <div class="login" style="margin-top: 30px">
            <form action="Empleado?accion=actualizar" method="post">
                <input type="hidden" name="txtIdempleado" value="${e.idEmpleado}">
                <label class="etiqueta">Nombres:</label>
                <input type="text" name="txtNombres" class="textbox" value="${e.nombre_empleado}">
                <label class="etiqueta">Sueldo</label>
                <input type="number" name="txtSueldo" class="textbox" value="${e.sueldo}">
                <input type="submit" value="Guardar" class="btn-submit">
            </form>
        </div>
    </body>
</html>

