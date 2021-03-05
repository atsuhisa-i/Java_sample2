<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>

<%!
  HttpSession hs;
  Integer cn;
  Date dt;
  String str1, str2;
%>
<%
  hs = request.getSession(true);
  cn = (Integer) hs.getAttribute("count");
  dt = (Date) hs.getAttribute("date");

  if(cn == null){
    cn = new Integer(1);
    dt = new Date();
    str1 = "初めてのお越しですね。";
    str2 = "";
  }
  else{
    cn = new Integer(cn.intValue() + 1);
    dt = new Date();
    str1 = cn + "回目のお越しですね。";
    str2 = "(前回：" + dt + ")";
  }

  hs.setAttribute("count", cn);
  hs.setAttribute("date", dt);
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>サンプル</title>
</head>
<body>
  <div style="text-align: center;">
    <h2>ようこそ</h2>
    <%= str1 %><br/>
    <%= str2 %><br/>
    お選びください。<br/>
    <a href="car1.html">乗用車</a><br/>
    <a href="car2.html">トラック</a><br/>
    <a href="car3.html">オープンカー</a><br/>
  </div>
</body>
</html>