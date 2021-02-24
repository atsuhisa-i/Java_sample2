import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sample4 extends HttpServlet
{
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)throws ServletException
  {
    try{
      HttpSession hs = request.getSession(true);
      Integer cn = (Integer) hs.getAttribute("count");
      Date dt = (Date) hs.getAttribute("date");

      String str1, str2;

      if(cn == null){
        cn = Integer.valueOf(1);
        dt = new Date();
        str1 = "初めてのお越しですね。";
        str2 = "";
      }
      else{
        cn = Integer.valueOf(cn.intValue() + 1);
        str1 = cn + "回目のお越しですね。";
        str2 = "(前回：" + dt + ")";
        dt = new Date();
      }

      hs.setAttribute("count", cn);
      hs.setAttribute("date", dt);

      response.setContentType("text/html; charset=UTF-8");

      PrintWriter pw = response.getWriter();
      pw.println("<!DOCTYPE html><html>\n"
        + "<head><title>サンプル</title></head>\n"
        + "<body><div style=\"text-align: center;\">\n"
        + "<h2>ようこそ</h2>"
        + "<hr/>\n"
        + str1 + "<br/>\n"
        + str2 + "<br/>\n"
        + "お選びください。<br/>\n"
        + "<br/>\n"
        + "<a href=\"../car1.html\">乗用車</a><br/>\n"
        + "<a href=\"../car2.html\">トラック</a><br/>\n"
        + "<a href=\"../car3.html\">オープンカー</a><br/>\n"
        + "</div></body>\n"
        + "</html>\n");
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}