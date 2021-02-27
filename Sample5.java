import javax.servlet.*;
import javax.servlet.http.*;

public class Sample5 extends HttpServlet
{
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)throws ServletException
  {
    try{
      String carname = request.getParameter("cars");

      ServletContext sc = getServletContext();

      if(carname.length() !=0){
        sc.getRequestDispatcher("/thanks.html").forward(request, response);
      }
      else{
        sc.getRequestDispatcher("/error.html").forward(request, response);
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}