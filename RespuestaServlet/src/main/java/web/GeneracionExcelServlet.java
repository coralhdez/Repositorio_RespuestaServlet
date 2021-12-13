

package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Indicamos el tipo de respuesta
        response.setContentType("application/vnd.ms-excel");
        
        //indicamos que cuando haga click en el link se descargue el documento
        response.setHeader("Content-Disposition", "attachment; filename=excelEjemplo.xls");
        //vamos a usar otros 3 headers
        response.setHeader("Pragme", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", -1); // que se vaya el documento
        
        //Depslegamos información en el cliente
        PrintWriter out = response.getWriter();
        out.println("\t Valores"); //\t para que la 1ª columna del excel esté vacía
        out.println("\t1");
        out.println("\t5");
        out.println("Total\t=SUMA(B2:B3)");
        out.close();
        
        
    }
  
}
