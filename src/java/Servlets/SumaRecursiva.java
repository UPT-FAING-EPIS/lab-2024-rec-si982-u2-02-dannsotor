/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "SumaRecursiva", urlPatterns = {"/SumaRecursiva"})
public class SumaRecursiva extends HttpServlet {
    
    public enum Estados {
    FORMULARIO, RESPUESTA, ERROR;
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SumaRecursiva</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SumaRecursiva at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        PrintWriter out = response.getWriter();
        Estados estado= Estados.FORMULARIO;
        int n1=0 , n2 = 0 , suma = 0;
        String msgError="";
        
        try{
            if(request.getParameterMap().size()>0){
                estado=Estados.RESPUESTA;
                
                n1=Integer.parseInt(request.getParameter("num1"));
                n2=Integer.parseInt(request.getParameter("num2"));
                suma= n1+n2;
            }
        }catch(Exception ex){
            estado = Estados.ERROR;
            msgError = ex.getMessage();
        }
        out.println("<html><body>");
        out.println("<h1>Suma de 2 numeros</h1>");
        out.println("<br>");
        if(estado == Estados.FORMULARIO){
            out.println("<form name='FrmSuma' action='SumaRecursiva'"+"method='get'>");
            out.println("Numero 1: ");
            out.println("<input type='text' name='num1' maxlenght='5' size='8' id='num1' />");
            out.println("<br>");
            out.println("Numero 2: ");
            out.println("<input type='text' name='num2' maxlenght='5' size='8' id='num2' />");
            out.println("<br>");
            out.println("<input type='submit' name='procesar' id='procesar' value='Calcular' />");
            out.println("<input type='reset'  value='Cancelar' />");
        }
        else if(estado==Estados.RESPUESTA){
            out.println("<p>Numero 1:"+n1+"</p>");
            out.println("<p>Numero 2:"+n2+"</p>");
            out.println("<p><b>Suma :"+suma+"</b></p>");
            out.println("<a href='SumaRecursiva'> Otra Suma</a>");
        }
        else{
            out.println("<h3>Error</h3>");
            out.println("<p>Los datos ingresados no son los correctos</p>");
            out.println("<p>Mensaje:" +msgError+"</p>");
            out.println("<a href='SumaRecursiva'> otra Suma</a>");
            
        }
        out.println("<br>");
        out.println("</body></html>");
        out.close();
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
