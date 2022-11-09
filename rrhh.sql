create database rrhh;
use rrhh;

create table empleados(
	idempleado int primary key auto_increment,
    nombre_empleado varchar(150),
    sueldo decimal(9,2)
)engine=innodb;

select idempleado, nombre_empleado, sueldo from empleados;
select idempleado, nombre_empleado, sueldo from empleados where idempleado = 1;
insert into empleados (nombre_empleado, sueldo) values ('Juan Perez', 365.50);
insert into empleados (nombre_empleado, sueldo) values ('Carlos Perez', 450.50);
update empleados set nombre_empleado = 'Carlos Diaz', sueldo = 500.75 where idempleado = 2;
delete from empleados where idempleado = 2