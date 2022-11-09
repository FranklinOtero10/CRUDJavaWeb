<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="static/css/estilos.css"/>
        <title>Insertar empleado</title>
    </head>
    <body>
        <h1 class="titulo">Nuevo empleado</h1>
        <div class="login" style="margin-top: 30px">
            <form action="Empleado?accion=guardar" method="post">
                <label class="etiqueta">Nombres</label>
                <input type="text" name="txtNombres" class="textbox">
                <label class="etiqueta">Sueldo</label>
                <input type="number" name="txtSueldo" class="textbox">
                <input type="submit" value="Guardar" class="btn-submit">
            </form>
        </div>
    </body>
</html>

