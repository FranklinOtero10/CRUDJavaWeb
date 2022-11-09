package entidad;

public class Empleado {
    private int idEmpleado;
    private String nombre_empleado;
    private double sueldo;

    public Empleado(int idEmpleado, String nombre_empleado, double sueldo) {
        this.idEmpleado = idEmpleado;
        this.nombre_empleado = nombre_empleado;
        this.sueldo = sueldo;
    }

    public Empleado() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
}
