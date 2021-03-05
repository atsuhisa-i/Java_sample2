<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="cb" class="mybeans.CarBean" scope="request"/>

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
    <h2>御礼</h2>
    <jsp:getProperty name="cb" property="cardata"/>
    のお買い上げありがとうございました。<br/>
  </div>
</body>
</html>