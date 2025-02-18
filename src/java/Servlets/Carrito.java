/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@WebServlet(name = "Carrito", urlPatterns = {"/Carrito"})
public class Carrito extends HttpServlet {

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
            out.println("<title>Servlet Carrito</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Carrito at " + request.getContextPath() + "</h1>");
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
        //obtener el carrito de compras de la sesion
        HttpSession session = request.getSession();
        List<String> Carrito = (List<String>) session.getAttribute("Carrito");
        if(Carrito == null ){
            Carrito = new ArrayList<>();
            session.setAttribute("Carrito",Carrito);
        }
        String producto = request.getParameter("producto");
        
        if (producto != null){
            Carrito.add(producto);
        }
        //mostrar el producto
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html></body>");
        out.println("<h2>Carrito de compras<h2>");
        out.println("<ul>");
        for(String item : Carrito){
            out.println("<li>"+ item +"</li>");
        }
        out.println("</ul>");
        out.println("<br>");
        out.println("<a href='Tienda.jsp'> Seguir comprando </a>");
        out.println("<br><br>");
        out.println("<a href='CalcularCarrito'> Visualizar Carrito</a>");
        out.println("<br><br>");
        out.println("</body></html>");
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
