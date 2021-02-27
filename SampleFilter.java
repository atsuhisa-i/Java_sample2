import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SampleFilter implements Filter
{
  public void doFilter(ServletRequest request,
    ServletResponse response, FilterChain chain)
  throws IOException, ServletException
  {
    response.setContentType("text/html; charset=UTF-8");

    PrintWriter pw = response.getWriter();
    pw.println("<!DOCTYPE html><html>\n" +
      "<head><title>サンプル</title></head>\n" +
      "<body><div style= \"text-align: center;\">\n" +
      "<h2>こんにちは</h2>" +
      "<hr/>\n");
    
    chain.doFilter(request, response);

    pw.println("<hr/>ありがとうございました。\n" +
      "</div></body>\n" +
      "</html>\n");
  }
  public void init(FilterConfig filterConfig){}
  public void destroy(){}
}