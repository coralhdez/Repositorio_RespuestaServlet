
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/HoraServlet")
public class HoraServlet  extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
     
        response.setContentType("text/html;chartset=UTF-8"); //indicamos el tipo de respuesta, html
        
        //vamos a usar el header que nos permite refrescar ka información del navegador cada segundo.
        response.setHeader("refresh", "1"); //que la respuesta del navegador se refresque cada segundo
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("HH:mm:ss"); //establecemos el formato fecha
        String horaConFormato = formatoFecha.format(fecha); //Aplicamos el formato a la fecha
        PrintWriter out = response.getWriter();
        out.print("Hora actualizada: " + horaConFormato);
        out.close();
        
    }
}
