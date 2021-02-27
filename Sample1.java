import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sample1 extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException
  {
    try{
      response.setContentType("text/html; charset=UTF-8");

      Date dt = new Date();

      PrintWriter pw = response.getWriter();
      pw.println("<!DOCTYPE html><html>\n" 
        + "<head><title>サンプル</title></head>\n" 
        + "<body><div style=\"text-align: center;\">\n" 
        + "<h2>ようこそ</h2>" 
        + "<hr/>\n" 
        + "今" + dt + "です。<br/>\n"
        + "お選びください。<br/>\n"
        + "<br/>\n"
        + "<a href=\"../car1.html\">乗用車</a><br/>\n"
        + "<a href=\"../car2.html\">トラック</a><br/>\n"
        + "<a href=\"../car3.html\">オープンカー</a><br/>\n"
        + "</div></body>\n");
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}