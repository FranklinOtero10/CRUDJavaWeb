package control;

import entidad.Empleado;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import operaciones.OperacionesSQL;

@WebServlet(name = "ControlEmpleado", urlPatterns = {"/Empleado"})
public class ControlEmpleado extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OperacionesSQL operaciones =  new OperacionesSQL();
        String accion = request.getParameter("accion");
        if (accion==null){
            request.setAttribute("lista", operaciones.listarEmpleado());
            request.getRequestDispatcher("empleado/consulta.jsp").forward(request, response);
        }else if(accion.equals("nuevo")){
            request.getRequestDispatcher("empleado/insertar.jsp").forward(request, response);
        }else if(accion.equals("guardar")){
            Empleado e = new Empleado(0, 
                    request.getParameter("txtNombres"), 
                    Integer.valueOf(request.getParameter("txtSueldo")));
            if(operaciones.insertarEmpleado(e)>0){
                response.sendRedirect("Empleado?error=0");
            }else{
                response.sendRedirect("Empleado?error=1");
            }           
        }else if(accion.equals("modificar")){
            int id = Integer.valueOf(request.getParameter("id"));
            request.setAttribute("e", operaciones.getEmpleado(id));
            request.getRequestDispatcher("empleado/modificar.jsp").forward(request, response);
        }else if (accion.equals("eliminar")){
            Empleado e = new Empleado();
            int id = Integer.valueOf(request.getParameter("id"));
            e.setIdEmpleado(id);
            int comprobar = operaciones.eliminarEmpleado(id);
            if(comprobar > 0){
                response.sendRedirect("Empleado?error=0");
            }else{
                response.sendRedirect("Empleado?error=1");
            }
        }else if (accion.equals("actualizar")){
            int id = Integer.valueOf(request.getParameter("txtIdempleado"));
            Empleado e = new Empleado(id, 
                  request.getParameter("txtNombres"), 
                  Integer.valueOf(request.getParameter("txtSueldo")));
            int comprobar = operaciones.modificarEmpleado(e);          
            if(comprobar > 0){
                response.sendRedirect("Empleado?error=0");
            }else{
                response.sendRedirect("Empleado?error=1");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
