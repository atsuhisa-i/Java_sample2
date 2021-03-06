package main;
import mybeans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Practice3 extends HttpServlet
{
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)throws ServletException
  {
    try{
      String carname = request.getParameter("cars");

      CarBean cb = new CarBean();
      cb.setCarname(carname);
      cb.makeCardata();

      request.setAttribute("cb", cb);

      ServletContext sc = getServletContext();

      if(carname.length() == 0){
        sc.getRequestDispatcher("/error.html").forward(request, response);
      }
      else if(carname.equals("タクシー")){
        sc.getRequestDispatcher("/Practice3T.jsp").forward(request, response);
      }
      else{
        sc.getRequestDispatcher("/Practice3.jsp").forward(request, response);
      }
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}