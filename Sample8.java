import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sample8 extends HttpServlet
{
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)
  throws ServletException
  {
    try{
      response.setContentType(
        "text/html; charset=UTF-8");
      
      PrintWriter pw = response.getWriter();
      pw.println(
        "<!DOCTYPE html><html>\n" +
        "<head><title>サンプル</title></head>\n" +
        "<body><div style=\"text-align: center;\">\n" +
        "<h2>おめでとうございます。</h2>" +
        "<hr/>\n" +
        "認証に成功しました。<br/>\n" +
        "お選びください。<br/>\n" +
        "<br/>\n" +
        "<a href=\"../car1.html\">乗用車</a><br/>\n" +
        "<a href=\"../car2.html\">トラック</a><br/>\n" +
        "<a href=\"../car3.html\">オープンカー</a><br/>\n" +
        "</div></body>\n" +
        "</html>\n");
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}