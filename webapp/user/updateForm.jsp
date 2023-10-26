<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>KUIT</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/styles.css" rel="stylesheet">
  </head>
  <body>
    <%@ include file="/include/navigation.jspf" %>

    <div class="container" id="main">

        <main class="form-signin">

          <form name="sign-up" method="post" action="/user/update">
            <div class="form-floating">
              <input type="text" class="form-control" value="${user.userId}" id="userId" name="userId" placeholder="Id" readonly>
              <label for="userId">User Id</label>
            </div>
            <div class="form-floating">
              <input type="password" class="form-control" value="${user.password}" id="password" name="password" placeholder="Password">
              <label for="password">Password</label>
            </div>
            <div class="form-floating">
              <input type="text" class="form-control" value="${user.name}" id="name" name="name" placeholder="name">
              <label for="name">Name</label>
            </div>
            <div class="form-floating">
              <input type="email" class="form-control" value="${user.email}" id="email" name="email" placeholder="name@example.com">
              <label for="email">Email address</label>
            </div>
            <div style="height:10px;">
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit">Sign up</button>
          </form>
        </main>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../js/scripts.js"></script>
  </body>
</html>