<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Collection" %>
<%@ page import="jwp.model.User" %>


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
        <table class="table table-striped">
            <thead class="col-md-12">
            <tr>
                <th class="col-md-3">아이디</th>
                <th class="col-md-3">이름</th>
                <th class="col-md-3">이메일</th>
                <th class="col-md-3">#</th>

            </tr>
            </thead>
            <tbody>
            <%
                Collection<User> users = (Collection<User>) request.getAttribute("users");
                for (User user : users) {
            %>
            <tr>
                <th class="col-md-3"><%= user.getUserId() %>
                </th>
                <th class="col-md-3"><%= user.getName() %>
                </th>
                <th class="col-md-3"><%= user.getEmail() %>
                </th>
                <th class="col-md-3"><a href="#" class="btn btn-success" role="button">수정</a></th>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../js/scripts.js"></script>
</body>
</html>