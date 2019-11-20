<%@ page import="club.piclight.LibraryManLite.Model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    #header {
        padding: 8px;
        display: flex;
        flex-direction: row-reverse;
    }

    #header a {
        text-decoration: none;
        color: black;
        padding: 4px;
        border-radius: 6px;
        border: solid 2px gray;
        margin: 10px;
    }

    #header a:hover {
        background-color: gray;
    }

    #header span {
        text-decoration: none;
        color: black;
        padding: 4px;
        border-radius: 6px;
        border: solid 2px white;
        margin: 10px;
    }
</style>
<div id="header">
    <%
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
    %>
    <span>Not logged in</span>
    <a href="./registe">Sign in</a>
    <a href="./login">Log in</a>
    <%
    } else {
    %>
    <span>Welcome back, <%= user.getUsername() %></span>
    <a href="./logout">Log out</a>
    <%
        }
    %>
</div>
