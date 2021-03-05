<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>

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
    <img src="car.gif"/><br/>
    <h2>ようこそ</h2>
    <hr/>
    今<%= new Date() %>です。<br/>
    お選びください。<br/>
    <br/>
    <a href="car1.html">乗用車</a><br/>
    <a href="car2.html">トラック</a><br/>
    <a href="car3.html">オープンカー</a><br/>
  </div>
</body>
</html>