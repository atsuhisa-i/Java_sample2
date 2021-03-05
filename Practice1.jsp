<%@ page contentType="text/html; charset=UTF-8" %>
<% String name = request.getParameter("person"); %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title><%= name %></title>
</head>
<body>
  <div style="text-align: center;">
    <h2>ようこそ</h2>
    <%= name %>
    さん、いらっしゃいませ。<br/>
  </div>
</body>
</html>