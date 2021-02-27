import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Practice2 extends HttpServlet
{
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)throws ServletException
  {
    try{
      String carname = request.getParameter("cars");

      ServletContext sc = getServletContext();

      response.setContentType("text/html; charset=UTF-8");

      if(carname.length() !=0){
        PrintWriter pw = response.getWriter();
        pw.println("<!DOCTYPE html><html>\n"
        + "<head><title>\n" + carname
        + "</title></head>\n"
        + "<body><div style=\"text-align: center;\">\n"
        + "<h2>\n" + carname
        + "</h2>\n" + carname
        + "のお買い上げありがとうございました。<br/>\n"
        + "</div></body>\n"
        + "</html>\n");
      }
      else{
        sc.getRequestDispatcher("/error.html")
        .forward(request, response);
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}