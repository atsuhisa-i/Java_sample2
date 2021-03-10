package main;
import mybeans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sample4 extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException
  {
    try{
      ServletContext sc = getServletContext();

      CarDBBean cb = new CarDBBean();

      request.setAttribute("cb", cb);

      sc.getRequestDispatcher("/Sample4.jsp").forward(request, response);
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}