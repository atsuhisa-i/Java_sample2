import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Practice1 extends HttpServlet
{
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)throws ServletException
  {
    try{
      String personname = request.getParameter("person");

      ServletContext sc = getServletContext();

      response.setContentType("text/html; charset=UTF-8");

      if(personname.length() !=0){
        PrintWriter pw = response.getWriter();
        pw.println("<!DOCTYPE html><html>\n"
        + "<head><title>\n" + personname 
        + "</title></head>\n"
        + "<body><div style=\"text-align: center;\">\n"
        + "<h2>\nようこそ"
        + "</h2>\n" + personname
        + "さん、いらっしゃいませ。<br/>\n"
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
