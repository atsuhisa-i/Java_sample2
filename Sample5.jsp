<%@ page contentType="text/html; ; charset=UTF-8" %>
<% String carname = request.getParameter("cars"); %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title><%= carname %></title>
</head>
<body>
  <div style="text-align: center;">
    <h2><%= carname %></h2>
    <%= carname %>
    のお買い上げありがとうございました。<br/>
  </div>
</body>
</html>