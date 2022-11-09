package operaciones;

import java.sql.*;
import java.util.*;
import entidad.Empleado;

public class OperacionesSQL {

    private Connection conexion;

    private void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(""
                    + "jdbc:mysql://localhost/rrhh?autoReconnect=true&useSSL=false",
                    "root", "admin");
        } catch (Exception e) {
        }
    }

    public List<Empleado> listarEmpleado() {
        List<Empleado> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "select idempleado, nombre_empleado, sueldo from empleados;";
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empleado e
                        = new Empleado(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getDouble(3));
                lista.add(e);
            }
            return lista;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            this.desconectar();
        }
    }

    public int insertarEmpleado(Empleado e) {
        try {
            this.conectar();
            String sql = "insert into empleados (nombre_empleado, sueldo) "
                    + "values(?,?);";
            PreparedStatement ps = this.conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, e.getNombre_empleado());
            ps.setDouble(2, e.getSueldo());
            return ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        } finally {
            this.desconectar();
        }
    }

    public Empleado getEmpleado(int idempleado) {
        try {
            this.conectar();
            String sql = "select idempleado, nombre_empleado, sueldo from empleados where idempleado = ?;";
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setInt(1, idempleado);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Empleado(rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            this.desconectar();
        }
    }

    public int eliminarEmpleado(int idempleado) {
        try {
            this.conectar();
            String sql = "delete from empleados where idempleado =" + idempleado;
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        } finally {
            desconectar();
        }
    }
    public int modificarEmpleado(Empleado e) {
        try {
            this.conectar();
            String sql = "update empleados set nombre_empleado = ?, sueldo = ? where idempleado = ?;";
            PreparedStatement ps = this.conexion.prepareStatement(sql);
            ps.setString(1, e.getNombre_empleado());
            ps.setDouble(2, e.getSueldo());
            ps.setInt(3, e.getIdEmpleado());
            return ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        } finally {
            desconectar();
        }
    }

    private void desconectar() {
        try {
            conexion.close();
        } catch (Exception e) {
        }
    }
}
