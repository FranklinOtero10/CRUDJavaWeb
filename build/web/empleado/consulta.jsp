<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
    </head>
    <body>
        <h1>Lista de Empleados</h1>
        <a href="Empleado?accion=nuevo">Nuevo</a><br><br>
        <table border="1" cellpadding="4">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombres</th>
                    <th>Sueldo</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
        <c:forEach var="e" items="${lista}">
            <tr>
                <td>${e.idEmpleado}</td>
                <td>${e.nombre_empleado}</td>
                <td>${e.sueldo}</td>
                <td>
                    <a href="Empleado?accion=modificar&id=${e.idEmpleado}">Modificar</a> | 
                    <a href="Empleado?accion=eliminar&id=${e.idEmpleado}" onclick="return confirm('Estás seguro que deseas eliminar el registro?');">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
            </tbody>
       </table>
    </body>
</html>