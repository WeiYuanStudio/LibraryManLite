<%@ page import="club.piclight.LibraryManLite.Model.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="./style/userinfo.css">
</head>
<body>
<div class="main-page">
    <div id="logo-l"  onclick="window.location.href='./index'">
        Library Man
    </div>
    <%
        User user = (User) request.getSession().getAttribute("user");
        if(user == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/loginfailed.html");
            dispatcher.forward(request, response);
        }
    %>
    <div id="userinfo-panel">
        <table>
            <tr>
                <td>UID:</td><td><%= user.getUid() %></td>
            </tr>
            <tr>
                <td>User Name:</td><td><%= user.getUsername() %></td>
            </tr>
            <tr>
                <td>Gender:</td><td><%= user.getGender() %></td>
            </tr>
            <tr>
                <td>Mail:</td><td><%= user.getMail() %></td>
            </tr>
            <tr>
                <td>Password:</td><td><%= user.getPassword() %></td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
